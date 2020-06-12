package main

import (
	"errors"
	"fmt"
)

//A[0] = 1 => A[1] > 1 => A[1] not magic, A[1] >= 2, A[2] > 2
//A[0] = <= 0 A[i] > i, A[A[i]] not magic.
//A[1] = 0 A[i] < i => для всех предыдущих A[i] < i
//1 3 4 5
//-1 0 2 5 6 7 8
//0  1 2 3 4 5 6
//A[3] > 3
//A[1] < 1,
func GetMagicIndex(arr []int) (int, error) {
	l := 0
	r := len(arr)
	for l <= r {
		mid := l + (r - l)/2
		if arr[mid] == mid {
			return mid, nil
		}
		if arr[mid] < mid {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	return 0, errors.New("no magic number")
}

func main() {
	test := []int{-1, 0, 2, 5, 6, 7, 8}
	res, err := GetMagicIndex(test)
	fmt.Println(res, err)
}