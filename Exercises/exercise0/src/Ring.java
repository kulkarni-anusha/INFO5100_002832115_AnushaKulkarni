import java.util.UUID;

// Class representing a Ring
public class Ring {
    // Unique identifier for each ring instance
    UUID ringID;

    // Attributes of a ring
    double size;
    String gemStone;
    double price;
    String metalType;
    String owner;
    String design;
    String engraving;
    boolean isEngraved;

    // Constructor to initialize a ring instance
    public Ring(double size, String gemStone, double price, String metalType, String owner, String design, String engraving,
                boolean isEngraved) {
        // Generating a unique identifier for the ring
        this.ringID = UUID.randomUUID();

        // Setting attributes with provided values
        this.size = size;
        this.gemStone = gemStone;
        this.price = price;
        this.metalType = metalType;
        this.owner = owner;
        this.design = design;
        this.engraving = engraving;
        this.isEngraved = true; // Assuming all rings are engraved in this example

        // Printing a message indicating the creation of a ring instance
        System.out.println("Instance created for Ring " + ringID);
    }

    // Method to simulate wearing the ring
    public void wear() {
        System.out.println("\n\t" + owner + " is wearing a " + metalType + " ring with a " + gemStone + " gemstone");
    }

    // Method to simulate cleaning the ring
    public void clean() {
        System.out.println("\t" + owner + " is cleaning the " + gemStone + " ring");
    }

    // Method to simulate engraving the ring
    public void engrave() {
        if (isEngraved) {
            System.out.println("\t" + owner + " has an engraving named: " + engraving + "\n");
        } else {
            System.out.println(owner + " has no engraving\n");
        }
    }
}
