package com.example.dzidzi.Adapters;

import android.content.Context;
import android.text.style.TabStopSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Models.RecipeCategory;
import com.example.dzidzi.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    Context context;

    public void setHomeArr(ArrayList<RecipeCategory> homeArr) {
        this.homeArr = homeArr;
        notifyDataSetChanged();
    }

    ArrayList<RecipeCategory> homeArr = new ArrayList<>();

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
        holder.imgName.setImageResource(homeArr.get(position).getId());
        holder.txtName.setText(homeArr.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return homeArr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgName;
        CardView catCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.categoryName);
            imgName = itemView.findViewById(R.id.categoryImg);
            catCard = itemView.findViewById(R.id.breakfast_card_id);

        }
    }
}
