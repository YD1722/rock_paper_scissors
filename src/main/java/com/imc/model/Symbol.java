package com.imc.model;

public enum Symbol {
    ROCK,
    PAPER,
    SCISSORS;

    public boolean beats(Symbol s1) {
        switch (this) {
            case ROCK:
                return s1 == SCISSORS;
            case PAPER:
                return s1 == ROCK;
            case SCISSORS:
                return s1 == PAPER;
        }

        return false;
    }
}
