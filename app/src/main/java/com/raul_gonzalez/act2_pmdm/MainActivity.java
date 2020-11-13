package com.raul_gonzalez.act2_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterDatos.OnItemClickListener {


    ArrayList<Miembro> listaDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listaDatos = new ArrayList<Miembro>();


        listaDatos.add(new Miembro("Peso",R.drawable.basc));
        listaDatos.add(new Miembro("Volumen",R.drawable.bot));
        listaDatos.add(new Miembro("Bytes",R.drawable.hd));
        listaDatos.add(new Miembro("Longuitud",R.drawable.metro));
        listaDatos.add(new Miembro("Temperatura",R.drawable.term));

        AdapterDatos adapter = new AdapterDatos(listaDatos,this);

        recycler.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Miembro miembro) {

        Toast.makeText(getApplicationContext(),miembro.getNombre(),Toast.LENGTH_SHORT).show();



        String pulsacionLonguitud = miembro.getNombre();


        if(pulsacionLonguitud.equals("Longuitud")){
           // Context context = this.getApplicationContext();
            Intent intent = new Intent(this,activityLonguitud.class);
            startActivity(intent);
        }



    }
}