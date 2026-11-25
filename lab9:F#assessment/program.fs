open System

type Student(id:int, name:string, marks:int) =
    member this.Id = id
    member this.Name = name
    member this.Marks = marks

let students = [
    Student(1, "Rahul", 85)
    Student(2, "Aman", 45)
    Student(3, "Priya", 70)
]

let names = students |> List.map (fun s -> s.Name)

let passed = students |> List.filter (fun s -> s.Marks >= 60)

let result marks =
    match marks with
    | m when m >= 60 -> "First Division"
    | m when m >= 40 -> "Second Division"
    | _ -> "Fail"

printfn "Student Names: %A" names

printfn "\nStudent Results:"
students |> List.iter (fun s ->
    printfn "%s - %s" s.Name (result s.Marks)
)

printfn "\nPassed Students:"
passed |> List.iter (fun s ->
    printfn "%s" s.Name
)
