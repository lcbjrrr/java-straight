public class CakeWriting {
    private int cakeSize; // Corresponds to __tamanhoBolo
    private String cakeText; // Corresponds to __textoBolo

    // Constructor
    public CakeWriting(int cakeSize, String cakeText) {
        // Initialize with validation through setters
        setCakeSize(cakeSize); // Call the setter to validate initial size
        setCakeText(cakeText); // Call the setter to validate initial text
    }

    // Getter for cakeSize (equivalent to Python's @property)
    public int getCakeSize() {
        return cakeSize;
    }

    // Setter for cakeSize with validation
    public void setCakeSize(int newCakeSize) {
        if (newCakeSize != 8 && newCakeSize != 16) {
            System.out.println("Sorry, we do not work with cakes of " + newCakeSize + " cm (only 8 or 16 cm).");
            // Optionally, throw an IllegalArgumentException here instead of just printing
            // throw new IllegalArgumentException("Invalid cake size: " + newCakeSize);
        } else {
            this.cakeSize = newCakeSize;
        }
    }

    // Getter for cakeText
    public String getCakeText() {
        return cakeText;
    }

    // Setter for cakeText with validation
    public void setCakeText(String newCakeText) {
        if (newCakeText == null) { // Handle null input gracefully
            newCakeText = "";
        }

        int textLength = newCakeText.length();
        boolean isValid = false;

        if (this.cakeSize == 8) {
            if (textLength >= 0 && textLength <= 16) { // allow empty text (length 0)
                isValid = true;
            }
        } else if (this.cakeSize == 16) {
            if (textLength >= 0 && textLength <= 40) { // allow empty text (length 0)
                isValid = true;
            }
        }

        if (isValid) {
            this.cakeText = newCakeText;
        } else {
            System.out.println("Sorry, it's not possible to write '" + newCakeText + "' (" + textLength + " letters) on a " + this.cakeSize + " cm cake.");
            // Optionally, throw an IllegalArgumentException here
            // throw new IllegalArgumentException("Invalid text for cake size " + this.cakeSize + ": " + newCakeText);
        }
    }

    // Method to calculate the cost of writing
    public double calculateWritingCost() {
        if (this.cakeText == null) { // Ensure no NullPointerException if text was never set validly
            return 0.0;
        }
        return 0.25 * this.cakeText.length();
    }

}