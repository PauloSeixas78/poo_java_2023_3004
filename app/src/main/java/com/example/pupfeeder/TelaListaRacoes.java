package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaListaRacoes extends AppCompatActivity {

    Databasehelper helper;
    Button novaracao;

    ListView listaracoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_racoes);

        listaracoes = findViewById(R.id.listviewTelaListaRacoesLista);

        helper = new Databasehelper(this);

        //String [] lista = new String[]{"Premium","Ro","Racao 3"};


        ArrayAdapter <String> listaracoesadapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,GerarListaRacoes());

        listaracoes.setAdapter(listaracoesadapater);

        novaracao = (Button) findViewById(R.id.buttonListaRacoesNovaRacao);

        novaracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaRacoes.this,Tela_Cadastro_Racoes.class));
            }
        });
    }

    public String [] GerarListaRacoes(){

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT marca FROM racoes",null);
        cursor.moveToFirst();
        String[] lista = new String[cursor.getCount()];
        for (int item = 0; item < cursor.getCount(); item++) {
            lista[item] = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;


    }

    @Override
    protected void onDestroy(){
        helper.close();
        super.onDestroy();
    }

}