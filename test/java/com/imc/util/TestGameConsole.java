package com.imc.util;

import com.imc.util.console.IGameConsole;

public class TestGameConsole implements IGameConsole {
    @Override
    public String readString() {
        return null;
    }

    @Override
    public String readString(String message) {
        return null;
    }

    @Override
    public int readNumber() {
        return 0;
    }

    @Override
    public int readNumber(String message) {
        return 0;
    }

    @Override
    public void writeToConsole(String message) {

    }

    @Override
    public void writeToConsole(String... messages) {

    }
}
