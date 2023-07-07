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

import com.example.dzidzi.Lunch;
import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.R;

import java.util.ArrayList;

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.MyViewHolder>{

    Context context;
    private ArrayList<Recipe> lunchArr = new ArrayList<>();

    public LunchAdapter(Context context, ArrayList<Recipe> lunchArr) {
        this.context = context;
        this.lunchArr = lunchArr;
    }

    @NonNull
    @Override
    public LunchAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lunchview, parent, false);
        LunchAdapter.MyViewHolder holder = new LunchAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LunchAdapter.MyViewHolder holder, int position) {

        holder.imageView.setImageResource(lunchArr.get(position).getImg());
        holder.textView.setText(lunchArr.get(position).getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodIngredients = lunchArr.get(holder.getAdapterPosition()).getIngredients();
                String foodInstructions = lunchArr.get(holder.getAdapterPosition()).getInstructions();
                String foodRecipeName = lunchArr.get(holder.getAdapterPosition()).getName();
                int foodImage = lunchArr.get(holder.getAdapterPosition()).getImg();
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
        return lunchArr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.lunchImageView);
            textView = itemView.findViewById(R.id.lunchTextView);
        }
    }
}
