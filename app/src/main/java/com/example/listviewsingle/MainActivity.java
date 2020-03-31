package com.example.listviewsingle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private List<String> animalesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos la lista con el listView del layout
        lista = (ListView)findViewById(R.id.ListViewAnimales);

        animalesList = new ArrayList<>();
        animalesList.add("Aquiles");
        animalesList.add("Dana");
        animalesList.add("Titan");
        animalesList.add("Layka");


        //Vamos a utilizar en este caso un adaptador que viene integrado en android

        ArrayAdapter<String> adaptadorAnimales = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                animalesList
        );

        //conectamos la lista con el adaptador
        lista.setAdapter(adaptadorAnimales);

        //Evento click sobre cada elemento de la lista
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Animal seleccionado: "+animalesList.get(i), Toast.LENGTH_SHORT).show();

        //este codigo es para realizar una animacion en el elemento que se pulse
        view.animate().rotation(360).setDuration(1000).start();

    }
}
