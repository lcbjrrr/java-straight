public class PartyCalculator {
    // Private instance variables (fields)
    private int numberOfPeople;
    private boolean healthyBeverages;
    private boolean differentiatedDecor;

    // Constructor
    public PartyCalculator(int numberOfPeople, boolean healthyBeverages, boolean differentiatedDecor) {
        this.numberOfPeople = numberOfPeople;
        this.healthyBeverages = healthyBeverages;
        this.differentiatedDecor = differentiatedDecor;
    }

    // Private helper methods (conventionally camelCase for methods)
    protected double calculateFoodCost() {
        return this.numberOfPeople * 25.0;
    }

    protected double calculateBeverageCost() {
        if (this.healthyBeverages) {
            return this.numberOfPeople * 5.0;
        } else {
            return this.numberOfPeople * 20.0;
        }
    }

    protected double calculateDecorCost() {
        if (this.differentiatedDecor) {
            return 50.0 + this.numberOfPeople * 15.0;
        } else {
            return 30.0 + this.numberOfPeople * 7.5;
        }
    }

    protected double calculateDiscountPercentage() {
        if (this.healthyBeverages) {
            return 5.0; // 5% discount
        } else {
            return 0.0; // No discount
        }
    }

    // Public method to calculate the total party value
    protected double calculateTotalPartyCost() {
        double totalCost = this.calculateFoodCost() + this.calculateBeverageCost() + this.calculateDecorCost();
        totalCost -= totalCost * this.calculateDiscountPercentage() / 100.0;
        return totalCost;
    }

    // --- Optional: Example Usage (main method) ---
    public static void main(String[] args) {
        // Scenario 1: 10 people, healthy beverages, standard decor
        PartyCalculator party1 = new PartyCalculator(10, true, false);
        System.out.println("Cost of Party 1 (10 people, healthy drinks, standard decor): $" + party1.calculateTotalPartyCost());
        // Expected: $384.75

        System.out.println("--------------------");

        // Scenario 2: 20 people, regular beverages, differentiated decor
        PartyCalculator party2 = new PartyCalculator(20, false, true);
        System.out.println("Cost of Party 2 (20 people, regular drinks, differentiated decor): $" + party2.calculateTotalPartyCost());
        // Expected: $1250.0
    }
}