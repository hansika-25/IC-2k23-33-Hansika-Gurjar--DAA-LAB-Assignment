
import java.util.Scanner;

public class NQueens {

    static int n;
    static int[] board;
    static int solutionCount = 0;

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {

            // Same column
            if (board[i] == col) {
                return false;
            }

            // Same diagonal
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    public static void solveNQueens(int row) {

        if (row == n) {
            solutionCount++;
            printBoard();
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {
                board[row] = col;

                solveNQueens(row + 1);

                // Backtracking
                board[row] = -1;
            }
        }
    }

    public static void printBoard() {
        System.out.println("Solution " + solutionCount + ":");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queens: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            board = new int[n];

            for (int i = 0; i < n; i++) {
                board[i] = -1;
            }

            solveNQueens(0);

            System.out.println("Total solutions: " + solutionCount);
        }

        sc.close();
    }
}
