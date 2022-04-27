package com.example.chessgame.view.board;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardGUI {

    private static final float rows = 8;

    public BoardGUI() {

    }


    private GridPane createBoard(int size){
        GridPane board = new GridPane();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {

                Rectangle square = new Rectangle(size/rows, size/rows);
                square.setFill(Color.WHITE);
                square.setStroke(Color.BLACK);

                board.add(new StackPane(square), j, i);

                //square.setOnMouseClicked(event -> drawMove());
            }
        }
        return board;

    }
}
