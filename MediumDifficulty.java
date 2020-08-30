package tictactoe;
import java.util.Random;

public class MediumDifficulty extends EasyDifficulty {
   private Random random = new Random();

    public MediumDifficulty(String[] players) {
        super(players);
    }

    public String mediumMove(int[][] checkArray, boolean playerXTurn){
        int amountOfX = 0;
        int amountOfO = 0;
        int coordJEmpty = 10;
        int coordIEmpty = 10;
        boolean found = false;
        int signatureOfSymbol;
        String coords = "";
        int randomCoord = 0;


            if(playerXTurn) {
                System.out.println("Player X turn");
            } else {
                System.out.println("Player O turn");
            }

            for (int i = 0; i < 3; i++) { // searching by j
                for (int j = 0; j < 3; j++) {

                    if (checkArray[i][j] == 1) {
                        amountOfX++;
                    }
                    if (checkArray[i][j] == 2) {
                        amountOfO++;
                    }
                    if (checkArray[i][j] == 0) {
                        coordIEmpty = i;
                        coordJEmpty = j;
                    }
                    if (checkArray[i][2] == 0) {
                        coordIEmpty = i;
                        coordJEmpty = 2;
                    }

                    if(playerXTurn) {
                        if (amountOfX == 2) {

                            if (coordJEmpty != 10 && coordIEmpty != 10) {

                                coords = "";
                                coords = Integer.toString(coordIEmpty + 1) + "" + Integer.toString(coordJEmpty + 1);
                                found = true;
                            }
                        }
                        if (!found){
                            if(amountOfO == 2 ){
                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordIEmpty + 1) + "" + Integer.toString(coordJEmpty + 1);
                                    found = true;
                                }
                            }
                        }
                    } else {
                        if (amountOfO == 2) {

                            if (coordJEmpty != 10 && coordIEmpty != 10) {

                                coords = "";
                                coords = Integer.toString(coordIEmpty + 1) + "" + Integer.toString(coordJEmpty + 1);
                                found = true;
                            }
                        }
                        if (!found){
                            if(amountOfX == 2 ){
                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordIEmpty + 1) + "" + Integer.toString(coordJEmpty + 1);
                                    found = true;
                                }
                            }
                        }
                    }

                }
                amountOfX = 0;
                amountOfO = 0;
                coordIEmpty = 10;
                coordJEmpty = 10;
            }


            if(!found) {
                for (int i = 0; i < 3; i++) { // searching by j

                    for (int j = 0; j < 3; j++) {

                        if (checkArray[j][i] == 1) {
                            amountOfX++;
                        }
                        if (checkArray[j][i] == 2) {
                            amountOfO++;
                        }
                        if (checkArray[j][i] == 0) {
                            coordIEmpty = i;
                            coordJEmpty = j;
                        }
                        if (checkArray[2][i] == 0) {
                            coordIEmpty = i;
                            coordJEmpty = 2;
                        }
                        if (playerXTurn){
                            if (amountOfX == 2) {
                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordJEmpty + 1) + "" + Integer.toString(coordIEmpty + 1);
                                    found = true;
                                }
                            }
                            if (amountOfO == 2 && !found) {

                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordJEmpty + 1) + "" + Integer.toString(coordIEmpty + 1);
                                    found = true;
                                }
                            }

                        } else {
                            if (amountOfO == 2) {
                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordJEmpty + 1) + "" + Integer.toString(coordIEmpty + 1);
                                    found = true;
                                }
                            }
                            if (amountOfX == 2 && !found) {

                                if (coordJEmpty != 10 && coordIEmpty != 10) {

                                    coords = "";
                                    coords = Integer.toString(coordJEmpty + 1) + "" + Integer.toString(coordIEmpty + 1);
                                    found = true;
                                }
                            }
                        }
                    }

                    amountOfX = 0;
                    amountOfO = 0;
                    coordIEmpty = 10;
                    coordJEmpty = 10;
                }
            }
// choosing for win
            if(!found) {
                if (playerXTurn) {
                    signatureOfSymbol = 1;
                } else {
                    signatureOfSymbol = 2;
                }

                if (checkArray[0][0] == 0 && checkArray[1][1] == signatureOfSymbol && checkArray[2][2] == signatureOfSymbol) {
                    coords = Integer.toString(1) + "" + Integer.toString(1);

                    found = true;
                }
                if (checkArray[0][0] == signatureOfSymbol && checkArray[1][1] == 0 && checkArray[2][2] == signatureOfSymbol) {
                    coords = Integer.toString(2) + "" + Integer.toString(2);

                    found = true;
                }
                if (checkArray[0][0] == signatureOfSymbol && checkArray[1][1] == signatureOfSymbol && checkArray[2][2] == 0) {
                    coords = Integer.toString(3) + "" + Integer.toString(3);

                    found = true;
                }

                if (checkArray[0][2] == 0 && checkArray[1][1] == signatureOfSymbol && checkArray[2][0] == signatureOfSymbol) {
                    coords = Integer.toString(1) + "" + Integer.toString(1);

                    found = true;
                }
                if (checkArray[0][2] == signatureOfSymbol && checkArray[1][1] == 0 && checkArray[2][0] == signatureOfSymbol) {
                    coords = Integer.toString(2) + "" + Integer.toString(2);

                    found = true;
                }
                if (checkArray[0][2] == signatureOfSymbol && checkArray[1][1] == signatureOfSymbol && checkArray[2][0] == 0) {
                    coords = Integer.toString(3) + "" + Integer.toString(3);

                    found = true;
                }
            }

            if(!found) {
                // choosing for block
                if (playerXTurn) {
                    signatureOfSymbol = 2;
                } else {
                    signatureOfSymbol = 1;
                }

                if (checkArray[0][0] == 0 && checkArray[1][1] == signatureOfSymbol && checkArray[2][2] == signatureOfSymbol) {
                    coords = Integer.toString(1) + "" + Integer.toString(1);

                    found = true;
                }
                if (checkArray[0][0] == signatureOfSymbol && checkArray[1][1] == 0 && checkArray[2][2] == signatureOfSymbol) {
                    coords = Integer.toString(2) + "" + Integer.toString(2);

                    found = true;
                }
                if (checkArray[0][0] == signatureOfSymbol && checkArray[1][1] == signatureOfSymbol && checkArray[2][2] == 0) {
                    coords = Integer.toString(3) + "" + Integer.toString(3);

                    found = true;
                }

                if (checkArray[0][2] == 0 && checkArray[1][1] == signatureOfSymbol && checkArray[2][0] == signatureOfSymbol) {
                    coords = Integer.toString(1) + "" + Integer.toString(1);

                    found = true;
                }
                if (checkArray[0][2] == signatureOfSymbol && checkArray[1][1] == 0 && checkArray[2][0] == signatureOfSymbol) {
                    coords = Integer.toString(2) + "" + Integer.toString(2);

                    found = true;
                }
                if (checkArray[0][2] == signatureOfSymbol && checkArray[1][1] == signatureOfSymbol && checkArray[2][0] == 0) {
                    coords = Integer.toString(3) + "" + Integer.toString(3);

                    found = true;
                }
            }

            if (!found){
                coords = easyMove();
            }
            return coords;
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
