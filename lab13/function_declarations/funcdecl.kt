
// 1. Function with default parameters
fun displayDetails(
    name: String,
    age: Int = 20,
    city: String = "Delhi"
) {
    println("Name: $name")
    println("Age: $age")
    println("City: $city")
}

// 2. Function demonstrating named arguments
fun calculateArea(length: Int, breadth: Int): Int {
    return length * breadth
}

// 3. Function using vararg
fun printNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (num in numbers) {
        println(num)
    }
}

// 4. Higher-order function accepting a lambda
fun processNumbers(
    numbers: List<Int>,
    operation: (Int) -> Int
): List<Int> {
    return numbers.map(operation)
}

fun main() {

    // Calling function with default parameters
    println("----- Default Parameters -----")
    displayDetails("Rahul")

    println("\nCalling with custom values:")
    displayDetails("Aman", 22, "Mumbai")

    // Calling function using named arguments
    println("\n----- Named Arguments -----")
    val area = calculateArea(breadth = 5, length = 10)
    println("Area of Rectangle: $area")

    // Calling function with vararg
    println("\n----- Vararg Function -----")
    printNumbers(10, 20, 30, 40, 50)

    // Calling higher-order function with lambda
    println("\n----- Higher-Order Function -----")
    val numbers = listOf(1, 2, 3, 4, 5)

    val squares = processNumbers(numbers) { it * it }

    println("Original List: $numbers")
    println("Squared List: $squares")
}
