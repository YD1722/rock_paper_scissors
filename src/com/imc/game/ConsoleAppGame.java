package com.imc.game;

import com.imc.model.*;

import java.util.Scanner;

public class ConsoleAppGame implements IGame {

    public void start() {
        Scanner scanner = new Scanner(System.in);

        String playerName = getPlayerName(scanner);
        int nuOfRounds = getNumberOfRounds(scanner);

        IComputerPlayer computer = new ComputerPlayer("BOT");
        IUser user = new User(playerName);

        startNewGameSessionWithComputer(scanner, user, computer, nuOfRounds);
    }

    /**
     * Start new console app game with computer
     *
     * @param scanner
     * @param player1
     * @param player2
     * @param nuOfRounds
     */
    private void startNewGameSessionWithComputer(Scanner scanner, IUser player1, IComputerPlayer player2, int nuOfRounds) {
        IGameSession gameSession = new GameSession(player1, player2);

        while (nuOfRounds > 0) {
            Symbol nextMove = getUserMove(scanner);
            player1.setNextMove(nextMove);

            player2.setNextMove();

            Result result = gameSession.play();
            showResult(result);

            nuOfRounds--;
        }
    }

    // TODO: Make sure no null value is return ?
    private Symbol getUserMove(Scanner scanner) {
        boolean isValid = false;
        Symbol userMove = null;

        while (!isValid) {
            printLineToConsole("Select your move (R/P/S)\n" +
                    " 1. ROCK : R\n" +
                    " 2. PAPER : P\n" +
                    " 3. SCISSORS : S\n");

            String nextMoveInput = scanner.nextLine().toUpperCase();

            if (isValidSymbolInput(nextMoveInput)) {
                userMove = getSymbolFromInput(nextMoveInput);
                isValid = true;
            } else {
                printLineToConsole("Invalid input");
            }
        }

        return userMove;
    }

    private Symbol getSymbolFromInput(String userInput) {
        Symbol nextMove = null;

        switch (userInput) {
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

    private boolean isValidSymbolInput(String userInput) {
        if (userInput.equals("R") || userInput.equals("P") || userInput.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    private String getPlayerName(Scanner scanner) {
        printLineToConsole("Enter nickname: ");

        String playerName = scanner.nextLine();
        return playerName;
    }

    // TODO: Handle runtime exception
    private int getNumberOfRounds(Scanner scanner) {
        boolean isValid = false;
        int nuOfRounds = 0;

        while (!isValid) {
            printLineToConsole("Enter number of rounds : ");

            String userInput = scanner.nextLine();

            if (userInput.matches("\\d+")) {
                nuOfRounds = Integer.parseInt(userInput);
                isValid = true;
            } else {
                printLineToConsole("Invalid input");
            }
        }

        return nuOfRounds;
    }

    private void showResult(Result result) {
        IPlayer player1 = result.getPlayer1();
        IPlayer player2 = result.getPlayer2();

        printLineToConsole(player1.getName() + " : " + player1.getMove());
        printLineToConsole(player2.getName() + " : " + player2.getMove());

        if (result.getResultType() == ResultType.TIE) {
            printLineToConsole("Game tied");

            return;
        }

        IPlayer winner = result.getWinner();
        printLineToConsole(winner.getName() + " Won!!");
    }

    private void printLineToConsole(String message) {
        System.out.println(message + "\n");
    }
}
