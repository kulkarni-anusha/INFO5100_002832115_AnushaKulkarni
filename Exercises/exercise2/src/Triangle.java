
// Derived class 1: Triangle
class Triangle extends Shape {
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    // Constructor to initialize the color, base, and height
    public Triangle(String color, double base, double height, double side1, double side2, double side3) {
        super(color); // Inheriting from base class
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Implementing calculateArea for Triangle, demonstrating overriding
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    // Implementing calculatePerimeter for Triangle, demonstrating overriding
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }


}
