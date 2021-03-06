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

    public void setSelectedOption (String userChoice){

        ImageView imagemResultado = findViewById(R.id.resultImage);
        TextView textoResultado = findViewById(R.id.resultText);

        int numero = new Random().nextInt(3);//0 1 2
        String [] opcoes = { "pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch ( escolhaApp ){
            case "pedra" :
                resu.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp.equals("tesoura") && userChoice.equals("papel")) ||
                (escolhaApp.equals("papel") && userChoice.equals("pedra")) ||
                (escolhaApp.equals("pedra") && userChoice.equals("tesoura"))
        ){//App ganhador
            textoResultado.setText("Você perdeu :( ");

        }else if (
                (userChoice == "tesoura" && escolhaApp == "papel") ||
                (userChoice == "papel" && escolhaApp == "pedra") ||
                (userChoice == "pedra" && escolhaApp == "tesoura")
        ){//Usuario ganhador
            textoResultado.setText("Você ganhou :) ");

        }else{//Empate
            textoResultado.setText("Empatamos ;) ");

        }

        System.out.println( "Item clicado: " + escolhaApp );

    }

}
