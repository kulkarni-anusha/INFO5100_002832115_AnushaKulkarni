import java.util.UUID;

// Class representing a Canvas Painting
public class CanvasPainting {
    // Unique identifier for each canvas painting
    UUID canvasPaintingId;

    // Title of the painting
    String title;

    // Artist who painted the canvas
    String artist;

    // Year when the painting was created
    int yearPainted;

    // Height of the painting in inches
    double heightInInches;

    // Width of the painting in inches
    double widthInInches;

    // Time taken to create the painting in days
    double timeTakenInDays;

    // Indicates whether the painting is framed
    boolean isFramed;

    // Indicates whether the painting is signed by the artist
    boolean isSigned;

    // Constructor to initialize the CanvasPainting object with the given parameters
    public CanvasPainting(String title, String artist, int yearPainted, double heightInInches, double widthInInches,
                          double timeTakenInDays, boolean isFramed, boolean isSigned) {
        // Generate a unique identifier for the canvas painting using UUID
        this.canvasPaintingId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.title = title;
        this.artist = artist;
        this.yearPainted = yearPainted;
        this.heightInInches = heightInInches;
        this.widthInInches = widthInInches;
        this.timeTakenInDays = timeTakenInDays;

        // Set framed and signed attributes based on input
        this.isFramed = isFramed;
        this.isSigned = isSigned;

        // Print a message indicating the creation of the CanvasPainting instance
        System.out.println("Instance created for Canvas Painting " + canvasPaintingId);
    }

    // Method to simulate hanging the painting on the wall
    public void hangOnWall() {
        if (isFramed) {
            System.out.println("\n\t" + artist + " has hanged the " + title + " painting on the wall");
        } else {
            System.out.println(artist + " has not hanged the " + title + " painting on the wall");
        }
    }

    // Method to display the year when the painting was created
    public void year() {
        System.out.println("\t" + artist + " painted the " + title + " painting in the year " + yearPainted);
    }

    // Method to simulate signing the painting
    public void signedPainting() {
        if (isSigned) {
            System.out.println("\t" + artist + " has signed the " + title + " painting\n");
        } else {
            System.out.println("The painting is anonymous!");
        }
    }
}
