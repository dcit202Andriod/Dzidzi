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

import com.example.dzidzi.Breakfast;
import com.example.dzidzi.Lunch;
import com.example.dzidzi.Models.RecipeCategory;
import com.example.dzidzi.R;
import com.example.dzidzi.Supper;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    ArrayList<RecipeCategory> homeArr = new ArrayList<>();

    Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setHomeArr(ArrayList<RecipeCategory> homeArr) {
        this.homeArr = homeArr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtName.setText(homeArr.get(position).getCategory());
            holder.imgView.setImageResource(homeArr.get(position).getImg());
            holder.imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (homeArr.get(holder.getAdapterPosition()).getId() == 1) {
                        Intent i = new Intent(context, Breakfast.class);
                        context.startActivity(i);
                    } else if (homeArr.get(holder.getAdapterPosition()).getId() == 2) {
                        Intent i = new Intent(context, Lunch.class);
                        context.startActivity(i);
                    } else if (homeArr.get(holder.getAdapterPosition()).getId() == 3) {
                        Intent i = new Intent(context, Supper.class);
                        context.startActivity(i);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return homeArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        private CardView cardView;
        private ImageView imgView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.categoryName);
            cardView = itemView.findViewById(R.id.breakfast_card_id);
            imgView = itemView.findViewById(R.id.categoryImg);
        }
    }
}