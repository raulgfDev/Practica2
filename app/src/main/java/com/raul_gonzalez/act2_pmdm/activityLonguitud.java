package com.raul_gonzalez.act2_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class activityLonguitud
        extends AppCompatActivity
        implements AdapterRecycler.OnItemClickListener {

    ArrayList<Item> datos;

    HashMap<String,Double> comparadorMedidas;

    RecyclerView recyclerViewOrigen;
    RecyclerView recyclerViewDestino;
    TextView etOrigen;
    TextView etDestino;
    TextView etResultado;
    EditText txtCantidad;
    Button btnConvertir;
    Button btnLimpiar;

    boolean estaOrigen = true;



    private final double baseConstante = 0.001;
    private double exponenteVariable;

    private String origen;
    private String destino;
    private double cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        recyclerViewOrigen = findViewById(R.id.recyIdent);

        etOrigen = findViewById(R.id.etOrigen);
        etDestino = findViewById(R.id.etDestino);
        etResultado = findViewById(R.id.etResultado);
        txtCantidad = findViewById(R.id.txtCantidad);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnLimpiar = findViewById(R.id.btnLimpiar);


        //recyclerViewOrigen.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //recyclerViewDestino.findViewById(R.id.RecyclerViewDestino);
        //recyclerViewDestino.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        datos = new ArrayList<>();

        datos.add(new Item("Hectometro"));
        datos.add(new Item("Decametro"));
        datos.add(new Item("Hectometro"));
        datos.add(new Item("Hectometro"));
        datos.add(new Item("Hectometro"));
        datos.add(new Item("Hectometro"));
        datos.add(new Item("Hectometro"));
        datos.add(new Item("Hectometro"));



        /*
        botones.add(new Button(getApplicationContext()));
        botones.get(1).setText("Hectometro");
        botones.add(new Button(getApplicationContext()));
        botones.get(2).setText("Decametro");
        botones.add(new Button(getApplicationContext()));
        botones.get(3).setText("Metro");
        botones.add(new Button(getApplicationContext()));
        botones.get(4).setText("decimetro");
        botones.add(new Button(getApplicationContext()));
        botones.get(5).setText("centrimetro");
        botones.add(new Button(getApplicationContext()));
        botones.get(6).setText("milimetro");

         */

        AdapterRecycler adapter = new AdapterRecycler(datos,this);

        recyclerViewOrigen.setAdapter(adapter);
//        recyclerViewDestino.setAdapter(adapter);

        comparadorMedidas = rellenaComparador();


        origen = etOrigen.getText().toString();
        destino = etDestino.getText().toString();
//        cantidad = Double.parseDouble(etCantidad.getText().toString());

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(origen.equals("Origen") || destino.equals("Destino")){

                    Toast.makeText(getApplicationContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
                }else{
                    String resultado = String.valueOf(algoritmo(cantidad,origen,destino));
                    etResultado.setText(resultado);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                estaOrigen = true;
                etOrigen.setText("Origen");
                etDestino.setText("Destino");
                txtCantidad.setText("0.00");

            }
        });

    }

    public HashMap rellenaComparador (){

        HashMap<String,Double> salida = new HashMap<>();

        salida.put("milimetro", 0.001);
        salida.put("centimetro", 0.01);
        salida.put("decimetro", 0.1);
        salida.put("metro", 1.0);
        salida.put("decametro", 10.0);
        salida.put("hectometro", 100.0);
        salida.put("kilometro", 1000.0);

        return salida;
    }

    public double algoritmo(double cantidad,String origen,String destino){

        double salida;

        Double o = comparadorMedidas.get(origen);
        Double d = comparadorMedidas.get(destino);

        if(o > d){

            exponenteVariable = o - d;
            salida = (cantidad * Math.pow(baseConstante, exponenteVariable));

        } else if(o < d){

            exponenteVariable = d - o;
            salida = (cantidad / Math.pow(baseConstante,exponenteVariable));

        }else {

            salida = cantidad;

        }

        return salida;
    }

    @Override
    public void onItemClick(TextView textView) {

        if(estaOrigen){
            etOrigen.setText(textView.getText());
            estaOrigen = false;
        }else{
            etDestino.setText(textView.getText());
            estaOrigen = true;
        }

    }
}