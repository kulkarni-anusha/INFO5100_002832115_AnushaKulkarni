// Derived class: Square
class Square extends Shape {
    private double side;

    // Constructor to initialize the color and side length
    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    // Implementing calculateArea for Square, demonstrating overriding
    @Override
    public double calculateArea() {
        return side * side;
    }

    // Implementing calculatePerimeter for Square, demonstrating overriding
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

}