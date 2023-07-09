package com.example.dzidzi.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    ArrayList<Recipe> allRecipesArr = new ArrayList<>();
    Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setAllRecipesArr(ArrayList<Recipe> allRecipesArr) {
        this.allRecipesArr = allRecipesArr;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.searchText.setText(allRecipesArr.get(position).getName());
            holder.imageView.setImageResource(allRecipesArr.get(position).getImg());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodIngredients = allRecipesArr.get(holder.getAdapterPosition()).getIngredients();
                String foodInstructions = allRecipesArr.get(holder.getAdapterPosition()).getInstructions();
                String foodRecipeName = allRecipesArr.get(holder.getAdapterPosition()).getName();
                int foodImage = allRecipesArr.get(holder.getAdapterPosition()).getImg();
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
        return allRecipesArr.size();
    }

    public void filterList(ArrayList<Recipe>filteredList){
        allRecipesArr = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView searchText;
        private ImageView imageView;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            searchText = itemView.findViewById(R.id.itemSearchView);
            imageView = itemView.findViewById(R.id.searchImageView);

        }
    }
}
