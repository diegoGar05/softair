package com.dapo.softair.Utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dapo.softair.R;

import java.util.ArrayList;

public class CustomAdapater extends RecyclerView.Adapter<CustomAdapater.MyViewHolder> {

    private Context context;

    private ArrayList docCli, nomCli, emaCli;

    public CustomAdapater(Context context, ArrayList docCli, ArrayList nomCli, ArrayList emaCli) {
        this.context = context;
        this.docCli = docCli;
        this.nomCli = nomCli;
        this.emaCli = emaCli;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.docCli.setText(String.valueOf(docCli.get(position)));
        holder.nomCli.setText(String.valueOf(nomCli.get(position)));
        holder.emaCli.setText(String.valueOf(emaCli.get(position)));

    }

    @Override
    public int getItemCount() {
        return docCli.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView docCli, nomCli, emaCli;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            docCli = itemView.findViewById(R.id.txtDocClix);
            nomCli = itemView.findViewById(R.id.txtNomClix);
            emaCli = itemView.findViewById(R.id.txtEmaClix);
        }
    }
}
