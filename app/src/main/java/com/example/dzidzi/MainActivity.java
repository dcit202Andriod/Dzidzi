package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.Models.RecipeCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecipeDatabaseHelper homeDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<RecipeCategory> homeArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array to get all categories ie. breakfast, lunch and supper and their ids
        //Test
        homeArr = homeDatabaseHelper.getAllCategories();


    }
}