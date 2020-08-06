package main

import "fmt"

func allValidParenths(n int) []string {
	res := generate(n)
	ans := make([]string, 0, len(res))
	for k, _ := range generate(n) {
		ans = append(ans, k)
	}
	return ans
}

func generate(n int) map[string]bool {
	if n == 0 {
		return map[string]bool{ "": true }
	}
	prev := generate(n-1)
	result := make(map[string]bool)
	for paren, _ := range prev {
		result["(" + paren + ")"] = true
		result["()" + paren] = true
		result[paren + "()"] = true
	}
	return result
}

func main() {
	res := allValidParenths(3)
	for _, item := range res {
		fmt.Println(item)
	}
}