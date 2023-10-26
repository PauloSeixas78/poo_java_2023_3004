package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Tela_Cadastro_Racoes extends AppCompatActivity {

    Databasehelper helper;
    EditText marca;
    EditText quantidade;
    Spinner tipo;
    Spinner porte;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_racoes);

        marca = (EditText) findViewById(R.id.editTextCadastroRacaoMarca);
        quantidade = (EditText) findViewById(R.id.editTextCadastroRacaoQuantidade);
        tipo = (Spinner) findViewById(R.id.spinnerCadastroRacaoTipo);
        porte = (Spinner) findViewById(R.id.spinneCadastroRacaoPorte);
        salvar = (Button) findViewById(R.id.buttonCadastroRacaoSalvar);

        helper = new Databasehelper(this);

    }

    public void salvarRacao(View view){

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("marca",marca.getText().toString());
        valores.put("quantidade",quantidade.getText().toString());
        valores.put("tipo",tipo.getSelectedItem().toString());
        valores.put("porte",porte.getSelectedItem().toString());

        long resultado = db.insert("racoes",null,valores);

        if (resultado != -1){
            Toast.makeText(this,"Racao salva",Toast.LENGTH_SHORT);
        }else {
            Toast.makeText(this,"Erro ao salvar racao",Toast.LENGTH_SHORT);
        }

    }
}