// TicTac Togo -> ambjn

import java.util.Scanner;

public class TicTacTogo {
    private static boolean haveWon(char[][] board, char player) {
        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // check the columns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[0][col] == player && board[0][col] == player) {
                return true;
            }
        }
        // check the diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // initialized the 3X3 board as a char array
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = ' ';
            }
        }
        char player = 'X';

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (board[row][column] == ' ') {
                board[row][column] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println(player + " Has Won!!");
                } else {
                    player = (player == 'X') ? '0' : 'X';
                }
            } else {
                System.out.println("Invalid Move, Try Again (-_-)");
            }
            printBoard(board);
        }
    }
}