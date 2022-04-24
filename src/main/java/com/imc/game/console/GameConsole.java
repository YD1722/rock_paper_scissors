package com.imc.game.console;

import com.imc.util.ValidationHelper;

import java.util.Scanner;

public class GameConsole implements IGameConsole {
    private final String INVALID_USER_INPUT = "Invalid user input";

    Scanner scanner;

    public GameConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public String readString(String message) {
        printLineToConsole(message);
        return readString();
    }

    @Override
    public int readNumber() {
        return 0;
    }

    @Override
    public int readNumber(String message) {
        int num = 0;
        boolean isValid = false;

        while (!isValid) {
            printLineToConsole(message);
            String userInput = readString();

            if (ValidationHelper.isPositiveNumber(userInput)) {
                num = Integer.parseInt(userInput);
                isValid = true;
            } else {
                printLineToConsole(INVALID_USER_INPUT);
            }
        }

        return num;
    }

    @Override
    public void writeToConsole(String... messages) {
        for (String message : messages) {
            writeToConsole(message);
        }
    }

    @Override
    public void writeToConsole(String message) {
        printLineToConsole(message);
    }

    private void printLineToConsole(String message) {
        System.out.println(message);
    }
}
