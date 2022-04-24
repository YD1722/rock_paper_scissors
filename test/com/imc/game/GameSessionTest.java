package com.imc.game;

import com.imc.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameSessionTest {
    IUser player1;
    IUser player2;
    IGameSession gameSession;

    @BeforeEach
    public void setUp() {
        player1 = new User("TEST1");
        player2 = new User("TEST2");


        gameSession = new GameSession(player1, player2);
    }

    @Test
    public void shouldReturnCorrectResultInAGameSession() {
        player1.setNextMove(Symbol.PAPER);
        player2.setNextMove(Symbol.ROCK);

        Result result1 = gameSession.play();

        assertEquals(result1.getResultType(), ResultType.NORMAL);
        assertEquals(result1.getWinner(), player1);

        player1.setNextMove(Symbol.ROCK);
        player2.setNextMove(Symbol.ROCK);

        Result result2 = gameSession.play();

        assertEquals(result2.getResultType(), ResultType.TIE);
        assertNull(result2.getWinner());
    }

}
