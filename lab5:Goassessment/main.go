package main

import "fmt"

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

func main() {

	items := []Item{
		{1, "Apple", 10, 100},
		{2, "Banana", 20, 50},
		{3, "Mango", 5, 80},
	}

	fmt.Println("Items:", items)

	items = append(items, Item{4, "Orange", 15, 60})
	fmt.Println("After Adding:", items)

	items[0].Quantity = 25
	fmt.Println("After Updating:", items)

	items = append(items[:1], items[2:]...)
	fmt.Println("After Removing:", items)

	ch := make(chan float64)

	go func() {
		var total float64
		for _, item := range items {
			total += float64(item.Quantity) * item.Price
		}
		ch <- total
	}()

	fmt.Println("Total Inventory Value:", <-ch)
	fmt.Println("Total Item Count:", len(items))

}
