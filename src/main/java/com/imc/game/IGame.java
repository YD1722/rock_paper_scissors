package com.imc.game;

import com.imc.game.exception.GameRuntimeException;

public interface IGame {
    void start() throws GameRuntimeException;
}
