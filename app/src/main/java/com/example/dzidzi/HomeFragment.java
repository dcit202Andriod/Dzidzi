package com.example.dzidzi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Adapters.HomeAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.RecipeCategory;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecipeDatabaseHelper homeDatabaseHelper = new RecipeDatabaseHelper(getContext());
    ArrayList<RecipeCategory> homeArr = new ArrayList<>();
    private RecyclerView itemRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        itemRecyclerView = view.findViewById(R.id.recCategoryParent);

        homeArr = homeDatabaseHelper.getAllCategories();
        HomeAdapter homeAdapter = new HomeAdapter(getContext());
        homeAdapter.setHomeArr(homeArr);

        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        itemRecyclerView.setAdapter(homeAdapter);
        return view;
    }
}