import java.util.UUID;

// Class representing a Novel
public class Novel {
    // Unique identifier for each novel instance
    UUID novelId;

    // Attributes of a novel
    String title;
    String author;
    int yearPublished;
    String genre;
    int pageCount;
    double price;
    String owner;
    boolean isHardcover;

    // Constructor to initialize a novel instance
    public Novel(String title, String author, int yearPublished, String genre, int pageCount, double price,
                 String owner, boolean isHardcover) {
        // Generating a unique identifier for the novel
        this.novelId = UUID.randomUUID();

        // Setting attributes with provided values
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.pageCount = pageCount;
        this.price = price;
        this.owner = owner;
        this.isHardcover = true; // Assuming all novels are hardcover in this example

        // Printing a message indicating the creation of a novel instance
        System.out.println("Instance created for Novel " + novelId);
    }

    // Method to simulate reading the novel
    public void read() {
        System.out.println("\n\t" + owner + " is reading the novel: " + title + " written by " + author);
    }

    // Method to simulate writing a novel
    public void write() {
        System.out.println("\t" + author + " is writing a " + genre + " novel titled: " + title);
    }

    // Method to simulate purchasing the novel
    public void purchase() {
        System.out.println("\t" + author + "'s " + title + " costs " + price + "\n");
    }
}
