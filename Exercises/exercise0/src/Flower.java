import java.util.UUID;

// Class representing a Flower
public class Flower {
    // Unique identifier for each flower
    UUID flowerId;

    // Name of the flower
    String name;

    // Color of the flower
    String color;

    // Type of soil suitable for the flower
    String soilType;

    // Number of petals on the flower
    int numPetals;

    // Owner of the flower
    String owner;

    // Season in which the flower blooms
    String bloomingSeason;

    // Indicates whether the flower is fragrant
    boolean isFragrant;

    // Indicates whether the flower has thorns
    boolean hasThorns;

    // Constructor to initialize the Flower object with the given parameters
    public Flower(String name, String color, String soilType, int numPetals, String owner, String bloomingSeason,
                  boolean isFragrant, boolean hasThorns) {
        // Generate a unique identifier for the flower using UUID
        this.flowerId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.name = name;
        this.color = color;
        this.soilType = soilType;
        this.numPetals = numPetals;
        this.owner = owner;
        this.bloomingSeason = bloomingSeason;

        // Set fragrant and hasThorns attributes based on input
        this.isFragrant = isFragrant;
        this.hasThorns = hasThorns;

        // Print a message indicating the creation of the Flower instance
        System.out.println("Instance created for Flower " + flowerId);
    }

    // Method to simulate the flower blooming
    public void bloom() {
        System.out.println("\n\t" + name + " blooms in " + bloomingSeason);
    }

    // Method to simulate watering the flower
    public void watering() {
        System.out.println("\t" + owner + " is watering " + name + " plant");
    }

    // Method to simulate checking the fragrance of the flower
    public void fragrance() {
        if (isFragrant) {
            System.out.println("\t" + name + " is fragrant\n");
        } else {
            System.out.println(name + " is not fragrant\n");
        }
    }
}
