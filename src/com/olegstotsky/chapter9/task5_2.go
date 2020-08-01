package main

import "fmt"

func permutations(s string) []string {
	if len(s) < 2 {
		return []string{s}
	}
	firstChar := s[0]
	rest := s[1:]
	perms := permutations(rest)
	ans := make([]string, 0, 10)
	for _, perm := range perms {
		for j := 0; j <= len(perm); j++ {
			result := perm[:j] + string(firstChar) + perm[j:]
			ans = append(ans, result)
		}
	}
	return ans
}

func main() {
	fmt.Println(permutations("123"))
}

