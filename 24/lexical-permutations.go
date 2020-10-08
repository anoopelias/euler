package main

import "fmt"

const max = 1000000

/*
* To run,
* ```
* $ go build lexical-permutations.go
* $ ./lexical-permutations
* ```
 */

type node struct {
	num      int
	prefix   string
	nodenums []int
}

func main() {
	n := node{
		prefix:   "",
		nodenums: []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
	}

	lexPerms(n, 1)
}

func lexPerms(n node, i int) int {

	if len(n.nodenums) == 0 {
		println(fmt.Sprintf("%d: %s", i, n.prefix))
		return i + 1
	}

	for idx, num := range n.nodenums {
		nn := node{
			num:      num,
			prefix:   fmt.Sprintf("%s%d", n.prefix, num),
			nodenums: remove(n.nodenums, idx),
		}

		i = lexPerms(nn, i)
		if i > max {
			return i
		}
	}

	return i
}

func remove(nums []int, i int) []int {
	var nnums []int
	for idx, num := range nums {
		if idx != i {
			nnums = append(nnums, num)
		}
	}

	return nnums
}
