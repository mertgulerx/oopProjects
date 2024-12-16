import java.util.Random;

public class MagicSquareFactory {
    private MagicSquare square;

    public MagicSquare createMagicSquare(int size) {

        if (size % 2 == 0) {
            return null;
        }

        square = new MagicSquare(size);

        // Initialize First Number
        int first = 1;
        square.placeValue(size / 2, 0, first);
        first++;

        int x = size / 2;
        int y = 0;

        int limit = size - 1;
        for (int i = first; i < size * size + 1; i++) {

            // check for up right
            // check if in limit
            if (y - 1 >= 0 && x + 1 <= limit) {
                // check if up right is empty
                if (checkEmpty(x + 1, y - 1)) {
                    square.placeValue(x + 1, y - 1, i);
                    x++;
                    y--;
                } 
                // check down
                else {
                    // check if in limit
                    if (y + 1 <= limit) {
                        // check if down is empty
                        if (checkEmpty(x, y + 1)) {
                            square.placeValue(x, y + 1, i);
                            y++;
                        }
                    }
                }
            } 
            // check for other side up right 
            else {
                if (y == 0){
                    // check upwards warp for y == 0
                    if (checkEmpty(x + 1, limit)){
                        square.placeValue(x + 1, limit, i);
                        x++;
                        y = limit;
                    } else {
                        // check down
                        if (y + 1 <= limit) {
                            // check if down is empty
                            if (checkEmpty(x, y + 1)) {
                                square.placeValue(x, y + 1, i);
                                y++;
                            }
                        }
                    }
                } else if (x + 1 > limit){
                    if (checkEmpty(0, y - 1)){
                        square.placeValue(0, y - 1, i);
                        x = 0;
                        y--;;
                    } else {
                        // check down
                        if (y + 1 <= limit) {
                            // check if down is empty
                            if (checkEmpty(x, y + 1)) {
                                square.placeValue(x, y + 1, i);
                                y++;
                            }
                        }
                    }
                }
            }
        }

        return square;
    }

    public void printSum(){
            System.out.println("This is a magic square. Sum is: " + square.sumsOfColumns());
        
    }

    public int pickRandom() {
        Random random = new Random();

        return random.nextInt(100);
    }

    public boolean checkEmpty(int x, int y) {
        return square.readValue(x, y) == 0;
    }

}
