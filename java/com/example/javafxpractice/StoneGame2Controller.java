package com.example.javafxpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Arrays;

public class StoneGame2Controller {
    @FXML
    private TextField stoneNum;
    @FXML
    private TextField member;
    @FXML
    private TextField symbolShape;

    private String symbol1;
    @FXML
    private String[] members;

    private int memberCount;
    @FXML
    private Label symbol;

    @FXML
    private TextField num;
    @FXML
    private Label stone;

    public int turn;

    @FXML
    private Label player;
    @FXML
    private Label warning;

    @FXML
    private TextField limit;

    @FXML
    private TextField winner;

    @FXML
    private TextField looser;

    @FXML
    public void initialize() {
        this.memberCount = 0;
        this.turn = 0;
    }

    @FXML
    public void stoneInit(ActionEvent actionEvent){
        var stoneNumValue = Integer.parseInt(stoneNum.getText());
        stone.setText(String.valueOf(stoneNumValue));
    }

    @FXML
    void memberInput(ActionEvent event) {

        String input = member.getText();
        if (input != null && !input.trim().isEmpty()) {
            members = input.split(",");
            // デバッグ用にコンソールに出力
            System.out.println(Arrays.toString(members));
            player.setText(members[turn] + "の番");
            System.out.println(members[0]);
            int memberCountValue = members.length;
            this.memberCount = memberCountValue - 1;
        }
    }

    @FXML
    public void symbolInput(){
        symbol1 = symbolShape.getText();

        var stoneValue = Integer.parseInt(stone.getText());
        symbol.setText("");
        for(var i = 0; i < stoneValue; i++) {
            symbol.setText(symbol.getText() + symbol1);
        }

    }

    @FXML
    public void getStone(ActionEvent actionEvent){
        var num1Value = Integer.parseInt(num.getText());
        var limitValue = Integer.parseInt(limit.getText());
        if (num1Value > limitValue || num1Value <= 0){
            warning.setText("1~" + limitValue + "で入力してください");
        }else {
            var stoneValue = Integer.parseInt(stone.getText());
            if(stoneValue - num1Value > 0) {
                stone.setText(String.valueOf(stoneValue - num1Value));
                symbol.setText("");

                for(var i = 0; i < stoneValue - num1Value; i++){
                    symbol.setText(symbol.getText() + symbol1);
                    }

                if(turn == memberCount){
                    turn = 0;
                }else {
                    this.turn += 1;
                }
                System.out.println(turn);
                player.setText(members[turn] + "の番");

            }else{
                if (turn == 0) {
                    symbol.setText("");
                    winner.setText(members[memberCount]);
                    looser.setText(members[turn]);
                    stone.setText("0");
                } else{
                    symbol.setText("");
                    winner.setText(members[turn - 1]);
                    looser.setText(members[turn]);
                    stone.setText("0");
                }
            }
        }

    }
}
