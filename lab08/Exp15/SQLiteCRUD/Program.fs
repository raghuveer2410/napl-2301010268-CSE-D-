
open System
open Microsoft.Data.Sqlite

[<EntryPoint>]
let main argv =

    // Connect to SQLite database
    use connection =
        new SqliteConnection("Data Source=students.db")

    connection.Open()

    // Create table
    let createTable =
        "CREATE TABLE IF NOT EXISTS Students (
            Id INTEGER PRIMARY KEY,
            Name TEXT NOT NULL,
            Age INTEGER NOT NULL
        )"

    use createCommand =
        new SqliteCommand(createTable, connection)

    createCommand.ExecuteNonQuery() |> ignore

    // Display function
    let displayStudents () =
        printfn "\nStudent Records:"

        use command =
            new SqliteCommand("SELECT * FROM Students", connection)

        use reader = command.ExecuteReader()

        if not reader.HasRows then
            printfn "No records found."

        while reader.Read() do
            printfn "ID: %d | Name: %s | Age: %d"
                (reader.GetInt32(0))
                (reader.GetString(1))
                (reader.GetInt32(2))

    // CREATE
    use insertCommand =
        new SqliteCommand(
            "INSERT OR REPLACE INTO Students
             (Id, Name, Age) VALUES (@id, @name, @age)",
            connection)

    insertCommand.Parameters.AddWithValue("@id", 1) |> ignore
    insertCommand.Parameters.AddWithValue("@name", "Rahul") |> ignore
    insertCommand.Parameters.AddWithValue("@age", 20) |> ignore

    insertCommand.ExecuteNonQuery() |> ignore

    printfn "CREATE: Student inserted successfully."
    displayStudents()

    // READ
    printfn "\nREAD: Fetching student records."
    displayStudents()

    // UPDATE
    use updateCommand =
        new SqliteCommand(
            "UPDATE Students SET Name=@name, Age=@age WHERE Id=@id",
            connection)

    updateCommand.Parameters.AddWithValue("@name", "Rahul Sharma") |> ignore
    updateCommand.Parameters.AddWithValue("@age", 21) |> ignore
    updateCommand.Parameters.AddWithValue("@id", 1) |> ignore

    updateCommand.ExecuteNonQuery() |> ignore

    printfn "\nUPDATE: Student updated successfully."
    displayStudents()

    // DELETE
    use deleteCommand =
        new SqliteCommand(
            "DELETE FROM Students WHERE Id=@id",
            connection)

    deleteCommand.Parameters.AddWithValue("@id", 1) |> ignore
    deleteCommand.ExecuteNonQuery() |> ignore

    printfn "\nDELETE: Student deleted successfully."
    displayStudents()

    0

