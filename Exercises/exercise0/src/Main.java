import java.util.UUID;

//Class 1
class Dog {
    UUID dogId;
    String name;
    String breed;
    int age;
    double weightInPounds;
    String owner;
    String gender;
    String favoriteToy;
    boolean isTrained;

    public Dog(String name, String breed, int age, double weightInPounds, String owner, String gender, String favoriteToy, boolean isTrained) {
        this.dogId = UUID.randomUUID();
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weightInPounds = weightInPounds;
        this.owner = owner;
        this.gender = gender;
        this.favoriteToy = favoriteToy;
        this.isTrained = isTrained;
        System.out.println("Instance created for Dog " + dogId);
    }
    public void groom() {
        System.out.println("\n\t" + owner + " is taking " + name + " for grooming");
    }

    public void play() {
        System.out.println("\t" +owner + " is playing with " + name + " using " + favoriteToy);
    }

    public void training() {
        if (isTrained) {
            System.out.println("\t" + name + " is already trained \n");
        } else {
            System.out.println(owner + "is training " + name);
        }
    }

    // Nested Collar class
    public class Collar {
        String color;
        int size;
        String material;
        String type;

        public Collar(String color, int size, String material, String type) {
            this.color = color;
            this.size = size;
            this.material = material;
            this.type = type;
        }

        public void adjustSize() {
            System.out.println("\t" +name + "'s collar size should be adjusted to" + size);
        }

        public void hookLeash() {
            System.out.println("\t" +owner + " hooked " + name + "'s leash to its collar\n");
        }
    }

    // Nested Feeding class
    public class Feeding {
        String preferredFood;
        int mealsPerDay;
        String preferredTreats;
        boolean isHungry;

        public Feeding(String preferredFood, int mealsPerDay, String preferredTreats, boolean isHungry) {
            this.preferredFood = preferredFood;
            this.mealsPerDay = mealsPerDay;
            this.preferredTreats = preferredTreats;
            this.isHungry = false;
        }

        public void feed() {
            System.out.println("\t" +owner + " is feeding " + name + " its " + preferredFood);
        }

        public void hungry() {
            if (isHungry) {
                System.out.println(owner + " has to feed " + name + " its " + preferredFood);
            } else {
                System.out.println("\t" +name + " is not hungry and is well fed\n");
            }
        }
    }
}

//class2
class Apartment {
    UUID apartmentId;
    String name;
    int numBedrooms;
    int aptNum;
    double rentAmount;
    int areaSqFt;
    int floorNumber;
    boolean isPetFriendly;
    boolean isFurnished;

    public Apartment(String name, int numBedrooms, int aptNum, double rentAmount, int areaSqFt,
                     int floorNumber, boolean isPetFriendly, boolean isFurnished) {
        this.apartmentId = UUID.randomUUID();
        this.name = name;
        this.numBedrooms = numBedrooms;
        this.aptNum = aptNum;
        this.rentAmount = rentAmount;
        this.areaSqFt = areaSqFt;
        this.floorNumber = floorNumber;
        this.isPetFriendly = true;
        this.isFurnished = true;
        System.out.println("Instance created for Apartment " + apartmentId);
    }

    public void welcomeTenant() {
        System.out.println("\n\tWelcome to " + name + "! We hope you enjoy your stay");
    }

    public void payRent() {
        System.out.println("\tTenant paid $" + rentAmount + " rent for the apartment unit " + aptNum);
    }

    public void pets() {
        if (isPetFriendly) {
            System.out.println("\tTenant walks his pet dog in " + name + " apartment complex\n");
        } else {
            System.out.println("Tenant cannot walk a pet");
        }
    }
}

//class3
class Macbook {
    UUID macbookId;
    String color;
    double price;
    double displaySizeInInches;
    String model;
    double weightInKg;
    int RAM;
    int StorageCapacityinGB;
    boolean hasTouchscreen;

    public Macbook(String color, double price, double displaySizeInInches, String model, double weightInKg, int RAM,
                   int StorageCapacityinGB, boolean hasTouchscreen) {
        this.macbookId = UUID.randomUUID();
        this.color = color;
        this.price = price;
        this.displaySizeInInches = displaySizeInInches;
        this.model = model;
        this.weightInKg = weightInKg;
        this.RAM = RAM;
        this.StorageCapacityinGB = StorageCapacityinGB;
        this.hasTouchscreen = true;
        System.out.println("Instance created for Macbook " + macbookId);
    }

    public void powerOn() {
        System.out.println("\n\t" +model + " is powering on");
    }

    public void touchScreen() {
        if (hasTouchscreen) {
            System.out.println("\t" +model + " has touchscreen");
        } else {
            System.out.println(model + " does not have touchscreen");
        }
    }

    public void shutDown() {
        System.out.println("\t" +model + " is powering off\n");
    }
}

//class4
class Shoe {
    UUID shoeId;
    String brand;
    String type;
    double USShoeSize;
    String color;
    String material;
    double price;
    String owner;
    boolean hasLace;

    public Shoe(String brand, String type, double USShoeSize, String color, String material, double price, String owner,
                boolean hasLace) {
        this.shoeId = UUID.randomUUID();
        this.brand = brand;
        this.type = type;
        this.USShoeSize = USShoeSize;
        this.color = color;
        this.material = material;
        this.price = price;
        this.owner = owner;
        this.hasLace = true;
        System.out.println("Instance created for Shoe " + shoeId);
    }

    public void putOn() {
        System.out.println("\n\t" +owner + " puts on " + brand + " shoes");
    }

    public void clean() {
        System.out.println("\t" +owner + " is cleaning " + brand + " shoes");
    }

    public void slipOn() {
        if (hasLace) {
            System.out.println("\t" +owner + " has to tie lace\n");
        } else {
            System.out.println(owner + " uses slip on shoes\n");
        }
    }
}

//class 5
class Flower {
    UUID flowerId;
    String name;
    String color;
    String soilType;
    int numPetals;
    String owner;
    String bloomingSeason;
    boolean isFragrant;
    boolean hasThorns;

    public Flower(String name, String color, String soilType, int numPetals, String owner, String bloomingSeason,
                  boolean isFragrant, boolean hasThorns) {
        this.flowerId = UUID.randomUUID();
        this.name = name;
        this.color = color;
        this.soilType = soilType;
        this.numPetals = numPetals;
        this.owner = owner;
        this.bloomingSeason = bloomingSeason;
        this.isFragrant = true;
        this.hasThorns = true;
        System.out.println("Instance created for Flower " + flowerId);
    }

    public void bloom() {
        System.out.println("\n\t" +name + " blooms in " + bloomingSeason);
    }

    public void watering() {
        System.out.println("\t" +owner + " is watering " + name + " plant");
    }

    public void fragrance() {
        if (isFragrant) {
            System.out.println("\t" +name + " is fragrant\n");
        } else {
            System.out.println(name + " is not fragrant\n");
        }
    }
}

//class 6
class Novel {
    UUID novelId;
    String title;
    String author;
    int yearPublished;
    String genre;
    int pageCount;
    double price;
    String owner;
    boolean isHardcover;

    public Novel(String title, String author, int yearPublished, String genre, int pageCount, double price,
                 String owner, boolean isHardcover) {
        this.novelId = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.pageCount = pageCount;
        this.price = price;
        this.owner = owner;
        this.isHardcover = true;
        System.out.println("Instance created for Novel " + novelId);
    }

    public void read() {
        System.out.println("\n\t" +owner + " is reading the novel: " + title + " written by " + author);
    }

    public void write() {
        System.out.println("\t" +author + " is writing a " + genre + " novel tittled: " + title);
    }

    public void purchase() {
        System.out.println("\t" +author + "'s " + title + " costs " + price + "\n");
    }
}

//class 7
class Ring {
    UUID ringID;
    double size;
    String gemStone;
    double price;
    String metalType;
    String owner;
    String design;
    String Engraving;
    boolean isEngraved;

    public Ring(double size, String gemStone, double price, String metalType, String owner, String design, String Engraving,
                boolean isEngraved) {
        this.ringID = UUID.randomUUID();
        this.size = size;
        this.gemStone = gemStone;
        this.price = price;
        this.metalType = metalType;
        this.owner = owner;
        this.design = design;
        this.Engraving = Engraving;
        this.isEngraved = true;
        System.out.println("Instance created for Ring " + ringID);
    }

    public void wear() {
        System.out.println("\n\t" +owner + " is wearing a " + metalType + " ring with a " + gemStone + " gem stone");
    }

    public void clean() {
        System.out.println("\t" +owner + " is cleaning the " + gemStone + " ring");
    }

    public void engrave() {
        if (isEngraved) {
            System.out.println("\t" +owner + " has an engraving named: " + Engraving + "\n");
        } else {
            System.out.println(owner + " has no engraving\n");
        }
    }
}

//class 8
class Fan {
    UUID fanID;
    String brand;
    int size;
    String color;
    int numberOfBlades;
    int speedLevels;
    String owner;
    boolean isOscillating;
    boolean isRemoteControlled;

    public Fan(String brand, int size, String color, int numberOfBlades, int speedLevels, String owner,
               boolean isOscillating, boolean isRemoteControlled) {
        this.fanID = UUID.randomUUID();
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.numberOfBlades = numberOfBlades;
        this.speedLevels = speedLevels;
        this.owner = owner;
        this.isOscillating = true;
        this.isRemoteControlled = true;
        System.out.println("Instance created for Fan " + fanID);

    }

    public void turnOn() {
        System.out.println("\n\t" +owner + " turned on the " + brand + " fan");
    }

    public void increaseSpeed() {
        if (speedLevels < 3) {
            speedLevels++;
            System.out.println(owner + "'s " + brand + " fan speed increased to level " + speedLevels);
        } else {
            System.out.println("\t" +owner + "'s " + brand + " fan is already at maximum speed");
        }
    }

    public void turnOnOscillation() {
        if (isOscillating) {
            System.out.println("\t" +owner + "'s " + brand + " fan is oscillating\n");
        } else {
            System.out.println(owner + " has to turn on the oscillation\n");
        }
    }

}

//class 9
class Candle {
    UUID candleId;
    String color;
    double heightInInches;
    double burnTimeInHours;
    String shape;
    String owner;
    boolean isLit;
    boolean isScented;
    boolean hasHolder;

    public Candle(String color, double heightInInches, double burnTimeInHours, String shape, String owner,
                  boolean isLit, boolean isScented, boolean hasHolder) {
        this.candleId = UUID.randomUUID();
        this.color = color;
        this.heightInInches = heightInInches;
        this.burnTimeInHours = burnTimeInHours;
        this.shape = shape;
        this.owner = owner;
        this.isLit = true;
        this.isScented = true;
        this.hasHolder = true;
        System.out.println("Instance created for Candle " + candleId);
    }

    public void light() {
        if (isLit) {
            System.out.println("\n\t" +owner + " has already lit the " + color + " " + shape + " candle");
        } else {
            System.out.println(owner + " is lighting the " + color + " " + shape + " candle");
        }
    }

    public void holder() {
        if (hasHolder) {
            System.out.println("\tThe candle has a holder");
        } else {
            System.out.println(owner + " needs to buy a holder for the candle");
        }
    }

    public void scent() {
        if (isScented) {
            System.out.println("\t" +owner + " lit vanilla scented " + color + " " + shape + " candles\n");
        } else {
            System.out.println("The candles are not scented\n");
        }
    }
}

//class 10
class CanvasPainting {
    UUID canvasPaintingId;
    String title;
    String artist;
    int yearPainted;
    double heightInInches;
    double widthInInches;
    double TimeTakenInDays;
    boolean isFramed;
    boolean isSigned;

    public CanvasPainting(String title, String artist, int yearPainted, double heightInInches, double widthInInches,
                          double TimeTakenInDays, boolean isFramed, boolean isSigned) {
        this.canvasPaintingId = UUID.randomUUID();
        this.title = title;
        this.yearPainted = yearPainted;
        this.artist = artist;
        this.heightInInches = heightInInches;
        this.widthInInches = widthInInches;
        this.TimeTakenInDays = TimeTakenInDays;
        this.isFramed = true;
        this.isSigned = true;
        System.out.println("Instance created for Canvas Painting " + canvasPaintingId);
    }

    public void hangOnWall() {
        if (isFramed) {
            System.out.println("\n\t" +artist + " has hanged the " + title + " painting on the wall");
        } else {
            System.out.println(artist + " has not hanged the " + title + " painting on the wall");
        }
    }

    public void year() {
        System.out.println("\t" +artist + " painted the " + title + " painting in the year " + yearPainted);
    }

    public void signedPainting() {
        if (isSigned) {
            System.out.println("\t" +artist + " has signed the " + title + " painting\n");
        } else {
            System.out.println("The painting is anonymous!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Aloo", "Golden Doodle", 1, 15, "Anu",
                "female", "panda", true);
        Dog dog2 = new Dog("Leo", "maltipoo", 2, 10, "Joey",
                "male", "fish", false);
        Dog dog3 = new Dog("Biskii", "Shepsky", 4, 30, "Harry",
                "male", "bone", true);

        dog1.groom();
        dog2.play();
        dog3.training();

        Dog.Collar collar1 = dog1.new Collar("purple", 2, "nylon", "buckle");
        Dog.Feeding feeding1 = dog1.new Feeding("Kibble", 2, "crunchy", true);
        Dog.Collar collar2 = dog1.new Collar("Red", 3, "nylon", "harness");
        Dog.Feeding feeding2 = dog1.new Feeding("Canned", 3, "dental", true);
        Dog.Collar collar3 = dog1.new Collar("black", 4, "polyester", "chain");
        Dog.Feeding feeding3 = dog1.new Feeding("Raw", 3, "Homemade", false);

        collar1.adjustSize();
        collar2.hookLeash();

        feeding1.feed();
        feeding2.hungry();

        Apartment apartment1 = new Apartment("Waterstone", 1, 1, 2500,
                10, 3, true, true);
        Apartment apartment2 = new Apartment("Ava", 2, 1, 2900,
                50, 0, true, true);
        Apartment apartment3 = new Apartment("Asher", 2, 2, 3300,
                35, 1, false, true);

        apartment1.welcomeTenant();
        apartment2.payRent();
        apartment3.pets();

        Macbook macbook1 = new Macbook("black", 1500, 13.5, "Macbook Air",
                1.5, 8, 256, false);
        Macbook macbook2 = new Macbook("silver", 1200, 14.5, "Macbook Pro",
                2.2, 16, 256, true);
        Macbook macbook3 = new Macbook("grey", 1900, 13.5, "Macbook Air M2",
                2.5, 16, 512, false);

        macbook1.powerOn();
        macbook2.touchScreen();
        macbook3.shutDown();

        Shoe shoe1 = new Shoe("Nike", "running", 5.5, "green", "cloth", 80,
                "Ann", true);
        Shoe shoe2 = new Shoe("Allbirds", "casual", 6, "pink", "merino wool",
                120, "Anu", true);
        Shoe shoe3 = new Shoe("Adidas", "running", 6.5, "black", "synthetic",
                100, "Alaska", false);

        shoe1.putOn();
        shoe2.clean();
        shoe3.slipOn();

        Flower flower1 = new Flower("Rose", "red", "well drained", 30, "Anu",
                "late spring", true, true);
        Flower flower2 = new Flower("Tulip", "white", "well drained sandy", 3,
                "Veena", "spring", true, false);
        Flower flower3 = new Flower("Lily", "pink", "rich and moist", 6, "Ann",
                "Fall", true, false);

        flower1.bloom();
        flower2.watering();
        flower3.fragrance();

        Novel novel1 = new Novel("Harry Potter", "JK Rowling", 1997, "Fantasy",
                766, 80, "Anu", true);
        Novel novel2 = new Novel("A Murder is Announced", "Agatha Christie", 1950,
                "Mystery", 256, 70, "Ann", true);
        Novel novel3 = new Novel("Nancy Drew", "Carolyn Keene", 1969,
                "Mystery", 180, 50, "Rachel", false);

        novel1.read();
        novel2.write();
        novel3.purchase();

        Ring ring1 = new Ring(5, "Diamond", 2000, "platinum", "Anu",
                "Vintage", "Anu", true);
        Ring ring2 = new Ring(5.5, "Sapphire", 2500, "gold", "Ann",
                "Halo", "Ann", true);
        Ring ring3 = new Ring(6, "Emerald", 3000, "white gold", "Lily",
                "Solitaire", "Lily", true);

        ring1.wear();
        ring2.clean();
        ring3.engrave();

        Fan fan1 = new Fan("Dyson", 10, "white", 4, 3, "Harry",
                true, true);
        Fan fan2 = new Fan("Havells", 12, "black", 3, 4, "Ron",
                true, false);
        Fan fan3 = new Fan("Panasonic", 15, "brown", 5, 5, "Hermione",
                true, true);

        fan1.turnOn();
        fan2.increaseSpeed();
        fan3.turnOnOscillation();

        Candle candle1 = new Candle("white", 6, 15, "Cylinder", "Albus",
                true, true, true);
        Candle candle2 = new Candle("purple", 7, 20, "Pillar", "Severus",
                true, true, true);
        Candle candle3 = new Candle("red", 8, 25, "Taper", "Tom",
                false, false, true);

        candle1.light();
        candle2.holder();
        candle3.scent();

        CanvasPainting canvasPainting1 = new CanvasPainting("Starry Night", "Leo", 2008,
                10, 20, 2, true, true);
        CanvasPainting canvasPainting2 = new CanvasPainting("Lake View", "Draco", 2010,
                12, 22, 3, true, true);
        CanvasPainting canvasPainting3 = new CanvasPainting("Mountains", "Minerva", 2015,
                14, 24, 4, true, true);

        canvasPainting1.hangOnWall();
        canvasPainting2.year();
        canvasPainting3.signedPainting();

    }
}
