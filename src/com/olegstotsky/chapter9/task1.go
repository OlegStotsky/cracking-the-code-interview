package main

import "fmt"

//f(n) = f(n-1) + f(n-2) + f(n-3)
//f(2) = f(2) + f(1) + 1

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func GetNumWays(n int) int {
	ans := make([]int, max(3, n))
	ans[0] = 1
	ans[1] = 2
	ans[2] = 4

	for i := 3; i < n; i++ {
		ans[i] = ans[i-1] + ans[i-2] + ans[i-3]
	}

	return ans[n-1]
}

func main() {
	fmt.Println(GetNumWays(4))
}
