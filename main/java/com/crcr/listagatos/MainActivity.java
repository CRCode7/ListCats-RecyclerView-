package com.crcr.listagatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Gato> gatos;
    private RecyclerView listaGatos;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filename,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent = new Intent(this,UltimosFavoritos.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaGatos = (RecyclerView) findViewById(R.id.rvGatos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaGatos.setLayoutManager(llm);

        inicializarListaGatos();
        inicializaAdaptador();



    }

        public void inicializarListaGatos(){
            gatos = new ArrayList<Gato>();

            gatos.add(new Gato(R.drawable.onegatosomali,"Gato Somali","3"));
            gatos.add(new Gato(R.drawable.twogatohimalayo,"Gato Himalayo","4"));
            gatos.add(new Gato(R.drawable.threecymric,"Cymric","2"));
            gatos.add(new Gato(R.drawable.foursnowshoe,"Snowshoe","5"));
            gatos.add(new Gato(R.drawable.fivegatopersa,"Gato Persa","4"));
        }

        public void inicializaAdaptador(){
            GatoAdaptador adaptador = new GatoAdaptador(gatos, this);
            listaGatos.setAdapter(adaptador);
        }


}
