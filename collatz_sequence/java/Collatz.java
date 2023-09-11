import java.util.Scanner;

public class Collatz {

    public static void main(String[] args) {
        System.out.println("Magically, Whatever number eventually get to 1.");
        Scanner s = new Scanner(System.in);

        System.out.print("number: ");
        long number = s.nextLong();

        magic(number);
    }

    public static void magic(long number){

        while(number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            System.out.println(number);
        }
    }
}
