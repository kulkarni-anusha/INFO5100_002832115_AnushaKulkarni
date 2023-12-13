import java.util.UUID;

// Class representing a Candle
public class Candle {
    // Unique identifier for each candle
    UUID candleId;

    // Color of the candle
    String color;

    // Height of the candle in inches
    double heightInInches;

    // Burn time of the candle in hours
    double burnTimeInHours;

    // Shape of the candle
    String shape;

    // Owner of the candle
    String owner;

    // Indicates whether the candle is currently lit
    boolean isLit;

    // Indicates whether the candle is scented
    boolean isScented;

    // Indicates whether the candle has a holder
    boolean hasHolder;

    // Constructor to initialize the Candle object with the given parameters
    public Candle(String color, double heightInInches, double burnTimeInHours, String shape, String owner,
                  boolean isLit, boolean isScented, boolean hasHolder) {
        // Generate a unique identifier for the candle using UUID
        this.candleId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.color = color;
        this.heightInInches = heightInInches;
        this.burnTimeInHours = burnTimeInHours;
        this.shape = shape;
        this.owner = owner;

        // Set lit, scented, and holder attributes based on input
        this.isLit = isLit;
        this.isScented = isScented;
        this.hasHolder = hasHolder;

        // Print a message indicating the creation of the Candle instance
        System.out.println("Instance created for Candle " + candleId);
    }

    // Method to simulate lighting the candle
    public void light() {
        if (isLit) {
            System.out.println("\n\t" + owner + " has already lit the " + color + " " + shape + " candle");
        } else {
            System.out.println(owner + " is lighting the " + color + " " + shape + " candle");
        }
    }

    // Method to check if the candle has a holder
    public void holder() {
        if (hasHolder) {
            System.out.println("\tThe candle has a holder");
        } else {
            System.out.println(owner + " needs to buy a holder for the candle");
        }
    }

    // Method to simulate the scent of the candle
    public void scent() {
        if (isScented) {
            System.out.println("\t" + owner + " lit vanilla-scented " + color + " " + shape + " candles\n");
        } else {
            System.out.println("\tThe candles are not scented\n");
        }
    }
}
