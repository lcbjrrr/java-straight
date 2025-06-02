package shapes;

public class Square extends Shape{
    private float side;
    public Square(String c,float s) {
        super(c);
        this.side=s;
    }
    @Override
    public float area() {
        return this.side*this.side;
    }
}
