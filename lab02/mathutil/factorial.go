package mathutil

func Fact(a int) int {
	fact := 1

	for i := 1; i <= a; i++ {
		fact = fact * i
	}

	return fact
}
