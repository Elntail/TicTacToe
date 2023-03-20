
public class Score
{
    private int scoreHuman = 0;
    private int scoreAI = 0;
    /**
     * Adds 1 to the score of the Human Player
     */
    public void addHuman(){
        scoreHuman++;
    }
    /**
     * Adds 1 to the score of the CPU Player
     */
    public void addAI(){
        scoreAI++;
    }
    /**
     * 
     */
    public void winRatio(){
        int ratioAI = 0;
        int ratioHuman = 0;
        if(scoreAI > scoreHuman && scoreAI % scoreHuman != 0){
            ratioAI = scoreAI/scoreHuman;
            ratioHuman = 1;
        }
        else if(scoreHuman > scoreAI && scoreHuman % scoreAI != 0){
            ratioHuman = scoreHuman/scoreAI;
            ratioAI = 1;
        }
        System.out.println("You have a winning ratio of " + ratioHuman + "-" + ratioAI);
    }
    /**
     * Checks the final scores of both the CPU and Human and prints who won the most time or if it is a tie. It then stops the program.
     */
    public void Winner(){
        
        if(scoreHuman > scoreAI)
            System.out.println("Player wins. Good Job!!!!!!");
        else if(scoreHuman < scoreAI)
            System.out.println("AI wins. The day of our AI overlords has begun.");
            
        else
            System.out.println("No one wins...");
        
        winRatio();
        System.exit(0);
    }

}
