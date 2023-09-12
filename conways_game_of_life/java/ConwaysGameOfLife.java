import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ConwaysGameOfLife {
    public static final int WIDTH = 79;
    public static final int HEIGHT = 20;
    public static final char ALIVE = '#';
    public static final char DEAD = ' ';

    public static void main(String[] args) {
        char[][] nextCells = new char[WIDTH][HEIGHT];
        Random r = new Random();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {

                if(r.nextInt(2) == 0) nextCells[x][y] = DEAD;
                else nextCells[x][y] = ALIVE;
            }
        }

        for(;;) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            char[][] cells = Arrays.copyOf(nextCells, nextCells.length);

            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    System.out.print(cells[x][y]);
                }
                System.out.println();
            }


            //System.out.println("\n\n\n");
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    int left = (x - 1) % WIDTH;
                    int right = (x + 1) % WIDTH;
                    int above = (y - 1) % HEIGHT;
                    int below = (y + 1) % HEIGHT;

                    if(left == -1) left += WIDTH;
                    if(above == -1) above += HEIGHT;

                    int numNeighbors = 0;
                    if (cells[left][above] == ALIVE) numNeighbors++;
                    if (cells[x][above] == ALIVE) numNeighbors++;
                    if (cells[right][above] == ALIVE) numNeighbors++;
                    if (cells[left][y] == ALIVE) numNeighbors++;
                    if (cells[right][y] == ALIVE) numNeighbors++;
                    if (cells[left][below] == ALIVE) numNeighbors++;
                    if (cells[x][below] == ALIVE) numNeighbors++;
                    if (cells[right][below] == ALIVE) numNeighbors++;

                    if (cells[x][y] == ALIVE && (numNeighbors == 2 || numNeighbors == 3)) {
                        nextCells[x][y] = ALIVE;
                    } else if (cells[x][y] == DEAD && numNeighbors == 3) {
                        nextCells[x][y] = ALIVE;
                    } else {
                        nextCells[x][y] = DEAD;
                    }
                }
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
