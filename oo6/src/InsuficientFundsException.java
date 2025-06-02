public class InsuficientFundsException extends Exception {
    private float funds;
    public InsuficientFundsException(float funds) {
        this.funds=funds;

    }
    public float getFunds() {
        return funds;
    }
}
