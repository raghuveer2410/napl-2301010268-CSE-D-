package main

import "fmt"

func main() {
	// Slice operations
	students := []string{"Aman", "Diya", "Rohan"}
	fmt.Println("Initial Slice:", students)

	// Add
	students = append(students, "Priya")
	fmt.Println("After Adding:", students)

	// Remove by index
	index := 1
	students = append(students[:index], students[index+1:]...)
	fmt.Println("After Removing Index 1:", students)

	// Update
	students[1] = "Rahul"
	fmt.Println("After Updating Index 1:", students)

	// Map operations
	marks := map[string]int{
		"Math":    85,
		"English": 78,
	}
	fmt.Println("\nInitial Map:", marks)

	// Insert
	marks["Science"] = 92
	fmt.Println("After Inserting Science:", marks)

	// Delete
	delete(marks, "English")
	fmt.Println("After Deleting English:", marks)

	// Lookup
	if mark, found := marks["Math"]; found {
		fmt.Println("Marks in Math:", mark)
	}

	fmt.Println("Final Map:", marks)

}
