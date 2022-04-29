package com.example.chessgame.controller.fileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileHandler {
    void writeDataToFile(String data) throws IOException;
    String getAllData() throws FileNotFoundException;
}
