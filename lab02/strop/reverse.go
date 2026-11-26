package strop

func Reverse(str string) string {
	reversed := ""

	for i := len(str) - 1; i >= 0; i-- {
		reversed += string(str[i])
	}

	return reversed
}
