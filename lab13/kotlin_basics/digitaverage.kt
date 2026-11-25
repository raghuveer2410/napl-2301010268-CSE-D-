
fun main() {
    print("Enter an integer: ")
    var number = readLine()!!.toLong()

    number = kotlin.math.abs(number)

    var temp = number
    var sum = 0
    var count = 0

    if (temp == 0L) {
        count = 1
        sum = 0
    } else {
        while (temp > 0) {
            val digit = (temp % 10).toInt()
            sum += digit
            count++
            temp /= 10
        }
    }

    val average = sum.toDouble() / count

    println("Sum of digits: $sum")
    println("Number of digits: $count")
    println("Average of digits: $average")
}
