package main

import "fmt"

func main() {
	var values [3]int
	fmt.Scan(&values[0], &values[1], &values[2])

	var T int
	fmt.Scan(&T)

	result := 0

	for i := 0; i < T; i++ {
		sum := 0
		for j := 0; j < 3; j++ {
			for z := 0; z < len(values); z++ {
				var skill int
				fmt.Scan(&skill)

				sum += skill * values[z]
			}
		}

		if sum > result {
			result = sum
		}
	}

	fmt.Println(result)
}
