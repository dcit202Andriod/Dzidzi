package com.example.dzidzi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dzidzi.Adapters.SearchAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    Context context;
    RecipeDatabaseHelper recipeDatabaseHelper;
    private RecyclerView recyclerView;
    private SearchView searchView;
    TextView foodLogo;
    SearchAdapter searchAdapter;
    ArrayList<Recipe> allRecipesArr;
    public SearchFragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodLogo = view.findViewById(R.id.food_logo);
        recipeDatabaseHelper = new RecipeDatabaseHelper(context);
        allRecipesArr = recipeDatabaseHelper.getAllRecipes();
        recyclerView = view.findViewById(R.id.SearchCategoryRecView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        searchAdapter = new SearchAdapter(context);
        searchAdapter.setAllRecipesArr(allRecipesArr);
        recyclerView.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();
        searchView = view.findViewById(R.id.searchSection);

        foodLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });


    }

    private void filter(String newText) {
        ArrayList<Recipe> filteredSearch = new ArrayList<>();
        for (Recipe singleRecipe: allRecipesArr){
            if(singleRecipe.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredSearch.add(singleRecipe);
            }
        }
        searchAdapter.filterList(filteredSearch);
    }
}