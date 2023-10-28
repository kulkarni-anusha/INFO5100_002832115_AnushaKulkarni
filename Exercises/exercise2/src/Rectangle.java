
// Derived class 2: Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor to initialize the color, length, and width
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Implementing calculateArea for Rectangle, demonstrating overriding
    @Override
    public double calculateArea() {
        return super.calculateArea(length, width);
    }

    // Implementing calculatePerimeter for Rectangle, demonstrating overriding
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

}

