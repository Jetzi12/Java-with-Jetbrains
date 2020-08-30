package tictactoe;

public class GameBoard {
    protected int[][] checkArray;
    protected String[][] array;

    public GameBoard() {
        this.checkArray = new int[3][3];
        this.array = new String[9][5];
        this.checkArray = resetCheckArray();
        this.array = completeFrameOfArray();
    }


    public int[][] resetCheckArray(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkArray[j][i] = 0;
            }
        }
        return checkArray;
    }

    public String[][] completeFrameOfArray(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {

                array[j][i] = " ";

                if (i == 4 || i == 0) {
                    array[j][i] = "-";
                } else {

                    if (j == 0 || j == 8) {
                        array[j][i] = "|";
                    }

                    if (j == 1 || j == 3 || j == 5 || j == 7) {
                        array[j][i] = " ";
                    }
                }
            }
        }
        return array;
    }

    public void showGameBoard (){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.array[j][i]);
            }
            System.out.println("");
        }
    }

    public boolean isMovePossible (char[] coords) {
        boolean isPossible = false;
        if(this.checkArray[coords[0]][coords[1]] == 0) {
          isPossible = true;
        }
        return isPossible;
    }

    public void addMoveToCheckArray (char[] coords, int turn) {
        int[][] checkArray = this.checkArray;
        checkArray[coords[0]][coords[1]] = turn;

        setCheckArray(checkArray);
    }

    public String[][] updateArray(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {

                this.array[j][i] = " ";

                if (i == 4 || i == 0) {
                    this.array[j][i] = "-";
                } else {

                    if (j == 0 || j == 8) {
                        this.array[j][i] = "|";
                    }

                    if (j == 1 || j == 3 || j == 5 || j == 7) {
                        this.array[j][i] = " ";
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.checkArray[j][i] == 0) {
                    this.array[(2 * j + 2)][(3 - i)] = " ";
                }
                if (this.checkArray[j][i] == 1) {
                    this.array[(2 * j + 2)][(3 - i)] = "X";
                }
                if (this.checkArray[j][i] == 2) {
                    this.array[(2 * j + 2)][(3 - i)] = "O";
                }
            }
        }
        return array;
    }

    public void setCheckArray(int[][] checkArray) {
        this.checkArray = checkArray;
    }

    public int[][] getCheckArray() {
        return checkArray;
    }

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }
}
