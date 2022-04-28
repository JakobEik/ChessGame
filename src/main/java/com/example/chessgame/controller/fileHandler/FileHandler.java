package com.example.chessgame.controller.fileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileHandler {
    void writeNewLineToFile(String line) throws IOException;
    String getLine(int lineNumber);
    String getAllLines() throws FileNotFoundException;
}
