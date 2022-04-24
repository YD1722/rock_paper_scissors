package com.imc.model;


public class User extends Player implements IUser {
    public User(String name) {
        super(name);
    }

    @Override
    public void setNextMove(Symbol nextMove) {
        this.setMove(nextMove);
    }
}
