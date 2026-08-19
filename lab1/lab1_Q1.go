package main

import "fmt"

func main() {

	fmt.Println("Hello, Go!")

	var a int = 20
	var b int = 10

	var x float64 = 15.5
	var y float64 = 5.5

	// Integer operations
	fmt.Println("\nInteger Operations:")
	fmt.Println("Addition:", a+b)
	fmt.Println("Subtraction:", a-b)
	fmt.Println("Multiplication:", a*b)

	// Floating-point operations
	fmt.Println("\nFloating-Point Operations:")
	fmt.Println("Addition:", x+y)
	fmt.Println("Subtraction:", x-y)
	fmt.Println("Multiplication:", x*y)
}
