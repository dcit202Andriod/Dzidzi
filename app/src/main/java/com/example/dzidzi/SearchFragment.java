package com.example.dzidzi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    Context context;
    RecipeDatabaseHelper recipeDatabaseHelper;

    public SearchFragment(Context context) {
        this.context = context;
    }
    ArrayList<Recipe> allRecipesArr = new ArrayList<>();

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

        recipeDatabaseHelper = new RecipeDatabaseHelper(context);
        allRecipesArr = recipeDatabaseHelper.getAllRecipes();
    }
}