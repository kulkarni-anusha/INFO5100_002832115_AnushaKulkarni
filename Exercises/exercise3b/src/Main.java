public class Main {
    public static void main(String[] args) {
        // Creating instances of different shapes to demonstrate polymorphism
        Shape triangle = new Triangle("Red", 3, 4, 2, 3, 4);
        Shape rectangle = new Rectangle("Blue", 6, 8);
        Shape circle = new Circle("Green", 3);
        Shape square = new Square("Yellow", 4);

        // Displaying information about each shape
        System.out.println("Displaying Triangle Information before serialization");
        displayShapeInfo(triangle);

        System.out.println("\nDisplaying Rectangle Information before serialization");
        displayShapeInfo(rectangle);

        System.out.println("\nDisplaying Circle Information before serialization");
        displayShapeInfo(circle);

        System.out.println("\nDisplaying Square Information before serialization");
        displayShapeInfo(square);

        // Serialize the shapes
        System.out.println("\nSerializing of shapes");
        SerializeDeserialize.serialize(triangle, "triangle.ser");
        System.out.println(triangle.getClass().getName() + " is serialized");
        SerializeDeserialize.serialize(rectangle, "rectangle.ser");
        System.out.println(rectangle.getClass().getName() + " is serialized");
        SerializeDeserialize.serialize(circle, "circle.ser");
        System.out.println(circle.getClass().getName() + " is serialized");
        SerializeDeserialize.serialize(square, "square.ser");
        System.out.println(square.getClass().getName() + " is serialized");

        // Deserialize and display the deserialized shapes
        Shape deserializedTriangle = SerializeDeserialize.deserialize("triangle.ser");
        Shape deserializedRectangle = SerializeDeserialize.deserialize("rectangle.ser");
        Shape deserializedCircle = SerializeDeserialize.deserialize("circle.ser");
        Shape deserializedSquare = SerializeDeserialize.deserialize("square.ser");

        System.out.println("\nDisplaying Deserialized Triangle Information");
        displayShapeInfo(deserializedTriangle);

        System.out.println("\nDisplaying Deserialized Rectangle Information");
        displayShapeInfo(deserializedRectangle);

        System.out.println("\nDisplaying Deserialized Circle Information");
        displayShapeInfo(deserializedCircle);

        System.out.println("\nDisplaying Deserialized Square Information");
        displayShapeInfo(deserializedSquare);
    }

    public static void displayShapeInfo(Shape shape) {
        System.out.println("\n\tThe " + shape.getClass().getSimpleName() + " is in " + shape.getColor() + " color");
        System.out.println("\tThe area of " + shape.getClass().getSimpleName() + " is " + shape.calculateArea() + " cm^2");
        System.out.println("\tThe Perimeter of " + shape.getClass().getSimpleName() + " is " + shape.calculatePerimeter() + " cm");
    }
}
