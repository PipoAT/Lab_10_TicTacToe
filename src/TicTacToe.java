import java.util.Scanner; // import scanner for user input

public class TicTacToe {
    private static final int ROW = 3; // set max rows to 3
    private static final int COL = 3; // set max col to 3
    private static final String[][] board = new String[ROW][COL]; // create 2D array to act as board

    public static void main(String[] args) {
        boolean playAgain; // initialize variable for user to play again
        Scanner scanner = new Scanner(System.in); // initialize scanner for user input

        do {
            clearBoard(); // clears out the board from previous attempts
            String currentPlayer = "X"; // sets the first player to go is X

            while (true) { // continuing loop until a win or tie is declared
                display(); // display the board/print out 2D array
                System.out.println("Player " + currentPlayer + ", enter your move (row and column):"); // output for user to enter row and column
                int row = SafeInput.getRangedInt(scanner, "Enter the row (1-3): ", 1, 3); // user input for row
                int col = SafeInput.getRangedInt(scanner, "Enter the column (1-3): ", 1, 3); // user input for column

                // convert player move coordinates to array indices
                row--;
                col--;

                // check if the move is valid
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;

                    // check for win or tie
                    if (isWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isTie()) {
                        display();
                        System.out.println("It's a tie!");
                        break;
                    }

                    // toggle the player/switch turns
                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            // ask for user input if they would like to play again
            playAgain = SafeInput.getYNConfirm(scanner, "Would you like to play again? Input Y or N: ");
        } while (playAgain);

        scanner.close(); // close the scanner when done
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " "; // for every element in each row and column, set to blank
            }
        }
    }

    private static void display() { // print out the board/2D array
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) { // checks for if the user inputs are within the bounds of 1-3 and checks if that spot is not taken
        if (row >= 0 && row < ROW && col >= 0 && col < COL) {
            return board[row][col].equals(" "); // returns the valid move if allowed
        }
        return false; // returns false otherwise
    }

    private static boolean isWin(String player) { // returns boolean true/false if any condition is true
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player) { // checks each column to see if a user have won with X or O in one column and returns T/F
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) { // checks each row to see if a user has won with X or O in one row and returns T/F
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) { // checks the diagonals to see if user has won with X or O and returns T/F
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() { // returns T/F if the above isWin conditions fail and full board is taken up
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
