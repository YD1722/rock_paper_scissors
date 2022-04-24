package com.imc.game.consoleapp;

import com.imc.game.IGame;
import com.imc.model.Result;

public interface IConsoleAppGame extends IGame {
    String getUserInput();

    void showResult(Result result);
}
