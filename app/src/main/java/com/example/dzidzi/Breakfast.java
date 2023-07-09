package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.dzidzi.Adapters.BreakfastAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    RecipeDatabaseHelper breakfastDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> breakfastArr = new ArrayList<>();
    TextView breakfastHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        breakfastHeader = findViewById(R.id.breakfastHeader);

        breakfastHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Breakfast.this;
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);


        //Breakfast array from database.
        breakfastArr = breakfastDatabaseHelper.getBreakfastRecipes();
        BreakfastAdapter adapter = new BreakfastAdapter(this, breakfastArr);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



    }

    public void showBreakfastPopup(View v) {
        PopupMenu popup = new PopupMenu(Breakfast.this, v);
        popup.setOnMenuItemClickListener(Breakfast.this);
        popup.getMenuInflater().inflate(R.menu.breakfast_list_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item2){
            Intent i = new Intent(Breakfast.this, Lunch.class);
            Breakfast.this.startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.item3){
            Intent i = new Intent(Breakfast.this, Supper.class);
            Breakfast.this.startActivity(i);
            return true;
        }
        return true;
    }

}