package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity {
    RecipeDatabaseHelper breakfastDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> breakfastArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        //Breakfast array from database.
        breakfastArr = breakfastDatabaseHelper.getBreakfastRecipes();

    }
}