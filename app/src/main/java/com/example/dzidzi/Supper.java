package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.dzidzi.Adapters.BreakfastAdapter;
import com.example.dzidzi.Adapters.SupperAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Supper extends AppCompatActivity{

    RecyclerView supperRecView;
    RecipeDatabaseHelper supperDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> supperArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supper);

        supperRecView = findViewById(R.id.supperrecview);

        //Supper array from database.
        supperArr = supperDatabaseHelper.getSupperRecipes();

        SupperAdapter adapter = new SupperAdapter(this, supperArr);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        supperRecView.setLayoutManager(gridLayoutManager);
        supperRecView.setAdapter(adapter);



    }
}