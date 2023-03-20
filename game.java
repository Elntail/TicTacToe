import java.util.Scanner;

public class game {
    private Board board;
    private Players player1;
    private Players player2;
    private Score score;
    private final char p1 = 'X';
    private final char p2 = 'O';



    public game(int size){
        this.board = new Board(size);
        this.player1 = new Players();
        this.player2 = new Players();
    }
    public char gameCpu(){

        boolean gameOver = false;
        //randomize order
        int order = (int) (Math.random()*2);

        // if 0 then Player1 goes first
        // else then the CPU

        while(true){
            switch(order){
                case 0:
                    //HUMAN TURN
                    player1.humanPlayer(board);
                    gameOver = anyWinner(board);
                    if(winner(game) != 0) return winner(game);
                    if(gameOver) break;

                    //CPU TURN
                    players.cpuPlayer(game);
                    gameOver = checkgrid(game);
                    if(winner(game) != 0) return winner(game);
                    if(gameOver) break;
                    break;
                case 1:
                    //CPU TURN
                    players.cpuPlayer(game);
                    gameOver = checkgrid(game);
                    if(winner(game) != 0) return winner(game);
                    if(gameOver) break;
                    //HUMAN TURN
                    players.humanPlayer(game);
                    gameOver = checkgrid(game);
                    if(winner(game) != 0) return winner(game);
                    if(gameOver) break;
                    break;
            }
        }
        return winner(game);
    }




}
