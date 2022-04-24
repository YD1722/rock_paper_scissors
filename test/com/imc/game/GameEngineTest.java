package com.imc.game;

import com.imc.game.GameEngine;
import com.imc.model.Symbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEngineTest {
    GameEngine gameEngine;

    @BeforeEach
    public void startUp() {
        gameEngine = new GameEngine();
    }

    @Test
    public void shouldGetCorrectWinningSymbol() {
        Symbol s1 = Symbol.PAPER;
        Symbol s2 = Symbol.ROCK;
        Symbol s3 = Symbol.SCISSORS;

        assertEquals(s1, gameEngine.getWinningSymbol(s1, s2));
        assertEquals(s1, gameEngine.getWinningSymbol(s2, s1));
        assertEquals(s3, gameEngine.getWinningSymbol(s1, s3));
        assertEquals(s2, gameEngine.getWinningSymbol(s2, s3));
        assertEquals(null, gameEngine.getWinningSymbol(s2, s2));
    }
}
