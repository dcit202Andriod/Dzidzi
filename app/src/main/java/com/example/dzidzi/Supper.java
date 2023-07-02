package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Supper extends AppCompatActivity {
    RecipeDatabaseHelper supperDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> supperArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supper);

        //Supper array from database.
        supperArr = supperDatabaseHelper.getSupperRecipes();
    }
}