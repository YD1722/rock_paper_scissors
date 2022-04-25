package com.imc.game.consoleapp;

import com.imc.model.IPlayer;
import com.imc.model.Result;
import com.imc.model.ResultType;
import com.imc.model.Symbol;
import com.imc.util.console.IGameConsole;

public class ConsoleAppGame {
    protected final String EXIT_CODE = "EXIT";
    protected IGameConsole gameConsole;

    public ConsoleAppGame(IGameConsole iGameConsole) {
        this.gameConsole = iGameConsole;
    }

    public String getUserInput() {
        gameConsole.writeToConsole("Type " + EXIT_CODE + " to exit from the game");
        gameConsole.writeToConsole("\nSelect your move (R/P/S)\n" +
                " R - ROCK\n" +
                " P - PAPER\n" +
                " S - SCISSORS\n");

        String userInput = gameConsole.readString().toUpperCase();

        return userInput;
    }

    public void showResult(Result result) {
        IPlayer player1 = result.getPlayer1();
        IPlayer player2 = result.getPlayer2();

        gameConsole.writeToConsole(player1.getName() + " : " + player1.getMove());
        gameConsole.writeToConsole(player2.getName() + " : " + player2.getMove());

        if (result.getResultType() == ResultType.TIE) {
            gameConsole.writeToConsole("Game tied");

            return;
        }

        IPlayer winner = result.getWinner();
        gameConsole.writeToConsole(winner.getName() + " Won!!");
    }

    protected Symbol getSymbolFromInputCode(String inputCode) {
        Symbol nextMove = null;

        switch (inputCode) {
            case "R":
                nextMove = Symbol.ROCK;
                break;

            case "P":
                nextMove = Symbol.PAPER;
                break;

            case "S":
                nextMove = Symbol.SCISSORS;
                break;
        }

        return nextMove;
    }

    protected boolean isValidUserMove(String userInput) {
        if (userInput.equals(EXIT_CODE) || userInput.equals("R") || userInput.equals("P") || userInput.equals("S")) {
            return true;
        } else {
            return false;
        }
    }
}
