open System
open System.Text.RegularExpressions

// 1. Reverse a string
let reverseString (s: string) =
    s |> Seq.rev |> String.Concat

// Check whether string is palindrome
let isPalindrome (s: string) =
    s = reverseString s

// 2. Transform string using pattern matching
let transformString (s: string) =
    match s with
    | x when x <> "" && x |> Seq.forall Char.IsLetter ->
        x.ToUpper()

    | x when x <> "" && x |> Seq.forall Char.IsDigit ->
        let num = Int32.Parse(x)
        (num * 2).ToString()

    | _ -> s

// 3. Validate email using Regex
let isValidEmail (email: string) =
    Regex.IsMatch(
        email,
        @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    )

[<EntryPoint>]
let main argv =

    // Palindrome test cases
    printfn "----- PALINDROME CHECK -----"

    let strings = ["madam"; "hello"; "level"]

    strings |> List.iter (fun s ->
        printfn "Original: %s" s
        printfn "Reversed: %s" (reverseString s)
        printfn "Palindrome: %b\n" (isPalindrome s)
    )

    // String transformation test cases
    printfn "----- STRING TRANSFORMATION -----"

    let inputs = ["hello"; "123"; "abc123"]

    inputs |> List.iter (fun s ->
        printfn "%s -> %s" s (transformString s)
    )

    // Email validation test cases
    printfn "\n----- EMAIL VALIDATION -----"

    let emails = [
        "abc@gmail.com"
        "student@yahoo.com"
        "invalid-email"
    ]

    emails |> List.iter (fun email ->
        printfn "%s -> %b" email (isValidEmail email)
    )

    0