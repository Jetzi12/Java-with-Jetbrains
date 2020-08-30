package tictactoe;
import java.util.Random;

public class HardDifficulty extends Difficulty {
    private int counterFunctionCalls = 0;

    public String coords;
    public HardDifficulty (String[] players) { super(players);}

public String hardMove(int[][] checkArray, int turn) {
    int[][] checkArray_1 = new int[3][3];
    int opositeTurn;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            checkArray_1[i][j] = 0;
            checkArray_1[i][j] = checkArray[i][j];
        }
    }
    if( turn == 1) {
        opositeTurn = 2;
    } else {
        opositeTurn = 1;
    }

        String coords = "";
        int bestScore = Integer.MIN_VALUE;
        int score = 0;
        for(int a = 0; a < 3; a++) {
            for(int j = 0; j < 3; j++) {

                if (checkArray_1[a][j] == 0) {
                    checkArray_1[a][j] = turn;

                    score = minmax(checkArray_1, 0, false, turn);
                    System.out.println("Score: " + score);
                    checkArray_1[a][j] = 0;
                   if (score > bestScore) {
                       bestScore = score;
                        coords = Integer.toString(a + 1) + Integer.toString(j + 1);
                        System.out.println(coords);
                    }
                }
            }
        }

        return coords;
}

private int minmax(int[][] checkArray_1, int depth, boolean isMaximizing, int turn) {
        int opositeTurn;
        int score;
         int bestScore = Integer.MIN_VALUE;
         int bestScoreMAX = Integer.MAX_VALUE;
         int emptySpaces = 0;

    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            if(checkArray_1[i][j] == 0){
             emptySpaces++;
            }
        }
        }

        if( turn == 1) {
            opositeTurn = 2;
        } else {
            opositeTurn = 1;
        }

    if (winning(opositeTurn, checkArray_1)){
        score = -1;
        return score;
    }
    if (winning(turn , checkArray_1)){
        score = 1;
        return score;
    }
    if(emptySpaces == 0){
        score = 0;
        return score;
    }

    if(isMaximizing) {
        bestScore = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
            if(checkArray_1[i][j] == 0){
                checkArray_1[i][j] = turn;
                score = minmax(checkArray_1,depth + 1, false , turn);
                checkArray_1[i][j] = 0;
                bestScore = Math.max(score, bestScore);

            }
            }
        }
        return bestScore;
    } else {
        bestScore = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(checkArray_1[i][j] == 0){
                    checkArray_1[i][j] = opositeTurn;
                    score = minmax(checkArray_1,depth + 1, true,turn);
                    checkArray_1[i][j] = 0;
                    bestScore = Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }

}

private boolean winning(int player, int[][] checkArray_1){
        int[][] board = checkArray_1;
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player) || (board[0][0] == player && board[0][1] == player && board[0][2] == player) || (board[1][0] == player && board[1][1] == player && board[1][2] == player) || (board[2][0] == player && board[2][1] == player && board[2][2] == player) || (board[0][0] == player && board[1][0] == player && board[2][0] == player) || (board[0][1] == player && board[1][1] == player && board[2][1] == player) || (board[0][2] == player && board[1][2] == player && board[2][2] == player)) {
            return true;
        } else {
            return false;
    }
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
