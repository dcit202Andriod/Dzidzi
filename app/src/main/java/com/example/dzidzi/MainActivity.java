package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dzidzi.Adapters.HomeAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.RecipeCategory;
import com.example.dzidzi.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecipeDatabaseHelper homeDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<RecipeCategory> homeArr = new ArrayList<>();
    private RecyclerView itemRecyclerView;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        itemRecyclerView = findViewById(R.id.recParent);

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                replaceFragment(new HomeFragment());
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.search) {
                replaceFragment(new SearchFragment());
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                return true;
            }else if(item.getItemId() == R.id.feedback){
                replaceFragment(new FeedbackFragment());
                Toast.makeText(this, "feedback", Toast.LENGTH_SHORT).show();
                return true;
            }
            return true;
        });


        //Array to get all categories ie. breakfast, lunch and supper and their ids
        //Test
        //Test2
        //Test3
        homeArr = homeDatabaseHelper.getAllCategories();
        HomeAdapter homeAdapter = new HomeAdapter(this);
        homeAdapter.setHomeArr(homeArr);

        itemRecyclerView.setAdapter(homeAdapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment,"");
        fragmentTransaction.commit();
    }
}