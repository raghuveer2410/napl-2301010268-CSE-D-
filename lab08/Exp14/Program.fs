
open System

// Base abstract class
[<AbstractClass>]
type Shape() =
    abstract member Area: unit -> float

// Derived class: Circle
type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

// Derived class: Rectangle
type Rectangle(length: float, width: float) =
    inherit Shape()

    override this.Area() =
        length * width

// Main program
[<EntryPoint>]
let main argv =

    // Create objects
    let circle = Circle(5.0)
    let rectangle = Rectangle(10.0, 4.0)

    // Call methods
    printfn "Circle Area: %.2f" (circle.Area())
    printfn "Rectangle Area: %.2f" (rectangle.Area())

    // Demonstrate polymorphism
    let shapes: Shape list =
        [ circle :> Shape
          rectangle :> Shape ]

    printfn "\nPolymorphism Demonstration:"

    for shape in shapes do
        printfn "Area = %.2f" (shape.Area())

    0
