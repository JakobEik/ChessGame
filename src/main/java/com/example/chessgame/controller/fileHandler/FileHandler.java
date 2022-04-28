package com.example.chessgame.controller.fileHandler;

public interface FileHandler {
    void writeToFile(String string);
    String getLine(int line);
    String getAllLines();
}
