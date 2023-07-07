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

public class Supper extends AppCompatActivity implements Recyclerviewsupperinterface{


    RecipeDatabaseHelper supperDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> supperArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supper);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        SupperAdapter adapter = new SupperAdapter(this, supperArr,this );




        //Breakfast array from database.
        supperArr = supperDatabaseHelper.getSupperRecipes();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



    }

    //Intent for SupperJava class
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Supper.this, Recipe.class);
        startActivity(intent);
    }
}