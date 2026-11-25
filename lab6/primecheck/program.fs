open System

// Recursive function to check prime number
let rec isPrime n divisor =
    if n < 2 then
        false
    elif divisor * divisor > n then
        true
    elif n % divisor = 0 then
        false
    else
        isPrime n (divisor + 1)

// Function to check prime
let checkPrime n =
    isPrime n 2

[<EntryPoint>]
let main argv =

    printf "Enter a number: "
    let number = int(Console.ReadLine())

    if checkPrime number then
        printfn "%d is a Prime Number." number
    else
        printfn "%d is Not a Prime Number." number

    // Testing three sets of inputs
    printfn "\nTest Cases:"

    [ 7; 10; 13 ]
    |> List.iter (fun n ->
        if checkPrime n then
            printfn "%d is Prime" n
        else
            printfn "%d is Not Prime" n
    )

    0