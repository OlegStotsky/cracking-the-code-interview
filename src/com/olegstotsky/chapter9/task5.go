package main

import "fmt"

// aabc
// a -> 2, b -> 1, c
func allPermutations(s string) []string {
	cnt := make(map[rune]int)
	for _, ch := range s {
		cnt[ch]++
	}
	result := make([]string, 0, 10)
	genPerms(cnt, 0, len(s), "", &result)
	return result
}

func genPerms(cnt map[rune]int, pos int, n int, cur string, result *[]string) {
	if pos == n {
		*result = append(*result, cur)
		return
	}
    for ch, count := range cnt {
    	if count > 0 {
			cnt[ch]--
			genPerms(cnt, pos+1, n, cur+string(ch), result)
			cnt[ch]++
		}
	}
}

func main() {
	fmt.Println(allPermutations("121"))
}
