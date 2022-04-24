package com.imc.model;

public class Result {
    private ResultType resultType;
    private IPlayer winner;
    private IPlayer player1;
    private IPlayer player2;

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public IPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(IPlayer player1) {
        this.player1 = player1;
    }

    public IPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(IPlayer player2) {
        this.player2 = player2;
    }

    public IPlayer getWinner() {
        return winner;
    }

    public void setWinner(IPlayer winner) {
        this.winner = winner;
    }
}
