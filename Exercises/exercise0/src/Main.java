import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Creating instances of the Dog class
        Dog dog1 = new Dog("Aloo", "Golden Doodle", 1, 15, "Anu", "female", "panda", true);
        Dog dog2 = new Dog("Leo", "maltipoo", 2, 10, "Joey", "male", "fish", false);
        Dog dog3 = new Dog("Biskii", "Shepsky", 4, 30, "Harry", "male", "bone", true);

        // Performing actions on dogs
        dog1.groom();
        dog2.play();
        dog3.training();

        // Creating instances of nested classes (Collar and Feeding) for dog1
        Dog.Collar collar1 = dog1.new Collar("purple", 2, "nylon", "buckle");
        Dog.Feeding feeding1 = dog1.new Feeding("Kibble", 2, "crunchy", true);
        Dog.Collar collar2 = dog1.new Collar("Red", 3, "nylon", "harness");
        Dog.Feeding feeding2 = dog1.new Feeding("Canned", 3, "dental", true);
        Dog.Collar collar3 = dog1.new Collar("black", 4, "polyester", "chain");
        Dog.Feeding feeding3 = dog1.new Feeding("Raw", 3, "Homemade", false);

        // Performing actions related to dog accessories
        collar1.adjustSize();
        collar2.hookLeash();
        feeding1.feed();
        feeding2.hungry();

        // Creating instances of the Apartment class
        Apartment apartment1 = new Apartment("Waterstone", 1, 1, 2500, 10, 3, true, true);
        Apartment apartment2 = new Apartment("Ava", 2, 1, 2900, 50, 0, true, true);
        Apartment apartment3 = new Apartment("Asher", 2, 2, 3300, 35, 1, false, true);

        // Performing actions related to apartments
        apartment1.welcomeTenant();
        apartment2.payRent();
        apartment3.pets();

        // Creating instances of the Macbook class
        Macbook macbook1 = new Macbook("black", 1500, 13.5, "Macbook Air", 1.5, 8, 256, false);
        Macbook macbook2 = new Macbook("silver", 1200, 14.5, "Macbook Pro", 2.2, 16, 256, true);
        Macbook macbook3 = new Macbook("grey", 1900, 13.5, "Macbook Air M2", 2.5, 16, 512, false);

        // Performing actions related to Macbooks
        macbook1.powerOn();
        macbook2.touchScreen();
        macbook3.shutDown();

        // Creating instances of the Shoe class
        Shoe shoe1 = new Shoe("Nike", "running", 5.5, "green", "cloth", 80, "Ann", true);
        Shoe shoe2 = new Shoe("Allbirds", "casual", 6, "pink", "merino wool", 120, "Anu", true);
        Shoe shoe3 = new Shoe("Adidas", "running", 6.5, "black", "synthetic", 100, "Alaska", false);

        // Performing actions related to shoes
        shoe1.putOn();
        shoe2.clean();
        shoe3.slipOn();

        // Creating instances of the Flower class
        Flower flower1 = new Flower("Rose", "red", "well drained", 30, "Anu", "late spring", true, true);
        Flower flower2 = new Flower("Tulip", "white", "well drained sandy", 3, "Veena", "spring", true, false);
        Flower flower3 = new Flower("Lily", "pink", "rich and moist", 6, "Ann", "Fall", true, false);

        // Performing actions related to flowers
        flower1.bloom();
        flower2.watering();
        flower3.fragrance();

        // Creating instances of the Novel class
        Novel novel1 = new Novel("Harry Potter", "JK Rowling", 1997, "Fantasy", 766, 80, "Anu", true);
        Novel novel2 = new Novel("A Murder is Announced", "Agatha Christie", 1950, "Mystery", 256, 70, "Ann", true);
        Novel novel3 = new Novel("Nancy Drew", "Carolyn Keene", 1969, "Mystery", 180, 50, "Rachel", false);

        // Performing actions related to novels
        novel1.read();
        novel2.write();
        novel3.purchase();

        // Creating instances of the Ring class
        Ring ring1 = new Ring(5, "Diamond", 2000, "platinum", "Anu", "Vintage", "Anu", true);
        Ring ring2 = new Ring(5.5, "Sapphire", 2500, "gold", "Ann", "Halo", "Ann", true);
        Ring ring3 = new Ring(6, "Emerald", 3000, "white gold", "Lily", "Solitaire", "Lily", true);

        // Performing actions related to rings
        ring1.wear();
        ring2.clean();
        ring3.engrave();

        // Creating instances of the Fan class
        Fan fan1 = new Fan("Dyson", 10, "white", 4, 3, "Harry", true, true);
        Fan fan2 = new Fan("Havells", 12, "black", 3, 4, "Ron", true, false);
        Fan fan3 = new Fan("Panasonic", 15, "brown", 5, 5, "Hermione", true, true);

        // Performing actions related to fans
        fan1.turnOn();
        fan2.increaseSpeed();
        fan3.turnOnOscillation();

        // Creating instances of the Candle class
        Candle candle1 = new Candle("white", 6, 15, "Cylinder", "Albus", true, true, true);
        Candle candle2 = new Candle("purple", 7, 20, "Pillar", "Severus", true, true, true);
        Candle candle3 = new Candle("red", 8, 25, "Taper", "Tom", false, false, true);

        // Performing actions related to candles
        candle1.light();
        candle2.holder();
        candle3.scent();

        // Creating instances of the CanvasPainting class
        CanvasPainting canvasPainting1 = new CanvasPainting("Starry Night", "Leo", 2008, 10, 20, 2, true, true);
        CanvasPainting canvasPainting2 = new CanvasPainting("Lake View", "Draco", 2010, 12, 22, 3, true, true);
        CanvasPainting canvasPainting3 = new CanvasPainting("Mountains", "Minerva", 2015, 14, 24, 4, true, true);

        // Performing actions related to canvas paintings
        canvasPainting1.hangOnWall();
        canvasPainting2.year();
        canvasPainting3.signedPainting();
    }
}
