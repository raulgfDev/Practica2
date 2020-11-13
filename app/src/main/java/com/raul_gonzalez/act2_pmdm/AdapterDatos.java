package com.raul_gonzalez.act2_pmdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AdapterDatos
        extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Miembro> listaDatos;
    Context c;
    View v;
    OnItemClickListener onItemClickListener;



    public AdapterDatos(ArrayList<Miembro> listaDatos, Context c) {
        this.c = c;
        this.listaDatos = listaDatos;
        onItemClickListener = (OnItemClickListener) c;

    }

    public interface OnItemClickListener{

        public void onItemClick(Miembro miembro);

    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);


        return new ViewHolderDatos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        final Miembro actual = (Miembro) listaDatos.get(position);

        holder.etNombre.setText(actual.getNombre());
        holder.foto.setImageResource(actual.getFoto());

        //holder.itemView.setOnClickListener(this);

        holder.etNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(actual);
            }
        });

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(actual);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    /*

     @Override
    public void onClick(View view) {

        Context context = view.getContext();

        Intent intent = new Intent(context.getApplicationContext(),act2.class);

        context.startActivity(intent);

    }
     */



    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etNombre;
        ImageView foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            etNombre = (TextView) itemView.findViewById(R.id.idNombre);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }

    }
}
