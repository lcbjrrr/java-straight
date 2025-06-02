
public class BirthdayPartyCalculator extends PartyCalculator { // 'extends' keyword for inheritance
    private int cakeSize; // Corresponds to __tamanhoBolo
    private CakeWriting cakeWriting; // Corresponds to __escritaEmBolo (composition)

    // Constructor int numberOfPeople, boolean healthyBeverages, boolean differentiatedDecor
    public BirthdayPartyCalculator(int numberOfPeople, boolean healthyBeverages, boolean differentiatedDecor, String cakeText) {
        // Call the constructor of the superclass (PartyCalculator)
        super(numberOfPeople, healthyBeverages, differentiatedDecor);

        // Determine cake size based on number of people
        if (numberOfPeople <= 4) {
            this.cakeSize = 8; // Small cake
        } else {
            this.cakeSize = 16; // Large cake
        }

        // Create an instance of CakeWriting (composition)
        this.cakeWriting = new CakeWriting(this.cakeSize, cakeText);
    }

    // Method to calculate the base price of the cake
    private double calculateCakePrice() {
        double cakePrice = 0;
        // Access cakeSize via the instance variable directly
        if (this.cakeSize == 8) {
            cakePrice = 40.0;
        } else if (this.cakeSize == 16) {
            cakePrice = 75.0;
        }
        return cakePrice;
    }

    @Override // Annotation indicating that this method overrides a superclass method
    public double calculateTotalPartyCost() {
        // Call superclass methods for common costs
        double partyCost = super.calculateFoodCost() + super.calculateDecorCost();

        // Add birthday-specific costs
        partyCost += this.calculateCakePrice() + this.cakeWriting.calculateWritingCost();

        return partyCost;
    }

    // --- Optional: Example Usage (main method for testing) ---
    public static void main(String[] args) {
        System.out.println("--- Birthday Party Examples ---");

        // Small party: 3 people, standard decor, simple text
        BirthdayPartyCalculator smallParty = new BirthdayPartyCalculator(3, false,false, "Happy Bday!");
        System.out.println("Cost for Small Party (3 people, std decor, 'Happy Bday!'): $" + String.format("%.2f", smallParty.calculateTotalPartyCost()));
        // Expected: Food(3*25=75) + Decor(30 + 3*7.5=52.5) + Cake(40) + Writing(10*0.5=5) = 75 + 52.5 + 40 + 5 = 172.5

        System.out.println("--------------------");

        // Large party: 10 people, differentiated decor, longer text
        BirthdayPartyCalculator largeParty = new BirthdayPartyCalculator(10, false,true, "Happy Birthday to a wonderful person!");
        System.out.println("Cost for Large Party (10 people, diff decor, longer text): $" + String.format("%.2f", largeParty.calculateTotalPartyCost()));
        // Expected: Food(10*25=250) + Decor(50 + 10*15=200) + Cake(75) + Writing(34*0.5=17) = 250 + 200 + 75 + 17 = 542
    }
}