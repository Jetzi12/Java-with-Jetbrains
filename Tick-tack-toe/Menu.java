package tictactoe;

public class Menu {
String menuCommand;
ReadCommands commandsForMenu = new ReadCommands("");

    public Menu ( String command) {
        this.menuCommand = command;
    }

    public String[] newGameMenu () {
        String[] player = new String[3];
        player[0] = ""; player[1] = ""; player[2] = "";
        /*
        Menu takes command from ReadCommands, write them into menuCommand and check which options were chosen.
        Method named newGameMenu returns String to the Difficulty
         */
        while("".equals(player[1])) {
            commandsForMenu.setCommand();
            setMenuCommand();

            switch (getMenuCommand().toLowerCase()) {
                case "start user user":
                    player[1] = "user";
                    player[2] = "user";
                    break;
                case "start user easy":
                    player[1] = "user";
                    player[2] = "easy";
                    break;
                case "start easy user":
                    player[1] = "easy";
                    player[2] = "user";
                    break;
                case "start user medium":
                    player[1] = "user";
                    player[2] = "medium";
                    break;
                case "start medium user":
                    player[1] = "medium";
                    player[2] = "user";
                    break;
                case "start user hard":
                    player[1] = "user";
                    player[2] = "hard";
                    break;
                case "start hard user":
                    player[1] = "hard";
                    player[2] = "user";
                    break;

                case "start easy easy":
                    player[1] = "easy";
                    player[2] = "easy";
                    break;
                case "start medium medium":
                    player[1] = "medium";
                    player[2] = "medium";
                    break;
                case "start hard hard":
                    player[1] = "hard";
                    player[2] = "hard";
                    break;

                case "start medium easy":
                    player[1] = "medium";
                    player[2] = "easy";
                    break;
                case "start easy medium":
                    player[1] = "easy";
                    player[2] = "medium";
                    break;
                case "start easy hard":
                    player[1] = "easy";
                    player[2] = "hard";
                    break;
                case "start hard easy":
                    player[1] = "hard";
                    player[2] = "easy";
                    break;
                case "start medium hard":
                    player[1] = "medium";
                    player[2] = "hard";
                    break;
                case "start hard medium":
                    player[1] = "hard";
                    player[2] = "medium";
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Bad parameters!");
            }
        }

        return player;
    }

    public void setMenuCommand() {
        this.menuCommand = commandsForMenu.getCommand();
    }

    public String getMenuCommand() {
        return menuCommand;
    }
}
