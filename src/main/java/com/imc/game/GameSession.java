package com.imc.game;

import com.imc.model.IPlayer;
import com.imc.model.Result;
import com.imc.model.ResultType;
import com.imc.model.Symbol;


public class GameSession implements IGameSession {
    private int sessionId;
    private IPlayer player1;
    private IPlayer player2;

    public GameSession(IPlayer player1, IPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Result play() {
        Result result = new Result();

        Symbol s1 = player1.getMove();
        Symbol s2 = player2.getMove();

        result.setPlayer1(player1);
        result.setPlayer2(player2);

        Symbol winningSymbol = GameEngine.getWinningSymbol(s1, s2);

        if (winningSymbol == null) {
            result.setResultType(ResultType.TIE);
        } else {
            result.setResultType(ResultType.NORMAL);
        }

        if (winningSymbol == s1) {
            result.setWinner(player1);
        }

        if (winningSymbol == s2) {
            result.setWinner(player2);
        }

        return result;
    }
}
