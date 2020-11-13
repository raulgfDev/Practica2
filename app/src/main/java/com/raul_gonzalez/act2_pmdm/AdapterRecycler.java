package com.raul_gonzalez.act2_pmdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.HolderAdapter> {

    Context c;
    ArrayList datos;
    View view;
    OnItemClickListener onItemClickListener;

    public AdapterRecycler(ArrayList datos, Context c) {
        this.c = c;
        this.datos = datos;
        onItemClickListener = (OnItemClickListener) c;
    }

    public interface OnItemClickListener{

        public void onItemClick(TextView textView);

    }



    @NonNull
    @Override
    public AdapterRecycler.HolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(c).inflate(R.layout.item_list_2, parent, false);
        return new HolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.HolderAdapter holder, int position) {


        final Item actual = (Item) datos.get(position);
        //TextView actual = (TextView) datos.get(position);
        holder.textView.setText(actual.getNombre());

        /*
            holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(actual);

            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderAdapter extends RecyclerView.ViewHolder {

        TextView textView;

        public HolderAdapter(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtCarta);

        }
    }
}
