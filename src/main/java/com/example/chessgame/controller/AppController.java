package com.example.chessgame.controller;

import com.example.chessgame.controller.boards.BoardController;
import com.example.chessgame.controller.fileHandler.ChessFileHandler;
import com.example.chessgame.controller.fileHandler.FileHandler;
import com.example.chessgame.controller.gamemanager.GameManager;
import com.example.chessgame.model.GameState;
import com.example.chessgame.model.moves.Move;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class AppController {

    @FXML GridPane gridPane;
    @FXML private Button blackPawn1;
    @FXML private Button blackPawn2;
    @FXML private Button blackPawn3;
    @FXML private Button blackPawn4;
    @FXML private Button blackPawn5;
    @FXML private Button blackPawn6;
    @FXML private Button blackPawn7;
    @FXML private Button blackPawn8;
    @FXML private Button blackRook1;
    @FXML private Button blackRook2;
    @FXML private Button blackBishop1;
    @FXML private Button blackBishop2;
    @FXML private Button blackKnight1;
    @FXML private Button blackKnight2;
    @FXML private Button blackKing;
    @FXML private Button blackQueen;

    @FXML
    private Button whiteBishop1;
    @FXML
    private Button whiteBishop2;
    @FXML
    private Button whiteKing;
    @FXML
    private Button whiteKnight1;
    @FXML private Button whiteKnight2;
    @FXML private Button whitePawn1;
    @FXML private Button whitePawn2;
    @FXML private Button whitePawn3;
    @FXML private Button whitePawn4;
    @FXML private Button whitePawn5;
    @FXML private Button whitePawn6;
    @FXML private Button whitePawn7;
    @FXML private Button whitePawn8;
    @FXML private Button whiteQueen;
    @FXML private Button whiteRook1;
    @FXML private Button whiteRook2;

    @FXML private TextArea movesAvailable;

    @FXML private TextField chosenMove;

    @FXML private Button moveBtn;

    @FXML private TextField nameField;
    @FXML private Button saveResult;
    @FXML private TextArea results;
    @FXML private Button getSavedResults;
    @FXML private Text winnerText;

    Map<Region, Move> regionsSelected = new HashMap<>();
    Button pieceSelected = null;
    String winner;

    FileHandler fileHandler;
    GameManager gameManager;
    BoardController boardController;

    public AppController() {
        gameManager = new GameManager();
        boardController = new BoardController(gameManager);
        fileHandler = new ChessFileHandler();
    }

    public void onGetSavedResultsClick() throws FileNotFoundException {
        String savedResults = fileHandler.getAllData();
        results.setText(savedResults);
    }

    public void onSaveResultClick() throws IOException {

        if (nameField.getText().length() > 0){
            String lineToWrite = winner + ", Name: " + nameField.getText();
            System.out.println(lineToWrite);
            fileHandler.writeDataToFile(lineToWrite);
            onGetSavedResultsClick();
            saveResult.setDisable(true);
        }
    }





    public void onRegionClick(MouseEvent event){
        Region region = (Region) event.getSource();
        if (regionsSelected.containsKey(region)){

            movePiece(region);
        }
    }




    public void onPieceClick(ActionEvent event){
        if (gameManager.getGameState() == GameState.ACTIVE){
            String playerTurn = boardController.isWhiteTurn() ? "white" : "black";
            Button button = (Button) event.getSource();
            if (button.getId().contains(playerTurn)){
                pieceSelected = button;
                regionsSelected.keySet().forEach(this::removeCellAsPossibleMove);
                regionsSelected.clear();

                List<Move> moves =  boardController.getPieceMoves(button.getId());

                for (Move move : moves) {
                    final int x = move.getEndPosition()[0];
                    final int y = move.getEndPosition()[1];
                    regionsSelected.put(getRegion(x, y), move);
                }

                regionsSelected.keySet().forEach(this::setRegionAsPossibleMove);

            }
            else {
                onButtonClick(button);
            }

        }

    }


    private void onButtonClick(Button button) {
        int[] nodePos = getNodeGridPosition(button);
        Region region = getRegion(nodePos[0], nodePos[1]);
        if (regionsSelected.containsKey(region)){
            movePiece(region);
        }
    }

    private void gameOver(String winner){
        this.winner = winner.toUpperCase() + " WIN";
        winnerText.setText(this.winner);
        winnerText.setVisible(true);
        nameField.setEditable(true);
        saveResult.setDisable(false);
    }

    private void checkGameState(){
        switch (gameManager.getGameState()){
            case BLACK_WIN:
                gameOver("black");
                break;
            case WHITE_WIN:
                gameOver("white");
        }
    }



    private void killPiece(Region region){
        Button piece = getPiece(region);
        piece.setVisible(false);
        gridPane.getChildren().remove(piece);
    }

    private void movePiece(Region region){
        int[] regPos = getNodeGridPosition(region);

        if (hasPiece(region)){
            killPiece(region);
        }

        boolean moveSuccess = boardController.movePiece(pieceSelected.getId(), regionsSelected.get(region));
        if (moveSuccess){
            try {
                gridPane.add(pieceSelected, regPos[0], regPos[1]);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            regionsSelected.keySet().forEach(this::removeCellAsPossibleMove);
            regionsSelected.clear();
            pieceSelected = null;
            checkGameState();
        }
    }


    private void setRegionAsPossibleMove(Region region){
        setBorderWidth(region, 5);
    }

    private void removeCellAsPossibleMove(Region region){
        setBorderWidth(region, 0);
    }


    private void setBorderWidth(Region region, int width){
        String styleCSS = region.getStyle();
        // width is the second to last char in the string => length-2
        String newStyle = styleCSS.substring(0, styleCSS.length() - 2) + width +";";
        region.setStyle(newStyle);
    }

    private Button getPiece(int x, int y){
        List<Node> nodes = getCell(x, y);
        Node[] sortedCell = sortCell(nodes);
        return (Button) sortedCell[1];
    }

    private Button getPiece(Region region){
        int[] regPos = getNodeGridPosition(region);
        return getPiece(regPos[0], regPos[1]);
    }

    private boolean hasPiece(Region region){
        Button piece = getPiece(region);
        return piece != null;
    }

    private Region getRegion(int x, int y){
        List<Node> nodes = getCell(x, y);
        Node[] sortedCell = sortCell(nodes);
        return (Region) sortedCell[0];
    }


    private int[] getNodeGridPosition(Node node){
        int x = GridPane.getColumnIndex(node);
        int y = GridPane.getRowIndex(node);
        return new int[]{x, y};
    }



    /**
     * Gets the cell on the board given the column and row
     * @param x the column
     * @param y the row
     * @return A list of nodes in the cell, should only be 1 or 2; A region, or a region and a button(piece)
     */
    private List<Node> getCell(int x, int y){
        List<Node> nodes = new ArrayList<>();
        for (Node node : gridPane.getChildren()) {
            try {
                if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
                    nodes.add(node);
                }
            } catch (NullPointerException e){
                System.out.println(node.getClass().getName() + " has no row or column in getCell()");
            }

        }
        return nodes;
    }

    /**
     * Sorts the cell of two nodes
     * @param nodes List of the two nodes to sort
     * @return A Node array: [region, piece]
     */
    private Node[] sortCell(List<Node> nodes){
        Node region = null;
        Node piece = null;
        for (Node node: nodes) {
            if (node.getId() == null) {
                region = node;
            }
            else{
                piece = node;
            }
        }
        return new Node[]{region, piece};
    }



}
