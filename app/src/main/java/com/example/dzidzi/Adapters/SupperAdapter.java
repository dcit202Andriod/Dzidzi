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

import java.util.ArrayList;

public class SupperAdapter extends RecyclerView.Adapter<SupperAdapter.MyViewHolder> {

    //Recyclerview
    ArrayList<Recipe> supperArr = new ArrayList<>();
    Context context;

    public SupperAdapter(Context context, ArrayList<Recipe> supperArr) {
        this.context = context;
        this.supperArr = supperArr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.superview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.fbImageView.setImageResource(supperArr.get(position).getImg());
        holder.fbTextView.setText(supperArr.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return supperArr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView fbImageView;
        TextView fbTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fbImageView = itemView.findViewById(R.id.fbImageView);
            fbTextView = itemView.findViewById(R.id.fbTextView);
        }
    }
}