
open System

// Function to simulate asynchronous tasks
let task1 =
    async {
        printfn "Task 1 started: Downloading data..."
        do! Async.Sleep 3000
        printfn "Task 1 completed!"
        return "Task 1 Result: Data Downloaded"
    }

let task2 =
    async {
        printfn "Task 2 started: Processing data..."
        do! Async.Sleep 2000
        printfn "Task 2 completed!"
        return "Task 2 Result: Data Processed"
    }

let task3 =
    async {
        printfn "Task 3 started: Saving data..."
        do! Async.Sleep 1000
        printfn "Task 3 completed!"
        return "Task 3 Result: Data Saved"
    }

// Main program
[<EntryPoint>]
let main argv =

    printfn "Starting asynchronous parallel execution...\n"

    // Execute all tasks concurrently
    let results =
        [| task1; task2; task3 |]
        |> Async.Parallel
        |> Async.RunSynchronously

    printfn "\nAll tasks completed!"
    printfn "\nCollected Results:"

    // Print all results
    results |> Array.iter (printfn "%s")

    printfn "\nProgram execution finished."

    0
