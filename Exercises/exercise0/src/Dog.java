import java.util.UUID;

// Class representing a Dog
public class Dog {
    // Unique identifier for each dog
    UUID dogId;

    // Name of the dog
    String name;

    // Breed of the dog
    String breed;

    // Age of the dog
    int age;

    // Weight of the dog in pounds
    double weightInPounds;

    // Owner of the dog
    String owner;

    // Gender of the dog
    String gender;

    // Favorite toy of the dog
    String favoriteToy;

    // Indicates whether the dog is trained
    boolean isTrained;

    // Constructor to initialize the Dog object with the given parameters
    public Dog(String name, String breed, int age, double weightInPounds, String owner, String gender, String favoriteToy, boolean isTrained) {
        // Generate a unique identifier for the dog using UUID
        this.dogId = UUID.randomUUID();

        // Initialize other attributes with the provided values
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weightInPounds = weightInPounds;
        this.owner = owner;
        this.gender = gender;
        this.favoriteToy = favoriteToy;
        this.isTrained = isTrained;

        // Print a message indicating the creation of the Dog instance
        System.out.println("Instance created for Dog " + dogId);
    }

    // Method to simulate grooming the dog
    public void groom() {
        System.out.println("\n\t" + owner + " is taking " + name + " for grooming");
    }

    // Method to simulate playing with the dog
    public void play() {
        System.out.println("\t" + owner + " is playing with " + name + " using " + favoriteToy);
    }

    // Method to simulate training the dog
    public void training() {
        if (isTrained) {
            System.out.println("\t" + name + " is already trained \n");
        } else {
            System.out.println(owner + " is training " + name);
        }
    }

    // Nested Collar class
    public class Collar {
        String color;
        int size;
        String material;
        String type;

        // Constructor to initialize the Collar object with the given parameters
        public Collar(String color, int size, String material, String type) {
            this.color = color;
            this.size = size;
            this.material = material;
            this.type = type;
        }

        // Method to adjust the size of the collar
        public void adjustSize() {
            System.out.println("\t" + name + "'s collar size should be adjusted to " + size);
        }

        // Method to hook the leash to the collar
        public void hookLeash() {
            System.out.println("\t" + owner + " hooked " + name + "'s leash to its collar\n");
        }
    }

    // Nested Feeding class
    public class Feeding {
        String preferredFood;
        int mealsPerDay;
        String preferredTreats;
        boolean isHungry;

        // Constructor to initialize the Feeding object with the given parameters
        public Feeding(String preferredFood, int mealsPerDay, String preferredTreats, boolean isHungry) {
            this.preferredFood = preferredFood;
            this.mealsPerDay = mealsPerDay;
            this.preferredTreats = preferredTreats;
            this.isHungry = false;
        }

        // Method to simulate feeding the dog
        public void feed() {
            System.out.println("\t" + owner + " is feeding " + name + " its " + preferredFood);
        }

        // Method to check if the dog is hungry
        public void hungry() {
            if (isHungry) {
                System.out.println(owner + " has to feed " + name + " its " + preferredFood);
            } else {
                System.out.println("\t" + name + " is not hungry and is well fed\n");
            }
        }
    }
}
