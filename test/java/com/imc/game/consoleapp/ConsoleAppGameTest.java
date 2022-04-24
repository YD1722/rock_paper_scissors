package com.imc.game.consoleapp;

import com.imc.model.Symbol;
import com.imc.util.IGameConsole;
import com.imc.util.TestGameConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleAppGameTest {
    ConsoleAppGame consoleAppGame;
    IGameConsole gameConsole;

    @BeforeEach
    public void startUp() {
        gameConsole = new TestGameConsole();
        consoleAppGame = new ConsoleAppGame(gameConsole);
    }

    @Test
    public void shouldValidateUserInputMove() {
        assertTrue(consoleAppGame.isValidUserMove("R"));
        assertTrue(consoleAppGame.isValidUserMove("S"));
        assertTrue(consoleAppGame.isValidUserMove("P"));
        assertTrue(consoleAppGame.isValidUserMove("EXIT"));
        assertFalse(consoleAppGame.isValidUserMove("d"));
        assertFalse(consoleAppGame.isValidUserMove("r"));
    }

    @Test
    public void shouldGetCorrectSymbolFromUserInputCode() {
        assertEquals(Symbol.ROCK, consoleAppGame.getSymbolFromInputCode("R"));
        assertEquals(Symbol.SCISSORS, consoleAppGame.getSymbolFromInputCode("S"));
        assertEquals(Symbol.PAPER, consoleAppGame.getSymbolFromInputCode("P"));
    }
}
