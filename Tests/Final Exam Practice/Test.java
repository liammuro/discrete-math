import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void up() {
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("n: ");
        char[][] board = new char[4][console.nextInt()];

        char left = '\u2190';
        char up = '\u2191';
        char right = '\u2192';
        char down = '\u2193';

        board[0][0] = up;
        board[1][0] = down;
        board[2][0] = left;
        board[3][0] = right;

        board[0][1] = '\u2190';
        board[1][1] = '\u2191';
        board[2][1] = '\u2192';
        board[3][1] = '\u2193';

        board[0][2] = '1';
        board[1][2] = '2';
        board[2][2] = '3';
        board[3][2] = '4';

        board[0][3] = ' ';
        board[1][3] = ' ';
        board[2][3] = ' ';
        board[3][3] = ' ';



        for (char[] boardtmp : board) {
            System.out.println(Arrays.toString(boardtmp));
        }


        // up();


        console.close();
    }
}
