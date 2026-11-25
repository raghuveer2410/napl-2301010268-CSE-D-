
// Higher-Order Functions in F#

// 1. List.map - Square each element
let numbers1 = [1; 2; 3; 4; 5]
let numbers2 = [6; 7; 8; 9; 10]

let square1 = List.map (fun x -> x * x) numbers1
let square2 = List.map (fun x -> x * x) numbers2

printfn "LIST.MAP - Squaring Elements"
printfn "Original List 1: %A" numbers1
printfn "Squared List 1: %A" square1
printfn "Original List 2: %A" numbers2
printfn "Squared List 2: %A" square2


// 2. List.filter - Select even numbers
let even1 = List.filter (fun x -> x % 2 = 0) numbers1
let even2 = List.filter (fun x -> x % 2 = 0) numbers2

printfn "\nLIST.FILTER - Selecting Even Numbers"
printfn "Original List 1: %A" numbers1
printfn "Even Numbers 1: %A" even1
printfn "Original List 2: %A" numbers2
printfn "Even Numbers 2: %A" even2


// 3. List.fold - Calculate sum and product
let sum1 = List.fold (fun acc x -> acc + x) 0 numbers1
let sum2 = List.fold (fun acc x -> acc + x) 0 numbers2

let product1 = List.fold (fun acc x -> acc * x) 1 numbers1
let product2 = List.fold (fun acc x -> acc * x) 1 numbers2

printfn "\nLIST.FOLD - Aggregating Elements"
printfn "List 1: %A" numbers1
printfn "Sum of List 1: %d" sum1
printfn "Product of List 1: %d" product1

printfn "List 2: %A" numbers2
printfn "Sum of List 2: %d" sum2
printfn "Product of List 2: %d" product2
