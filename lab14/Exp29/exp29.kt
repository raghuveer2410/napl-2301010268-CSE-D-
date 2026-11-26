data class Student(val name: String, val percentage: Double)

fun main() {
    // 1. List
    val readList = listOf(10, 20, 30)
    val mutableList = mutableListOf(10, 20, 30)
    mutableList.add(40)
    mutableList.remove(10)
    println("List: $readList")
    println("Mutable List: $mutableList")
    println("Contains 20: ${mutableList.contains(20)}")

    // 2. Set
    val readSet = setOf(1, 2, 3)
    val mutableSet = mutableSetOf(1, 2, 3)
    mutableSet.add(4)
    mutableSet.remove(1)
    println("Set: $readSet")
    println("Mutable Set: $mutableSet")
    println("Contains 2: ${mutableSet.contains(2)}")

    // 3. Map
    val readMap = mapOf("A" to 10, "B" to 20)
    val mutableMap = mutableMapOf("A" to 10, "B" to 20)
    mutableMap["C"] = 30
    mutableMap.remove("A")
    println("Map: $readMap")
    println("Mutable Map: $mutableMap")
    println("Get B: ${mutableMap["B"]}")

    // 4. Functional transformations
    val numbers = listOf(1, 2, 3, 4, 5)
    println("Original: $numbers")
    println("Map (squares): ${numbers.map { it * it }}")
    println("Filter (even): ${numbers.filter { it % 2 == 0 }}")
    println("Reduce (sum): ${numbers.reduce { a, b -> a + b }}")

    // 5. Sorting students
    val students = listOf(
        Student("Aman", 85.5),
        Student("Riya", 92.0),
        Student("Karan", 76.0)
    )
    println("Sorted: ${students.sortedByDescending { it.percentage }}")

    // 6. Grouping
    val grouped = students.groupBy {
        if (it.percentage >= 80) "Distinction" else "Pass"
    }
    println("Grouped: $grouped")
}