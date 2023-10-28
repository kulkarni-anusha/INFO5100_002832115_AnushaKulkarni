public class Main {
    public static void main(String[] args) {
        // Creating instances of different shapes to demonstrate polymorphism
        Shape triangle = new Triangle("Red", 3,4,2,3,4);
        Shape rectangle = new Rectangle("Blue", 6, 8);
        Shape circle = new Circle("Green", 3);
        Shape square = new Square("Yellow", 4);

        // Displaying information about each shape
        System.out.println("Displaying Triangle Information");
        System.out.println("\n\tThe triangle is in " + triangle.getColor() + " color");
        System.out.println("\tThe area of triangle is " + triangle.calculateArea() + " cm^2");
        System.out.println("\tThe Perimeter of triangle is " + triangle.calculatePerimeter() + " cm");

        System.out.println("\nDisplaying Rectangle Information");
        System.out.println("\n\tThe rectangle is in " + rectangle.getColor() + " color");
        System.out.println("\tThe area of rectangle is " + rectangle.calculateArea() + " cm^2");
        System.out.println("\tThe Perimeter of rectangle is " + rectangle.calculatePerimeter() + " cm");

        System.out.println("\nDisplaying Circle Information");
        System.out.println("\n\tThe circle is in " + circle.getColor() + " color");
        System.out.println("\tThe area of circle is " + circle.calculateArea() + " cm^2");
        System.out.println("\tThe Perimeter of circle is " + circle.calculatePerimeter() + " cm");

        System.out.println("\nDisplaying Square Information");
        System.out.println("\n\tThe square is in " + square.getColor() + " color");
        System.out.println("\tThe area of square is " + square.calculateArea() + " cm^2");
        System.out.println("\tThe Perimeter of square is " + square.calculatePerimeter() + " cm");
    }
}
