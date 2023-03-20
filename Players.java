
import java.util.Scanner;
public class Players
{

    /**
     * This method dictates what the CPU's move would be and updates the board accordingly
     * @param game The game object
     */
    public void cpuPlayer(TTT game){
        System.out.println("It is the CPU's turn.");
        //edit
        int decision = (int) (Math.random() * (5));
        if(!CPUBlocking(game)){ 
            switch(decision){
                case 0:
                    if(game.board[0][0].equals(" ")){
                        game.board[0][0] = "O";
                        break;
                    }
                case 1:
                    if(game.board[0][game.nrows - 1].equals(" ")){
                        game.board[0][game.nrows - 1] = "O";
                        break;
                    }
                case 2:
                    if(game.board[game.nrows - 1][0].equals(" ")){
                        game.board[game.nrows - 1][0] = "O";
                        break;
                    }
                case 3:
                    if(game.board[game.nrows - 1][game.nrows - 1].equals(" ")){
                        game.board[game.nrows - 1][game.nrows - 1] = "O";
                        break;
                    }
                case 4:

                    while(true){
                        int row = (int) (Math.random() * (game.nrows));
                        int col = (int) (Math.random() * (game.ncols));
                        if(game.board[row][col].equals(" ")){
                            game.board[row][col] = "O";
                            break;
                        }
                    }
                    break;
            }
        }   
        else{
            CPUBlocking(game);
        }
        System.out.println(game.toString());
        System.out.println("------------------------------");
    }

    public boolean CPUBlocking(TTT ticTac){
        if(blockCol(ticTac)){
            return true;
        }
        else if(blockRow(ticTac)){
            return true;
        }
        else if(blockDia(ticTac)){
            return true;
        }
        return false;
    }

    /**
     * Checks if the CPU player can block the human player win in a column
     * @param ticTac The game object
     * @return Returns true if the CPU can block
     */
    public boolean blockCol(TTT ticTac){

        int count = 0;
        for(int i=0; i< ticTac.nrows; i++){
            for(int j=0; j< ticTac.ncols; j++){
                if(ticTac.board[j][i].equals("X")){
                    count +=1;
                }
            }
            if(count == ticTac.nrows -1){
                for(int k=0; k< ticTac.ncols; k++){
                    if(ticTac.board[k][i].equals(" ")){
                        ticTac.board[k][i] = "O";
                        return true;
                    }
                }
            }
            count = 0;
        }
        return false;

    }

    /**
     * Checks if the CPU player can block the human player win in a row
     * @param ticTac The game object
     * @return Returns true if the CPU can block
     */
    public boolean blockRow(TTT ticTac){
        int count = 0;
        for(int i=0; i< ticTac.nrows; i++){
            for(int j=0; j< ticTac.ncols; j++){
                if(ticTac.board[i][j].equals("X")){
                    count +=1;
                }
            }
            if(count == ticTac.nrows -1){
                for(int k=0; k< ticTac.ncols; k++){
                    if(ticTac.board[i][k].equals(" ")){
                        ticTac.board[i][k] = "O";
                        return true;
                    }
                }
            }
            count = 0;
        }
        return false;    
    }

    /**
     * Checks if the CPU player can block the human player win in a column
     * @param ticTac The game object
     * @return Returns true if the CPU can block
     */
    public boolean blockDia(TTT ticTac){
        // topleft to bottomright
        int count = 0;
        for(int i=0; i< ticTac.nrows; i++){
            if(ticTac.board[i][i].equals("X")){
                count +=1;
            }
        }
        if(count == ticTac.nrows -1){
            for(int k=0; k< ticTac.ncols; k++){
                if(ticTac.board[k][k].equals(" ")){
                    ticTac.board[k][k] = "O";
                    return true;
                }
            }
        }
        //topright to bottomleft
        count = 0;
        for(int i = ticTac.nrows - 1; i >= 0; i--){
            if(ticTac.board[i][i].equals("X")){
                count +=1;
            }
        }
        if(count == ticTac.nrows -1){
            for(int k=ticTac.ncols -1; k >= 0; k--){
                if(ticTac.board[k][k].equals(" ")){
                    ticTac.board[k][k] = "O";
                    return true;
                }
            }
        }
        return false;    

    }

    /**
     * This method asks the human player their move, and if invalid keeps asking until a valid move is presented. It would then update the board.
     * @param game The game object
     */
    public void humanPlayer(TTT game){
        System.out.println("It is the player's turn.");
        Scanner scan = new Scanner(System.in);
        System.out.println(game.toString());
        while(true){
            int xcoord;
            int ycoord;

            while(true){
                try{
                    System.out.println("Please enter your column coordinate (Ex: A1, B4, C3, ...)");
                    System.out.println("Also if you want to end the game, enter QUIT.");
                    String unconverted = scan.next();

                    if(unconverted.toLowerCase().equals("quit")){
                        score.Winner();
                    }

                    xcoord = unconverted.toUpperCase().charAt(0) - 65;
                    ycoord = unconverted.charAt(1) - 49;

                    if((unconverted.length() != 2 || ((ycoord < 0) || (ycoord >= game.ncols) || (xcoord < 0 || (xcoord >= game.ncols))))){
                        System.out.println("Please input a coordinate within the range of the board.");
                    }

                    else{
                        break;
                    }

                }
                catch(Exception e)
                {
                    System.out.println("Not a valid input!");
                    scan.nextLine();
                }

            }

            if(game.board[xcoord][ycoord].
            equals(" ")){
                game.board[xcoord][ycoord] = "X";
                System.out.println(game.toString());
                break;
            }
            else{
                System.out.println("Invalid Coordinates. Please reenter your coordinates.");
            }
        }

        System.out.println("------------------------------");
    }

}

