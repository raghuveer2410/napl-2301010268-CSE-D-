package strop

import "strings"

func CountVowel(str string) int {
	count := 0

	for _, ch := range strings.ToLower(str) {
		if ch == 'a' || ch == 'e' || ch == 'i' ||
			ch == 'o' || ch == 'u' {
			count++
		}
	}

	return count
}
