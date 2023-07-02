package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Lunch extends AppCompatActivity {
    RecipeDatabaseHelper lunchDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> lunchArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Lunch array from database.
        lunchArr = lunchDatabaseHelper.getLunchRecipes();
    }
}