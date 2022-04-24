package com.imc.model;

public abstract class Player implements IPlayer {
    private String name;
    private Symbol move;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Symbol getMove() {
        return move;
    }

    public void setMove(Symbol move) {
        this.move = move;
    }
}
