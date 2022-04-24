package com.imc.util;


public interface IGameConsole {
    String readString();

    String readString(String message);

    int readNumber();

    int readNumber(String message);

    void writeToConsole(String message);

    void writeToConsole(String ...messages);
}
