package com.example.dzidzi.Adapters;
import android.content.Context;
import android.content.Intent;
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
        holder.fbImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodIngredients = supperArr.get(holder.getAdapterPosition()).getIngredients();
                String foodInstructions = supperArr.get(holder.getAdapterPosition()).getInstructions();
                String foodRecipeName = supperArr.get(holder.getAdapterPosition()).getName();
                int foodImage = supperArr.get(holder.getAdapterPosition()).getImg();
                Intent intent = new Intent(context, com.example.dzidzi.Recipe.class);
                intent.putExtra("Ingredients", foodIngredients);
                intent.putExtra("Instructions", foodInstructions);
                intent.putExtra("RecipeName", foodRecipeName);
                intent.putExtra("RecipeImg", foodImage);

                context.startActivity(intent);
            }
        });
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

            fbImageView = itemView.findViewById(R.id.supperImageView);
            fbTextView = itemView.findViewById(R.id.supperTextView);
        }
    }
}