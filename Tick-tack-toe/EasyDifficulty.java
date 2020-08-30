package tictactoe;
import java.util.Random;

public class EasyDifficulty extends Difficulty{
    private Random random = new Random();

    public EasyDifficulty(String[] players){
        super(players);
    }

    public String easyMove(){
        int randomCoord = 0;
        String easyCoords;
        randomCoord = random.nextInt(3) + 1;
        easyCoords = Integer.toString(randomCoord);
        randomCoord = random.nextInt(3) + 1;
        easyCoords = easyCoords + Integer.toString(randomCoord);
        return easyCoords;
    }

    /*
    that part isn't necessary
     */
    @Override
    public void setChosenDiff(String[] players) {
        super.setChosenDiff(players);
    }

    @Override
    public String[] getChosenDiff() {
        return super.getChosenDiff();
    }
}
