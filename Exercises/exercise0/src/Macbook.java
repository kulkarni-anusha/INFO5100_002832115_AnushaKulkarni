import java.util.UUID;

// Class representing a MacBook
public class Macbook {
    // Unique identifier for each MacBook
    UUID macbookId;

    // Color of the MacBook
    String color;

    // Price of the MacBook
    double price;

    // Display size of the MacBook in inches
    double displaySizeInInches;

    // Model name of the MacBook
    String model;

    // Weight of the MacBook in kilograms
    double weightInKg;

    // RAM (Random Access Memory) of the MacBook in gigabytes
    int RAM;

    // Storage capacity of the MacBook in gigabytes
    int StorageCapacityinGB;

    // Indicates whether the MacBook has a touchscreen
    boolean hasTouchscreen;

    // Constructor to initialize the MacBook object with the given parameters
    public Macbook(String color, double price, double displaySizeInInches, String model, double weightInKg, int RAM,
                   int StorageCapacityinGB, boolean hasTouchscreen) {
        // Generate a unique identifier for the MacBook using UUID
        this.macbookId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.color = color;
        this.price = price;
        this.displaySizeInInches = displaySizeInInches;
        this.model = model;
        this.weightInKg = weightInKg;
        this.RAM = RAM;
        this.StorageCapacityinGB = StorageCapacityinGB;

        // Set hasTouchscreen attribute based on input
        this.hasTouchscreen = hasTouchscreen;

        // Print a message indicating the creation of the MacBook instance
        System.out.println("Instance created for Macbook " + macbookId);
    }

    // Method to simulate powering on the MacBook
    public void powerOn() {
        System.out.println("\n\t" + model + " is powering on");
    }

    // Method to check if the MacBook has a touchscreen
    public void touchScreen() {
        if (hasTouchscreen) {
            System.out.println("\t" + model + " has touchscreen");
        } else {
            System.out.println(model + " does not have touchscreen");
        }
    }

    // Method to simulate shutting down the MacBook
    public void shutDown() {
        System.out.println("\t" + model + " is powering off\n");
    }
}
