package mathutil

func Pow(a, b int) int {
	result := 1

	for i := 1; i <= b; i++ {
		result = result * a
	}

	return result
}
