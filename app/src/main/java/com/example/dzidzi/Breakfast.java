package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.dzidzi.Adapters.BreakfastAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity implements RecyclerViewInterface {


    RecipeDatabaseHelper breakfastDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> breakfastArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        BreakfastAdapter adapter = new BreakfastAdapter(this, breakfastArr, this);




        //Breakfast array from database.
        breakfastArr = breakfastDatabaseHelper.getBreakfastRecipes();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Breakfast.this, Recipe.class );

        intent.putExtra("BreakfastName",breakfastArr.get(position).getName());
        intent.putExtra("BreakfastImage",breakfastArr.get(position).getImg());

        startActivity(intent);

    }
}