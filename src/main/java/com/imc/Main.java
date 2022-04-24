package com.imc;

import com.imc.game.ConsoleAppGame;
import com.imc.game.IGame;

public class Main {
    public static void main(String[] args) {
        IGame game = new ConsoleAppGame();
        game.start();
    }
}
