package tictactoe;

public class SearchingForWinner {
    private boolean playerXWon;
    private boolean playerOWon;

    public SearchingForWinner() {
        this.playerOWon = false;
        this.playerXWon = false;
    }

    public void checkIsSomeoneWon(int[][] checkArray) {
        String winner = "";
        int counterDraw = 0 ;
        int counterX = 0;
        int counterO = 0;
        int counter1 = 0;
        int counter;

        for (int i = 0; i < 3; i++) { //searching for 3 in row
            counter = 0;
            counter1 = 0;
            for (int j = 0; j < 3; j++) {
                if (checkArray[j][i] == 1) {
                    counter++;
                    if (counter == 3) {
                        counterX = 1;
                    }
                }
                if (checkArray[j][i] == 2) {
                    counter1++;
                    if (counter1 == 3) {
                        counterO = 1;
                    }
                }
                if (checkArray[j][i] != 0) {
                    counterDraw++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {//searching for 3 in column
            counter = 0;
            counter1 = 0;
            for (int j = 0; j < 3; j++) {
                if (checkArray[i][j] == 1) {
                    counter++;
                    if (counter == 3) {
                        counterX = 1;
                    }
                }
                if (checkArray[i][j] == 2) {
                    counter1++;
                    if (counter1 == 3) {
                        counterO = 1;
                    }
                }
                if (checkArray[i][j] != 0) {
                    counterDraw++;
                }
            }
        }
        if (checkArray[0][0] == 1 && checkArray[1][1] == 1 && checkArray[2][2] == 1) {
            counterX = 1;
        }
        if (checkArray[0][2] == 1 && checkArray[1][1] == 1 && checkArray[2][0] == 1) {
            counterX = 1;
        }
        if (checkArray[0][0] == 2 && checkArray[1][1] == 2 && checkArray[2][2] == 2) {
            counterO = 1;
        }
        if (checkArray[0][2] == 2 && checkArray[1][1] == 2 && checkArray[2][0] == 2) {
            counterO = 1;
        }

        if (counterDraw == 18 && counterX != 1) {

            System.out.println("Draw");
            //end = true;
            //isGameChoosed = false;
           System.exit(0);//delete this line if you want to play more games than one
        }
        if (counterX == 1) {
            System.out.println("X wins");
            // end = true;
            //isGameChoosed = false;
            System.exit(0);
        }
        if (counterO == 1) {
            System.out.println("O wins");
            // end = true;
            //isGameChoosed = false;
            System.exit(0);
        }

    }

    public boolean isPlayerXWon() {
        return playerXWon;
    }

    public boolean isPlayerOWon() {
        return playerOWon;
    }

    public void setPlayerOWon(boolean playerOWon) {
        this.playerOWon = playerOWon;
    }

    public void setPlayerXWon(boolean playerXWon) {
        this.playerXWon = playerXWon;
    }
}
