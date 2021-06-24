package com.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Utilizador> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lv = findViewById(R.id.lv);
        lista = new ArrayList<>();

        Utilizador u1 = new Utilizador();
        u1.setMarca("Chevrolet");
        u1.setPlaca("NLK2087");

        Utilizador u2 = new Utilizador("Fiat", "PEN9572");
        Utilizador u3 = new Utilizador("Fiat", "KGM9830");

        lista.add(u1);
        lista.add(u2);
        lista.add(u3);

        ArrayAdapter<Utilizador> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, lista
        );
        lv.setAdapter(adapter);

    }
}