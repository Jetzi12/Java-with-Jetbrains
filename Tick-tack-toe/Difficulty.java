package tictactoe;
import java.util.Scanner;

public class Difficulty {
    protected String[] players = new String[3];

    ReadCommands readCoords = new ReadCommands("");

    public Difficulty(String[] players){
        this.players = players;

    }

    public char[] getCoords(int turn, int[][] checkArray){
        String coordes = "";
        char[] coords = new char[2];
        coords[0] = 0;
        coords[1] = 0;
        boolean isCoordsCorrect = false;
        EasyDifficulty difficultyEasy = new EasyDifficulty(this.players);
        MediumDifficulty difficultyMedium = new MediumDifficulty(this.players);
        HardDifficulty difficultyHard = new HardDifficulty(this.players);
        Scanner s = new Scanner(System.in);

        if ("user".equals(this.players[turn])) {

            do{
                System.out.println("Enter the coordinates: ");

                //readCoords.setCommand();
                //coordes = readCoords.getCommand();
                coordes = Integer.toString(s.nextInt());
                coordes = coordes + s.nextInt();
                coords = coordes.toCharArray();
                if(coords.length < 2) {
                    coords[1] = coords[2];

                } else {
                  isCoordsCorrect = isEnteredCoordsCorrect(coords);
                }

            } while(!isCoordsCorrect);
        }

        if ("easy".equals(this.players[turn])) {
            System.out.println("Making move level \"easy\"");
            coordes = difficultyEasy.easyMove();
            coords = coordes.toCharArray();
        }

        if ("medium".equals(this.players[turn])) {
            if(turn == 1) {
                System.out.println("Making move level \"medium\"");
                coordes = difficultyMedium.mediumMove(checkArray,true);
                coords = coordes.toCharArray();

            } else {
                System.out.println("Making move level \"medium\"");
                coordes = difficultyMedium.mediumMove(checkArray,false);
                coords = coordes.toCharArray();
            }

        }

        if ("hard".equals(this.players[turn])) {
            System.out.println("Making move level \"hard\"");

                coordes = difficultyHard.hardMove(checkArray, turn);
                coords = coordes.toCharArray();

        }

        for(int i = 0; i < 2; i++) {
            switch (coords[i]) {
                case 49:
                    coords[i] = 0;
                    break;
                case 50:
                    coords[i] = 1;
                    break;
                case 51:
                    coords[i] = 2;
                    break;
            }
        }

        return coords;
    }
    public boolean isEnteredCoordsCorrect(char[] coords){
        boolean isCorrect = false;
        if(coords[0] == 49 || coords[0] == 50 || coords[0] == 51){
            if(coords[1] == 49 || coords[1] == 50 || coords[1] == 51 ){
                isCorrect = true;
            }
        }
        if (coords[0] >= 52 && coords[0] <= 57 || coords[0] == 48) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (coords[1] >= 52 && coords[1] <= 57 || coords[1] == 48) {
            System.out.println("Coordinates should be from 1 to 3!");
        }

        if (coords[0] < 48 || coords[1] < 48 || coords[0] > 57 || coords[1] > 57) {
            System.out.println("You should enter numbers!");
        }
            return isCorrect;
    }

    public void setChosenDiff(String[] players){
        this.players = players;
    }

    public String[] getChosenDiff() {
        return players;
    }
}
