package com.example.dzidzi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Models.RecipeCategory;
import com.example.dzidzi.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    Context context;

    ArrayList<RecipeCategory> homeArr = new ArrayList<>();

    public void setHomeArr(ArrayList<RecipeCategory> homeArr) {
        this.homeArr = homeArr;
        notifyDataSetChanged();
    }

    public HomeAdapter(Context context) {
        this.context = context;
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
        holder.imgName.setImageResource(homeArr.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return homeArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        private ImageView imgName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.categoryName);
            imgName = itemView.findViewById(R.id.categoryImg);
        }
    }
}