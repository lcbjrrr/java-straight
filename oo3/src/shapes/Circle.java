package shapes;

public class Circle extends Shape{
    private float radius;
    public Circle(String c, float r) {
        super(c);
        this.radius=r;
    }
    @Override
    public float area() {
        return this.radius*this.radius*3.14f;
    }

}
