package com.example.dzidzi.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Breakfast;
import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Recipe> breakfastArr = new ArrayList<>();

    public BreakfastAdapter(Context context, ArrayList<Recipe> breakfastArr) {
        this.context = context;
        this.breakfastArr = breakfastArr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.breakfastview, parent, false);

        return new BreakfastAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(breakfastArr.get(position).getImg());
        holder.textView.setText(breakfastArr.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return breakfastArr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}