package com.example.chessgame.controller.fileHandler;

import java.io.*;
import java.util.Scanner;

public class ChessFileHandler implements FileHandler{

    private final String filePath = "src/main/java/com/example/chessgame/controller/fileHandler/Data.txt";
    private final File file;
    public ChessFileHandler() {
        file = new File(filePath);
    }

    @Override
    public void writeNewLineToFile(String line) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true);
        fileWriter.write(line + "\n");
        fileWriter.close();
    }

    @Override
    public String getLine(int line) {
        return null;
    }

    @Override
    public String getAllLines() throws FileNotFoundException{
        Scanner scanner = new Scanner(file);

        StringBuilder data = new StringBuilder();
        while (scanner.hasNext()){
            data.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return data.toString();
    }
}
