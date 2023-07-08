package com.example.dzidzi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzidzi.Adapters.HomeAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.RecipeCategory;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    Context context;

    public HomeFragment(Context context) {
        this.context = context;
    }

    RecipeDatabaseHelper homeDatabaseHelper;
    ArrayList<RecipeCategory> homeArr = new ArrayList<>();
    private RecyclerView itemRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeDatabaseHelper = new RecipeDatabaseHelper(context);
        homeArr = homeDatabaseHelper.getAllCategories();
        itemRecyclerView = view.findViewById(R.id.categoryRecView);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        HomeAdapter homeAdapter = new HomeAdapter(context);
        homeAdapter.setHomeArr(homeArr);
        itemRecyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }
}