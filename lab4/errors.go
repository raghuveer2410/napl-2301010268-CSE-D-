package main

import (
	"fmt"
	"math"
	"strings"
)

// Divide returns a/b and handles division by zero.
func Divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf(
			"division by zero: denominator must not be zero",
		)
	}

	return a / b, nil
}

// SquareRoot returns the square root of a non-negative number.
func SquareRoot(n float64) (float64, error) {
	if n < 0 {
		return 0, fmt.Errorf(
			"negative square root: cannot calculate sqrt(%g)", n,
		)
	}

	return math.Sqrt(n), nil
}

// Greet returns a greeting for a non-empty name.
func Greet(name string) (string, error) {
	name = strings.TrimSpace(name)

	if name == "" {
		return "", fmt.Errorf(
			"empty input: name must not be blank",
		)
	}

	return fmt.Sprintf("Hello, %s!", name), nil
}
