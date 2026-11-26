package main

import (
	"fmt"

	"lab2/mathutil"
	"lab2/strop"
)

func main() {
	var a, b int
	var str string

	fmt.Print("Enter a number for factorial: ")
	fmt.Scan(&a)

	fact := mathutil.Fact(a)
	fmt.Println("Factorial =", fact)

	fmt.Print("Enter base and power: ")
	fmt.Scan(&a, &b)

	power := mathutil.Pow(a, b)
	fmt.Println("Power =", power)

	fmt.Print("Enter a string: ")
	fmt.Scan(&str)

	fmt.Println("Reverse =", strop.Reverse(str))
	fmt.Println("Number of vowels =", strop.CountVowel(str))
}
