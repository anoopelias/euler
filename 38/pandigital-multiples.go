package main

import (
	"fmt"
	"strconv"
	"strings"
)

/*
* To run,
* ```
* $ go build pandigital-multiples.go
* $ ./pandigital-multiples
* ```
 */

var digits = []string{"1", "2", "3", "4", "5", "6", "7", "8", "9"}

func main() {
	fmt.Println("Pandigital multiples")

	lpn := 0
	for n := 1; n < 5000000; n++ {
		fn := ""
		for i := 1; i < 15; i++ {
			fn = fn + strconv.Itoa(n*i)
			if len(fn) > 9 {
				break
			}

			if isPandigital(fn) {
				pn, _ := strconv.Atoi(fn)
				if pn > lpn {
					lpn = pn
				}
			}
		}

	}
	fmt.Println(lpn)
}

func isPandigital(sn string) bool {

	if len(sn) != 9 {
		return false
	}

	for _, d := range digits {
		if !strings.Contains(sn, d) {
			return false
		}

	}

	return true
}
