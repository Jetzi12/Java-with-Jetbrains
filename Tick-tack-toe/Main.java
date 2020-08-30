package tictactoe;

public class Main {
    public static void main(String[] args) {
        String[] players = new String[3];
        char[] coords = new char[2];
        int turn = 1;
        int counter = 0;
        int[][] checkArray_1 = new int[3][3];


        Menu newMenu = new Menu("");
        Difficulty settingsOfGame = new Difficulty(players);

        settingsOfGame.setChosenDiff(newMenu.newGameMenu());

        players = settingsOfGame.getChosenDiff();
        GameBoard gameBoard = new GameBoard();
        SearchingForWinner searchingForWinner = new SearchingForWinner();
        gameBoard.showGameBoard();
        
        while(true) {
        coords = settingsOfGame.getCoords(turn, gameBoard.getCheckArray());

        if (gameBoard.isMovePossible(coords)) {
                gameBoard.addMoveToCheckArray(coords, turn);
                gameBoard.setArray(gameBoard.updateArray());
                gameBoard.showGameBoard();
                searchingForWinner.checkIsSomeoneWon(gameBoard.checkArray);
                if (turn == 1){
                    turn = 2;
                } else {
                    turn = 1;
                }

            } else {
                System.out.println("This cell is occupied! Choose another one! ");
            }


counter++;

        gameBoard.setArray(gameBoard.updateArray());

        }
    }
}
