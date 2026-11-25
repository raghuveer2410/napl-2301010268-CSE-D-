data class Course(val name: String, val credits: Int, val seats: Int)
data class Student(val name: String, val email: String?)
data class Registration(val student: Student, val course: Course, val marks: Int)

fun Course.isAvailable() = seats > 0
fun Registration.result() = if (marks >= 40) "Pass" else "Fail"

class CourseCatalog {
    val courses = mutableListOf<Course>()

    fun course(name: String, credits: Int, seats: Int) {
        courses.add(Course(name, credits, seats))
    }
}

fun catalog(block: CourseCatalog.() -> Unit): CourseCatalog {
    val c = CourseCatalog()
    c.block()
    return c
}

fun main() {
    val c = catalog {
        course("Kotlin", 4, 20)
        course("Java", 3, 15)
        course("SQL", 2, 0)
    }

    val s = listOf(
        Student("Aman", "aman@gmail.com"),
        Student("Riya", null)
    )

    val r = listOf(
        Registration(s[0], c.courses[0], 85),
        Registration(s[1], c.courses[1], 35)
    )

    println("Courses: ${r.map { it.course.name }}")
    println("Passed: ${r.filter { it.result() == "Pass" }}")
    println("Total Marks: ${r.map { it.marks }.reduce { a, b -> a + b }}")
    println("Grouped: ${r.groupBy { it.course.name }}")

    println("\nAvailable Courses:")
    c.courses.filter { it.isAvailable() }.forEach { println(it.name) }

    println("\nStudent Emails:")
    s.forEach { println(it.email ?: "Not Provided") }

    println("\nCourse Report:")
    c.courses.forEach {
        println("${it.name} - ${it.credits} credits")
    }
}