// Derived class: Circle
class Circle extends Shape {
    private double radius;

    // Constructor to initialize the color and radius
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementing calculateArea for Circle, demonstrating overriding
    @Override
    public double calculateArea() {
        return pi * radius * radius;
    }

    // Implementing calculatePerimeter for Circle, demonstrating overriding
    @Override
    public double calculatePerimeter() {
        return (2 * pi * radius);
    }

}
