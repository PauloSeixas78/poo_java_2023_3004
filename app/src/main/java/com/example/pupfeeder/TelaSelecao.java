package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSelecao extends AppCompatActivity {

    Button racoes;
    Button agendamento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        racoes = (Button) findViewById(R.id.button_selecao_racao);

        racoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaListaRacoes.class));
            }
        });
/*
        agendamento = (Button) findViewById(R.id.buttonAgendamento);

        agendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaListagemAgendamento.class));
            }
        });
*/
    }
}