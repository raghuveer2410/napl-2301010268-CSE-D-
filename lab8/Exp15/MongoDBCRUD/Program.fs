
open System
open MongoDB.Bson
open MongoDB.Driver

[<EntryPoint>]
let main argv =

    // Connect to MongoDB
    let client = MongoClient("mongodb://localhost:27017")

    // Create database and collection
    let database = client.GetDatabase("CollegeDB")

    let collection =
        database.GetCollection<BsonDocument>("Students")

    // Remove previous test record to allow repeated runs
    let filter =
        Builders<BsonDocument>.Filter.Eq("Id", 1)

    collection.DeleteMany(filter) |> ignore

    // Function to display student records
    let displayStudents () =
        printfn "\nStudent Records:"

        let students =
            collection.Find(Builders<BsonDocument>.Filter.Empty).ToList()

        if students.Count = 0 then
            printfn "No records found."

        for student in students do
            printfn "ID: %d | Name: %s | Age: %d"
                (student["Id"].AsInt32)
                (student["Name"].AsString)
                (student["Age"].AsInt32)

    // CREATE
    let student = BsonDocument()
    student.Add("Id", BsonInt32(1))
    student.Add("Name", BsonString("Amit"))
    student.Add("Age", BsonInt32(22))

    collection.InsertOne(student)

    printfn "CREATE: Student inserted successfully."
    displayStudents()

    // READ
    printfn "\nREAD: Fetching student records."
    displayStudents()

    // UPDATE
    let update =
        Builders<BsonDocument>.Update
            .Set("Name", "Amit Kumar")

    collection.UpdateOne(filter, update) |> ignore

    printfn "\nUPDATE: Student updated successfully."
    displayStudents()

    // DELETE
    collection.DeleteOne(filter) |> ignore

    printfn "\nDELETE: Student deleted successfully."
    displayStudents()

    0
