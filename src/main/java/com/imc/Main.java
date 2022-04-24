package com.imc;

import com.imc.game.IGame;
import com.imc.game.consoleapp.SingleUserConsoleAppGame;
import com.imc.game.exception.GameRuntimeException;
import com.imc.util.GameConsole;
import com.imc.util.IGameConsole;

public class Main {
    public static void main(String[] args) {
        // TODO: Introduce DI
        IGameConsole gameConsole = new GameConsole();
        IGame game = new SingleUserConsoleAppGame(gameConsole);

        try {
            game.start();
        } catch (GameRuntimeException e) {
            // TODO: Implement logger
            e.printStackTrace();
        }
    }
}
