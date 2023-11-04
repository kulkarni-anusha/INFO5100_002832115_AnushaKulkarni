import java.io.Serializable;

// Abstract base class representing a Shape
abstract class Shape implements Serializable {

    // Static field
    final static float pi = 3.14f;
    private String color;

    // Constructor to set the color
    public Shape(String color) {
        this.color = color;
    }

    // Abstract methods to calculate area and perimeter, demonstrating abstraction
    public abstract double calculateArea(); // Abstraction

    public abstract double calculatePerimeter(); // Abstraction

    public double calculateArea(double length, double width) { //method overloading
        return length * width;
    }

    // Getter for color, demonstrating a static field
    public String getColor() {
        return color; // Static field
    }
}