package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StoneGameController {
    @FXML
    private Label symbol;
    @FXML
    private TextField num;
    @FXML
    private Label stone;
//    @FXML
//    public Label turn;

    @FXML
    private Label player;

    @FXML
    private Label limit;

    @FXML
    private TextField winner;

    @FXML
    private TextField looser;

    @FXML
    public void initialize() {
        stone.setText(String.valueOf(20));
        var stoneValue = Integer.parseInt(stone.getText());
        symbol.setText("");

        for(var i = 0; i < stoneValue; i++){
            symbol.setText(symbol.getText() + "●");
        }
        player.setText("Aのターンです");
//        if(this.turn.getText().equals("1")){
//            player.setText("Aのターンです");
//        }else if(this.turn.getText().equals("2")){
//            player.setText("Bのターンです");
//        }
    }
//    @FXML
//    public void player(){
//        if(this.turn.getText().equals("1")){
//            player.setText("Aのターンです");
//        }else if(this.turn.getText().equals("2")){
//            player.setText("Bのターンです");
//        }
//    }

    @FXML
    public void getStone(ActionEvent actionEvent){
        var num1Value = Integer.parseInt(num.getText());
        if (num1Value > 5 || num1Value <= 0){
            limit.setText("1~5で入力してください");
        }else {
            var stoneValue = Integer.parseInt(stone.getText());
            if(stoneValue - num1Value > 0) {
                    stone.setText(String.valueOf(stoneValue - num1Value));
                    symbol.setText("");

                    for(var i = 0; i < stoneValue - num1Value; i++){
                    symbol.setText(symbol.getText() + "●");
                    }
//                if (this.turn.getText().equals("1")) {
//                    turn.setText(String.valueOf(2));
//                } else if (this.turn.getText().equals("2")) {
//                    turn.setText(String.valueOf(1));
//                }
                if (player.getText().equals("Aのターンです")) {
                    player.setText("Bのターンです");
                } else if (player.getText().equals("Bのターンです")) {
                    player.setText("Aのターンです");
                }
            }else{
                if (player.getText().equals("Bのターンです")) {
                    symbol.setText("");
                    winner.setText("player：A");
                    looser.setText("player：B");
                    stone.setText("0");
                } else if (player.getText().equals("Aのターンです")) {
                    symbol.setText("");
                    player.setText("player：B");
                    looser.setText("player：A");
                    stone.setText("0");
                }
            }
        }

    }
}
