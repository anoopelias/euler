package main

import (
	"math"
)

const max = 1000000

/*
* To run,
* ```
* $ go build quadratic-primes.go
* $ ./quadratic-primes
* ```
 */

type quadraticEquation struct {
	a int
	b int
}

func (q quadraticEquation) eval(n int) int {
	return (n * n) + (q.a * n) + q.b
}

func main() {
	var a, b, maxa, maxb, maxcnt int

	for a = -999; a <= 999; a++ {
		for b = -1000; b <= 1000; b++ {
			qe := quadraticEquation{
				a: a,
				b: b,
			}
			cnt := maxConsecutivePrimes(qe)
			if cnt > maxcnt {
				maxcnt = cnt
				maxa = a
				maxb = b
			}
		}
	}
	print("max primes ", maxa, " ", maxb, " ", maxcnt, "\n")

}

func maxConsecutivePrimes(qe quadraticEquation) int {
	i := 0
	allPrimes := true
	for allPrimes {
		v := qe.eval(i)
		if v <= 0 || !isPrime(v) {
			allPrimes = false
			break
		}
		i++
	}

	return i
}

func isPrime(n int) bool {
	till := int(math.Floor(math.Sqrt(math.Abs(float64(n)))))
	for i := 2; i <= till; i++ {
		if n%i == 0 {
			return false
		}
	}

	return true
}
