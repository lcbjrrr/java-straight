public class Calculator {
    float add(float x, float y) {
        return x+y;
    }
    float sub(float x, float y) {
        return x-y;
    }
    float multi(float x, float y) {
        return x*y;
    }
    float div(float x, float y) {
        return x/y;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        Calculator calc = new Calculator();
        System.out.println(calc.add(1,2));
        System.out.println(calc.sub(1,2));
        System.out.println(calc.multi(1,2));
        System.out.println(calc.div(1,2));
    }
}
