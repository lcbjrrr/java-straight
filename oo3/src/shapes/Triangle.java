package shapes;

public class Triangle extends Shape{
    private float base;
    private float height;
    public Triangle(String c,float b,float h) {
        super(c);
        this.base=b;
        this.height=h;
    }
    @Override
    public float area() {
        return (this.base*this.height)/2;
    }
}
