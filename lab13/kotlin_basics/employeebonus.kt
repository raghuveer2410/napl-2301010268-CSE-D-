
fun main() {
    print("Enter Employee Name: ")
    val name = readLine()!!

    print("Enter Department Code (IT/HR/FIN): ")
    val deptCode = readLine()!!.uppercase()

    print("Enter Years of Experience: ")
    val experience = readLine()!!.toInt()

    print("Enter Basic Salary: ")
    val salary = readLine()!!.toDouble()

    val bonusPercentage = when {
        deptCode == "IT" && experience > 5 -> 20
        deptCode == "HR" && experience > 3 -> 15
        deptCode == "FIN" && experience > 4 -> 12
        else -> 10
    }

    val bonusAmount = salary * bonusPercentage / 100

    println("\n----- Employee Details -----")
    println("Employee Name: $name")
    println("Department: $deptCode")
    println("Experience: $experience years")
    println("Basic Salary: Rs. $salary")
    println("Bonus Percentage: $bonusPercentage%")
    println("Bonus Amount: Rs. $bonusAmount")
    println("Total Salary: Rs. ${salary + bonusAmount}")
}
