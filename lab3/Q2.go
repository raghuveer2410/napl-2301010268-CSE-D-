package main

import "fmt"

type Student struct {
	Name  string
	Age   int
	Marks int
}

func updateMarks(marks *int) {
	*marks = 90
}

func updateStudent(s1 *Student) {
	s1.Name = "Vanshika"
	s1.Age = 20
	s1.Marks = 95
}

func main() {

	marks := 75
	p := &marks

	fmt.Println("Default Marks:", marks)
	fmt.Println("Address of Marks:", &marks)
	fmt.Println("Value using pointer:", *p)

	updateMarks(&marks)

	fmt.Println("Marks after function call:", marks)

	student := new(Student)

	fmt.Println("\nDefault Student Values:")
	fmt.Println("Name:", student.Name)
	fmt.Println("Age:", student.Age)
	fmt.Println("Marks:", student.Marks)

	updateStudent(student)

	fmt.Println("\nUpdated Student Values:")
	fmt.Println("Name:", student.Name)
	fmt.Println("Age:", student.Age)
	fmt.Println("Marks:", student.Marks)
}
