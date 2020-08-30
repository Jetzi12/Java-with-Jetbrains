package tictactoe;

import java.util.Scanner;

public class ReadCommands {
    private String command;

    public ReadCommands(String command) {
        this.command = command;
    }

    public void setCommand() {
        Scanner s = new Scanner(System.in);
        this.command = s.nextLine();
    }

    public String getCommand() {
        return command;
    }
}
