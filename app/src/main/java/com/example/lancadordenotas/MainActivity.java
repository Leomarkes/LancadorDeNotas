package com.example.lancadordenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void situacaoFinal(View view){
        EditText name = findViewById(R.id.editTextName);
        EditText nota1 = findViewById(R.id.editTextNota1);
        EditText nota2 = findViewById(R.id.editTextNota2);
        EditText freq = findViewById(R.id.editTextFreq);

        if (name.length() == 0){
            Toast.makeText(this, "Insira um nome", Toast.LENGTH_SHORT).show();
        } else if(nota1.length() == 0 || nota2.length() == 0 || freq.length() == 0){
            Toast.makeText(this, "Insira todas as notas e a frequência", Toast.LENGTH_SHORT).show();
        } else {

            Double n1 = Double.parseDouble(nota1.getText().toString());
            Double n2 = Double.parseDouble(nota2.getText().toString());
            int fq = Integer.parseInt(freq.getText().toString());
            String n = name.getText().toString();

            if (n1 > 10 || n2 > 10) {
                Toast.makeText(this, "Somente notas entre 0 e 10", Toast.LENGTH_SHORT).show();
            } else if (fq > 100) {
                Toast.makeText(this, "Frequência deve estar 0 e 100", Toast.LENGTH_SHORT).show();
            } else {

                Intent it = new Intent(this, Situacao.class);

                Bundle params = new Bundle();
                params.putString("name", n);
                params.putDouble("nota1", n1);
                params.putDouble("nota2", n2);
                params.putInt("freq", fq);

                it.putExtras(params);

                startActivity(it);

//            finish();
            }
        }
    }
}