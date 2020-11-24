package com.example.lancadordenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Situacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situacao);

        TextView n = findViewById(R.id.textViewNome);
        TextView mediaF = findViewById(R.id.textViewMediaF);
        TextView freq = findViewById(R.id.textViewFreq);
        TextView situacao = findViewById(R.id.textViewSitu);

        Double media;

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String name = params.getString("name");
                n.setText(name);

                Double n1 = params.getDouble("nota1");
                Double n2 = params.getDouble("nota2");

                media = (n1 + n2)/2;
                mediaF.setText(String.valueOf(media));

                int frequencia = params.getInt("freq");
                freq.setText(String.valueOf(frequencia));

                situacao.setText(situacao(media, frequencia));
            }
        }
    }

    public String situacao(Double media, int freq){
        String msg;
        if(freq < 75){
            msg = "Reprovado por Frequência";
        }else if (media < 4 && freq >= 75){
            msg = "Reprovado por Nota";
        }else if(freq >= 75 && media >= 4 && media < 7){
            msg = "Final";
        }else{
            msg = "Aprovado";
        }

        return msg;
    }
}