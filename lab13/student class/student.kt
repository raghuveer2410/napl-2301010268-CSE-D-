
class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    // Function to accept/update student details
    fun acceptDetails() {
        println("\nEnter Student Details:")

        print("Enter Roll Number: ")
        rollNo = readLine()!!.toInt()

        print("Enter Name: ")
        name = readLine()!!

        print("Enter Course: ")
        course = readLine()!!

        print("Enter Percentage: ")
        percentage = readLine()!!.toDouble()
    }

    // Function to display student details
    fun displayDetails() {
        println("\n========== Student Details ==========")
        println("Roll Number : $rollNo")
        println("Name        : $name")
        println("Course      : $course")
        println("Percentage  : $percentage%")
        println("=====================================")
    }
}

fun main() {

    // Creating first Student object
    val student1 = Student(101, "Rahul", "BCA", 85.5)

    // Creating second Student object
    val student2 = Student(102, "Aman", "BSc IT", 90.2)

    println("----- Student 1 -----")
    student1.acceptDetails()
    student1.displayDetails()

    println("\n----- Student 2 -----")
    student2.acceptDetails()
    student2.displayDetails()
}
