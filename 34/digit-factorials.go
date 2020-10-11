package main

import "fmt"

/*
* To run,
* ```
* $ go build digit-factorials.go
* $ ./digit-factorials
* ```
 */

func main() {
	fmt.Println("Digit factorials")

	for n := 3; n < 100000000; n++ {
		s := 0
		for _, d := range digitsOf(n) {
			f := factorialOf(d)
			s = s + f
		}

		if s == n {
			fmt.Println(s)
		}

	}
}

func digitsOf(n int) []int {
	var digits []int

	for n != 0 {
		digits = append(digits, n%10)
		n = n / 10
	}

	return digits
}

func factorialOf(n int) int {
	factorial := 1

	for i := 1; i <= n; i++ {
		factorial = factorial * i
	}

	return factorial
}
