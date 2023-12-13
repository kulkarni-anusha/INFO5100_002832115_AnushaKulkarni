import java.util.UUID;

// Class representing a Shoe
public class Shoe {
    // Unique identifier for each shoe instance
    UUID shoeId;

    // Attributes of a shoe
    String brand;
    String type;
    double USShoeSize;
    String color;
    String material;
    double price;
    String owner;
    boolean hasLace;

    // Constructor to initialize a shoe instance
    public Shoe(String brand, String type, double USShoeSize, String color, String material, double price, String owner,
                boolean hasLace) {
        // Generating a unique identifier for the shoe
        this.shoeId = UUID.randomUUID();

        // Setting attributes with provided values
        this.brand = brand;
        this.type = type;
        this.USShoeSize = USShoeSize;
        this.color = color;
        this.material = material;
        this.price = price;
        this.owner = owner;
        this.hasLace = true; // Assuming all shoes have lace in this example

        // Printing a message indicating the creation of a shoe instance
        System.out.println("Instance created for Shoe " + shoeId);
    }

    // Method to simulate putting on the shoe
    public void putOn() {
        System.out.println("\n\t" + owner + " puts on " + brand + " shoes");
    }

    // Method to simulate cleaning the shoe
    public void clean() {
        System.out.println("\t" + owner + " is cleaning " + brand + " shoes");
    }

    // Method to simulate slipping on the shoe
    public void slipOn() {
        if (hasLace) {
            System.out.println("\t" + owner + " has to tie the lace\n");
        } else {
            System.out.println(owner + " uses slip-on shoes\n");
        }
    }
}
