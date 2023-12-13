import java.util.UUID;

// Class representing an Apartment
public class Apartment {
    // Unique identifier for each apartment
    UUID apartmentId;

    // Name of the apartment complex
    String name;

    // Number of bedrooms in the apartment
    int numBedrooms;

    // Apartment number
    int aptNum;

    // Monthly rent amount for the apartment
    double rentAmount;

    // Area of the apartment in square feet
    int areaSqFt;

    // Floor number where the apartment is located
    int floorNumber;

    // Indicates whether the apartment is pet-friendly
    boolean isPetFriendly;

    // Indicates whether the apartment is furnished
    boolean isFurnished;

    // Constructor to initialize the Apartment object with the given parameters
    public Apartment(String name, int numBedrooms, int aptNum, double rentAmount, int areaSqFt,
                     int floorNumber, boolean isPetFriendly, boolean isFurnished) {
        // Generate a unique identifier for the apartment using UUID
        this.apartmentId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.name = name;
        this.numBedrooms = numBedrooms;
        this.aptNum = aptNum;
        this.rentAmount = rentAmount;
        this.areaSqFt = areaSqFt;
        this.floorNumber = floorNumber;

        // Set pet-friendly and furnished attributes based on input
        this.isPetFriendly = isPetFriendly;
        this.isFurnished = isFurnished;

        // Print a message indicating the creation of the Apartment instance
        System.out.println("Instance created for Apartment " + apartmentId);
    }

    // Method to welcome a tenant to the apartment
    public void welcomeTenant() {
        System.out.println("\n\tWelcome to " + name + "! We hope you enjoy your stay");
    }

    // Method to simulate the tenant paying rent
    public void payRent() {
        System.out.println("\tTenant paid $" + rentAmount + " rent for the apartment unit " + aptNum);
    }

    // Method to simulate a tenant with a pet in a pet-friendly apartment
    public void pets() {
        if (isPetFriendly) {
            System.out.println("\tTenant walks his pet dog in " + name + " apartment complex\n");
        } else {
            System.out.println("\tTenant cannot walk a pet\n");
        }
    }
}
