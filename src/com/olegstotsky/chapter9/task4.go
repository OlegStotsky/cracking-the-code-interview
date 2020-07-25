package main

import "fmt"

// 1 2 3
// 1 2 3 - 1
// 1 2, 1 3, 2 3
func AllSubsetsOfSet(s []interface{}) [][]interface{} {
	n := len(s)
	var max uint64 = 1 << n
	result := make([][]interface{}, 0, max)
	for i  := uint64(0); i < max; i++ {
		convertIntToSet(i, s, &result)
	}
	return result
}

func convertIntToSet(i uint64, s[]interface{}, result *[][]interface{}) {
	pos := 0
	tmp := make([]interface{}, 0)
	for i != 0 {
		curBit := i & 1
		if curBit == 1 {
			tmp = append(tmp, s[pos])
		}
		pos++
		i >>= 1
	}
	*result = append(*result, tmp)
}

func main() {
	arr := []int{ 1, 2 }
	arr2 := make([]interface{}, len(arr))
	for i := 0; i < len(arr); i++ {
		arr2[i] = arr[i]
	}
	allSubsets := AllSubsetsOfSet(arr2)
	fmt.Println(allSubsets)

}
