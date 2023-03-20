import java.util.Scanner;
import java.lang.Math;

public class Board {

    private char board[][];
    final int size;

    /**
     * The constructor for the object of class TTT.
     *
     * @param n The board size, from 1 to 8
     */
    public Board(int n) {
        size = n;
        board = new char[n][n];
        for (char[] row : board) {
            for (int j = 0; j < n; j++) {
                row[j] = ' ';
            }
        }
    }


    public int size(){return size;}

    public char[][] getBoard() {return board;}

    public char getValue(int row, int col) {return board[row][col];}

    /**
     * Updates the value at (row, col).
     *
     * @param row position of row
     * @param col position of col
     * @param symbol symbol of player
     *
     * @return Whether value at (row, col) is updated.
     */
    public boolean setValue(int row, int col, char symbol){
        if(board[row][col] != ' '){ return false;}
        board[row][col] = symbol;
        return true;
    }

    /**
     * Returns a string of a row for the game, including values at each position of the board.
     *
     * @param i current position of row
     * @return String of row
     */
    private String buildUpperRow(int i) {

        String str = "";

        str += (char) ('A' + i);

        for (int j = 0; j < size - 1; j++) {
            //prints non edge column
            str += (" " + this.board[i][j] + " |");
        }
        str += (" " + this.board[i][size - 1]);

        return str;

    }

    /**
     * Returns a string of a bottom barrier of the row, i.e.  ---|---|---
     *
     * @return String of row
     */

    private String buildLowerRow() {
        String str = "";
        for (int k = 0; k < size - 1; k++) {
            str += ("---|");
        }
        str += ("---");

        return str;
    }


    public String toString() {
        String rString = "\n  ";

        //prints number grid
        for (int i = 1; i <= size; i++) {
            rString += i + "   ";
        }

        for (int i = 0; i < size - 1; i++) {

            //builds a row with border
            rString += "\n" + buildUpperRow(i);
            rString += "\n " + buildLowerRow();

        }
        //builds final row w/o border
        rString += "\n" + buildUpperRow(size - 1);

        return rString;
    }


    public static void main(String[] args) {
        Board test1 = new Board(3);
        Board test2 = new Board(5);

        System.out.println("Test1 = " + test1.toString());
        System.out.println("Test2 = " + test2.board.toString());

    }

    /**
     * Runs consecutive Tic-tac-toe games until the user gets tired and quits.
     */
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        Score score = new Score();
//        int size = 0;
//        System.out.println("Hello. Welcome to Tic-Tac-Toe");
//        try{
//            size = Integer.parseInt(args[0]);
//            if(size <= 0 || size >= 8){
//                System.out.println("Error! Invaid size. Defaulting to 3 X 3 board.");
//                size = 3;
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println("Error! Invaid size. Defaulting to 3 X 3 board.");
//            size = 3;
//        }
//
//        System.out.println("Creating a "+ size + " X " + size + " board.");
//
//
//        while(true){
//            gamePlay newGame = new gamePlay(score);
//            int winner = newGame.game(size);
//            switch(winner){
//                case 1:
//                    System.out.println("The CPU wins the round!");
//                    score.addAI();
//                    break;
//                case 2:
//                    System.out.println("You win the round! Good job!");
//                    score.addHuman();
//                    break;
//                default:
//                    System.out.println("It's a tie!");
//                    break;
//            }
//        }

//    }


}
