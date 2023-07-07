package com.example.dzidzi.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.R;
import com.example.dzidzi.Recyclerviewsupperinterface;

import java.util.ArrayList;

public class SupperAdapter extends RecyclerView.Adapter<SupperAdapter.MyViewHolder> {

    //Recyclerview

    private final Recyclerviewsupperinterface recyclerviewsupperinterface;
    private final ArrayList<Recipe> SupperArr;
    Context context;
    private ArrayList<Recipe> supperArr = new ArrayList<>();

    public SupperAdapter(Context context, ArrayList<Recipe> SupperArr, Recyclerviewsupperinterface recyclerviewsupperinterface) {
        this.context = context;
        this.SupperArr = SupperArr;
        this.recyclerviewsupperinterface = recyclerviewsupperinterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.superview, parent, false);

        return new SupperAdapter.MyViewHolder(view, recyclerviewsupperinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(supperArr.get(position).getImg());
        holder.textView.setText(supperArr.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return supperArr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView, Recyclerviewsupperinterface recyclerviewsupperinterface ) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SupperAdapter.this.recyclerviewsupperinterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                          SupperAdapter.this.recyclerviewsupperinterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}