package main

import "fmt"

func generateParens(n int) []string {
	result := make([]string, 0)
	str := make([]rune, n*2)
	addParen(&result, n, n, str, 0)
	return result
}

func addParen(result *[]string, leftRem int, rightRem int, str []rune, pos int) {
	if leftRem < 0 || rightRem < leftRem {
		return
	}
	if leftRem == 0 && rightRem == 0 {
		*result = append(*result, string(str))
		return
	}
	if leftRem > 0 {
		str[pos] = '('
		addParen(result, leftRem-1,rightRem,str,pos+1)
	}
	if rightRem > leftRem {
		str[pos] = ')'
		addParen(result, leftRem, rightRem-1, str, pos+1)
	}
}

func main() {
	res := generateParens(3)
	fmt.Println(res)
}
