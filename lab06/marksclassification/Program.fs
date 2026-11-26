open System

[<EntryPoint>]
let main argv =

    printf "Enter marks for Subject 1: "
    let m1 = int(Console.ReadLine())

    printf "Enter marks for Subject 2: "
    let m2 = int(Console.ReadLine())

    printf "Enter marks for Subject 3: "
    let m3 = int(Console.ReadLine())

    printf "Enter marks for Subject 4: "
    let m4 = int(Console.ReadLine())

    // Calculate total and percentage
    let total = m1 + m2 + m3 + m4
    let percentage = float total / 4.0

    // Pattern matching for division
    let division =
        match percentage with
        | p when p >= 60.0 -> "First Division"
        | p when p >= 50.0 -> "Second Division"
        | p when p >= 40.0 -> "Third Division"
        | _ -> "Fail"

    // Display results
    printfn "\nTotal Marks: %d / 400" total
    printfn "Percentage: %.2f%%" percentage
    printfn "Division: %s" division

    0