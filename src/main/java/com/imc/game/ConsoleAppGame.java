package com.imc.game;

import com.imc.game.console.GameConsole;
import com.imc.game.console.IGameConsole;
import com.imc.model.*;

public class ConsoleAppGame implements IGame {
    private final String EXIT_CODE = "EXIT";
    private IGameConsole gameConsole;

    public ConsoleAppGame() {
        this.gameConsole = new GameConsole();
    }

    public void start() {
        String playerName = gameConsole.readString("Player name : ");
        int nuOfRounds = gameConsole.readNumber("How many rounds do you want to play ? :");

        IComputerPlayer computer = new ComputerPlayer();
        IUser user = new User(playerName);

        startNewGameSessionWithComputer(user, computer, nuOfRounds);
    }

    /**
     * Start new console app game with computer
     *
     * @param user
     * @param computerPlayer
     * @param nuOfRounds
     */
    private void startNewGameSessionWithComputer(IUser user, IComputerPlayer computerPlayer, int nuOfRounds) {
        final String INVALID_SYMBOL = "Invalid Move";

        IGameSession gameSession = new GameSession(user, computerPlayer);
        int roundNo = 1;

        while (nuOfRounds >= roundNo) {
            gameConsole.writeToConsole("\n", "====== ROUND : " + roundNo + " ======");

            String userMove = getUserMove();

            if (!isValidUserMove(userMove)) {
                gameConsole.writeToConsole(INVALID_SYMBOL);
                continue;
            }

            if (userMove.equals(EXIT_CODE)) {
                break;
            }

            Symbol symbol = getSymbolFromInputCode(userMove);

            user.setNextMove(symbol);
            computerPlayer.setNextMove();

            Result result = gameSession.play();
            showResult(result);

            roundNo++;
        }
    }

    private String getUserMove() {
        gameConsole.writeToConsole("Type " + EXIT_CODE + " to exit from the game");
        gameConsole.writeToConsole("\nSelect your move (R/P/S)\n" +
                " R - ROCK\n" +
                " P - PAPER\n" +
                " S - SCISSORS\n");

        String userInput = gameConsole.readString().toUpperCase();

        return userInput;
    }

    private Symbol getSymbolFromInputCode(String inputCode) {
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

    private boolean isValidUserMove(String userInput) {
        if (userInput.equals(EXIT_CODE) || userInput.equals("R") || userInput.equals("P") || userInput.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    private void showResult(Result result) {
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
}
