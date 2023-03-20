public class Checker {
    /**
     * Checks the outcome of the game and the winner for the round.
     *
     * @param board The game object
     * @return 'X' for player 1, 'O' for player 2, 'T' for a tie, or 'A' for active game.
     */
    public char anyWinner(Board board) {
        if (checkCol(board, 'O') || checkRow(board, 'O') || checkDia(board, 'O'))
            return 'O';
        else if (checkCol(board, 'X') || checkRow(board, 'X') || checkDia(board, 'X'))
            return 'X';
        else if (!checkBlanks(board))
            return 'T';
        return 'A';
    }


    /**
     * Checks the board for any empty space.
     *
     * @param board The current game board
     * @return Whether there is any empty spaces.
     */
    public boolean checkBlanks(Board board) {
        for (char[] row : board.getBoard())
            for (char str : row) {
                if (str == ' ') {
                    return false;
                }
            }
        return true;
    }

    /**
     * Checks if the given player won any column
     *
     * @param board  The game object
     * @param symbol The current player's symbol ('X' or 'O')
     * @return Returns true if the player won in any column
     */
    public boolean checkCol(Board board, char symbol) {

        for (int i = 0; i < board.size(); i++) {
            int count = 0;
            for (int j = 0; j < board.size(); j++) {
                if (board.getValue(j, i) == symbol) {
                    count += 1;
                }
            }
            if (count == board.size()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given player (CPU/Human) won any row via the condition set
     *
     * @param board  The game object
     * @param symbol The current player's symbol ('X' or 'O')
     * @return Returns true if the player won in any row
     */
    public boolean checkRow(Board board, char symbol) {

        for (char[] row : board.getBoard()) {
            int count = 0;

            for (char col : row) {
                if (col == symbol) {
                    count++;
                }
            }
            if (count == board.size())
                return true;
        }
        return false;
    }

    /**
     * Checks if the given player (CPU/Human) won either diagonal against a condition set
     *
     * @param board  The game object
     * @param symbol The current player's symbol ('X' or 'O')
     * @return Returns true if the player won either diagonal
     */
    public boolean checkDia(Board board, char symbol) {

        //checks forward diagonal
        boolean status1 = true;
        boolean status2 = true;
        for (int i = 0, j = board.size() - 1; i < board.size() || j >= 0; i++, j--) {
            if (board.getValue(i, i) != symbol) {
                status1 = false;
            }
            if (board.getValue(j, j) != symbol) {
                status2 = false;
            }
            if (!status1 && status2) {
                return false;
            }
        }
        return true;
    }
}
