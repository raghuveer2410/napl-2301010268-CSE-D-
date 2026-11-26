fun main() {
    // 1. Nullable and non-nullable variables
    var name: String = "Raghuveer"
    var nullableName: String? = null

    // name = null  // Compile-time error
    nullableName = null  // Allowed

    println("Non-nullable: $name")
    println("Nullable: $nullableName")

    // 2. Safe call operator (?.)
    println("Length: ${nullableName?.length}")

    // 3. Elvis operator (?:)
    val result = nullableName ?: "Default Name"
    println("Default value: $result")

    // 4. !! operator with try-catch
    try {
        println(nullableName!!.length)
    } catch (e: NullPointerException) {
        println("NullPointerException caught!")
    }
}