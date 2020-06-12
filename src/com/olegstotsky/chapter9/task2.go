package main

import "fmt"

func GetNumWaysGrid(x, y int) int {
	grid := make([][]int, y)
	for i := 0; i < y; i++ {
		grid[i] = make([]int, x)
	}

	for i := 0; i < x; i++ {
		grid[0][i] = 1
	}

	for i := 0; i < y; i++ {
		grid[i][0] = 1
	}

	for i := 1; i < y; i++ {
		for j := 1; j < x; j++ {
			grid[i][j] = grid[i-1][j] + grid[i][j-1]
		}
	}

	return grid[y-1][x-1]
}

func main() {
	fmt.Println(GetNumWaysGrid(3, 3))
}
