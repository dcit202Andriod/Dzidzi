package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Adapters.HomeAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.RecipeCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecipeDatabaseHelper homeDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<RecipeCategory> homeArr = new ArrayList<>();
    private RecyclerView itemRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemRecyclerView = findViewById(R.id.recParent);

        //Array to get all categories ie. breakfast, lunch and supper and their ids
        //Test
        //Test2
        //Test3
        homeArr = homeDatabaseHelper.getAllCategories();
        HomeAdapter homeAdapter = new HomeAdapter(this);
        homeAdapter.setHomeArr(homeArr);

        itemRecyclerView.setAdapter(homeAdapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Toast.makeText(this, homeArr.get(0).getId() +" " + homeArr.get(0).getCategory(), Toast.LENGTH_SHORT).show();

    }
}