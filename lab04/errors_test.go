package main

import (
	"strings"
	"testing"
)

func TestDivideValidInput(t *testing.T) {
	got, err := Divide(10, 2)

	if err != nil {
		t.Fatalf(
			"Divide(10, 2) returned unexpected error: %v", err,
		)
	}

	if got != 5 {
		t.Errorf("Divide(10, 2) = %v; want 5", got)
	}
}

func TestDivideByZero(t *testing.T) {
	_, err := Divide(10, 0)

	if err == nil {
		t.Fatal("Divide(10, 0) expected an error, got nil")
	}

	if !strings.Contains(err.Error(), "division by zero") {
		t.Errorf("unexpected error message: %v", err)
	}
}

func TestSquareRootValidInput(t *testing.T) {
	got, err := SquareRoot(25)

	if err != nil {
		t.Fatalf(
			"SquareRoot(25) returned unexpected error: %v", err,
		)
	}

	if got != 5 {
		t.Errorf("SquareRoot(25) = %v; want 5", got)
	}
}

func TestSquareRootNegativeInput(t *testing.T) {
	_, err := SquareRoot(-9)

	if err == nil {
		t.Fatal("SquareRoot(-9) expected an error, got nil")
	}

	if !strings.Contains(err.Error(), "negative square root") {
		t.Errorf("unexpected error message: %v", err)
	}
}

func TestGreetValidInput(t *testing.T) {
	got, err := Greet("Asha")

	if err != nil {
		t.Fatalf(
			"Greet returned unexpected error: %v", err,
		)
	}

	if got != "Hello, Asha!" {
		t.Errorf(
			"Greet = %q; want %q",
			got, "Hello, Asha!",
		)
	}
}

func TestGreetEmptyInput(t *testing.T) {
	_, err := Greet("   ")

	if err == nil {
		t.Fatal("Greet with blank input expected an error, got nil")
	}

	if !strings.Contains(err.Error(), "empty input") {
		t.Errorf("unexpected error message: %v", err)
	}
}
