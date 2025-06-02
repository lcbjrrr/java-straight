//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Python {
    public static void main(String[] args) {
        int x = 1;
        if( x == 1 ) {
            System.out.print("x equals to 1");
        }else {
            System.out.print("x not equals 1");
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        int y = 5;
        while( y > 0 ) {
            System.out.println(y);
            y--;
        }

        int[] nums = {1,2,3,4,5};
        for (int n : nums){
            System.out.println(n);
        }

        int r = add(1,2);
        System.out.println(r);

        int[] grades = {70,90,80};
        System.out.println(grades[1]);
        grades[1]=100;
        System.out.println(grades[1]);

    }


    static int add(int x, int y) {
        int sum = x + y;
        return sum;
    }

}