import java.util.UUID;

// Class representing a Fan
public class Fan {
    // Unique identifier for each fan
    UUID fanID;

    // Brand of the fan
    String brand;

    // Size of the fan
    int size;

    // Color of the fan
    String color;

    // Number of blades on the fan
    int numberOfBlades;

    // Number of speed levels the fan has
    int speedLevels;

    // Owner of the fan
    String owner;

    // Indicates whether the fan is oscillating
    boolean isOscillating;

    // Indicates whether the fan is remote-controlled
    boolean isRemoteControlled;

    // Constructor to initialize the Fan object with the given parameters
    public Fan(String brand, int size, String color, int numberOfBlades, int speedLevels, String owner,
               boolean isOscillating, boolean isRemoteControlled) {
        // Generate a unique identifier for the fan using UUID
        this.fanID = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.numberOfBlades = numberOfBlades;
        this.speedLevels = speedLevels;
        this.owner = owner;

        // Set oscillating and remoteControlled attributes based on input
        this.isOscillating = isOscillating;
        this.isRemoteControlled = isRemoteControlled;

        // Print a message indicating the creation of the Fan instance
        System.out.println("Instance created for Fan " + fanID);
    }

    // Method to simulate turning on the fan
    public void turnOn() {
        System.out.println("\n\t" + owner + " turned on the " + brand + " fan");
    }

    // Method to simulate increasing the speed of the fan
    public void increaseSpeed() {
        if (speedLevels < 3) {
            speedLevels++;
            System.out.println(owner + "'s " + brand + " fan speed increased to level " + speedLevels);
        } else {
            System.out.println("\t" + owner + "'s " + brand + " fan is already at maximum speed");
        }
    }

    // Method to simulate turning on the oscillation feature of the fan
    public void turnOnOscillation() {
        if (isOscillating) {
            System.out.println("\t" + owner + "'s " + brand + " fan is oscillating\n");
        } else {
            System.out.println(owner + " has to turn on the oscillation\n");
        }
    }
}
