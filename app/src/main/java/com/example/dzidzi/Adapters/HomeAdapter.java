package com.example.dzidzi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Models.RecipeCategory;
import com.example.dzidzi.R;

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
            holder.imgView.setImageResource(homeArr.get(position).getId());
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