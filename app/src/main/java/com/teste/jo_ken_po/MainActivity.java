package com.teste.jo_ken_po;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rockSelected (View view){
        this.setSelectedOption("pedra");
    }

    public void paperSelected (View view){
        this.setSelectedOption("papel");
    }

    public void scissorSelected (View view){
        this.setSelectedOption("tesoura");
    }

    public void setSelectedOption (String userChoice) {
        String appChoice = getAppChoice();
        setResultImage(appChoice);
        generateResult(appChoice, userChoice);
    }

    public String getAppChoice () {
        int number = new Random().nextInt(3); //0 1 2
        String [] options = { "pedra", "papel", "tesoura" };
        String appChoice = options [ number ];

        return appChoice;
    }

    public void setResultImage (String appChoice) {
        ImageView resultImage = findViewById(R.id.resultImage);

        switch ( appChoice ){
            case "pedra" :
                resultImage.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                resultImage.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                resultImage.setImageResource(R.drawable.tesoura);
                break;
        }
    }

    public void generateResult (String appChoice, String userChoice) {
        TextView resultText = findViewById(R.id.resultText);

        if ( checkIfWins(appChoice, userChoice)) { //The winner was App
            resultText.setText("Você perdeu :( ");
        } else if ( checkIfWins(userChoice, appChoice)) { //The winner was User
            resultText.setText("Você ganhou :) ");
        }else{//Empate
            resultText.setText("Empatamos ;) ");
        }
    }

    public Boolean checkIfWins (String firstPlayerChoice, String secondPlayerChoice) {
        Boolean case1 = firstPlayerChoice.equals("tesoura") &&
                secondPlayerChoice.equals("papel");

        Boolean case2 = firstPlayerChoice.equals("papel") &&
                secondPlayerChoice.equals("pedra");

        Boolean case3 = firstPlayerChoice.equals("pedra") &&
                secondPlayerChoice.equals("tesoura");

        if ( case1 || case2 || case3 ) {
            return true;
        }
        return false;
    }
}
