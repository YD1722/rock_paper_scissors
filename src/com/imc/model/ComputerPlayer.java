package com.imc.model;

import java.util.Random;

public class ComputerPlayer extends Player implements IComputerPlayer {
    public ComputerPlayer(String name) {
        super(name);
    }


    private Symbol getRandomSymbol() {
        int randomNumber = new Random().nextInt(3);
        return Symbol.values()[randomNumber];
    }

    @Override
    public void setNextMove() {
        this.setNextMove(this.getRandomSymbol());
    }
}
