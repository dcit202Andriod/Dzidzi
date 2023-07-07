package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dzidzi.Adapters.BreakfastAdapter;
import com.example.dzidzi.Adapters.LunchAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Lunch extends AppCompatActivity {
    RecipeDatabaseHelper lunchDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> lunchArr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        lunchArr = lunchDatabaseHelper.getLunchRecipes();

        RecyclerView recyclerView = findViewById(R.id.lunchRecView);

        LunchAdapter adapter = new LunchAdapter(this, lunchArr);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}