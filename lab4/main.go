package main

import (
	"fmt"
	"sync"
)

type Result struct {
	Task  string
	Value string
}

func square(n int, results chan<- Result, wg *sync.WaitGroup) {
	defer wg.Done()

	fmt.Println("Square goroutine: started")

	value := n * n

	results <- Result{
		Task:  "Square",
		Value: fmt.Sprintf("%d² = %d", n, value),
	}

	fmt.Println("Square goroutine: completed")
}

func cube(n int, results chan<- Result, wg *sync.WaitGroup) {
	defer wg.Done()

	fmt.Println("Cube goroutine: started")

	value := n * n * n

	results <- Result{
		Task:  "Cube",
		Value: fmt.Sprintf("%d³ = %d", n, value),
	}

	fmt.Println("Cube goroutine: completed")
}

func fibonacci(n int, results chan<- Result, wg *sync.WaitGroup) {
	defer wg.Done()

	fmt.Println("Fibonacci goroutine: started")

	a, b := 0, 1

	for i := 0; i < n; i++ {
		a, b = b, a+b
	}

	results <- Result{
		Task:  "Fibonacci",
		Value: fmt.Sprintf("Fibonacci(%d) = %d", n, a),
	}

	fmt.Println("Fibonacci goroutine: completed")
}

func main() {
	results := make(chan Result, 3)

	var wg sync.WaitGroup

	wg.Add(3)

	go square(4, results, &wg)
	go cube(3, results, &wg)
	go fibonacci(7, results, &wg)

	go func() {
		wg.Wait()
		close(results)
	}()

	fmt.Println("Main: waiting for results...")

	for result := range results {
		fmt.Printf("%s result: %s\n",
			result.Task, result.Value)
	}

	fmt.Println("Main: all tasks completed")
}
