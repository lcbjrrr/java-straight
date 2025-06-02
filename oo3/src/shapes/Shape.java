package shapes;

import java.awt.*;

public abstract class Shape {
    String color;
    public abstract float area();

    public Shape(String c) {
        this.color=c;
    }

    public static void main(String[] args) {
        Shape s = new Square("blue", 2);
        Shape r = new Triangle("green", 2, 3);
        Shape c = new Circle("red", 2);
        Shape[] shapes = {s,r,c};
        for (Shape f: shapes) {
            System.out.println(f.color+" "+f.area());
        }
    }
}
