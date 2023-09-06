import java.util.Random;

public class CoinFlipStreaks {

    public static void main(String[] args) {
        int numOfStreaks = 0;
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {

            char[] list = new char[100];
            for (int j = 0; j < 100; j++) {
                if (random.nextInt(2) == 0) {
                    list[j] = 'H';
                } else {
                    list[j] = 'T';
                }
            }

            char prev = list[0];
            int count = 1;
            for (int curr = 1; curr < list.length; curr++) {
                if (list[curr] == prev) {
                    count++;
                } else {
                    prev = list[curr];
                    count = 1;
                }

                if (count == 6) {
                    numOfStreaks++;
                    count = 0;
                }
            }
        }

        System.out.printf("Chance of streak: %s%%", numOfStreaks / 100);
    }
}
