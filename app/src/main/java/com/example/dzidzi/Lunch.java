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
import com.example.dzidzi.Adapters.LunchAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Lunch extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    RecipeDatabaseHelper lunchDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> lunchArr = new ArrayList<>();
    TextView lunchHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        lunchHeader = findViewById(R.id.lunchHeader);

        lunchHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Lunch.this;
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

        lunchArr = lunchDatabaseHelper.getLunchRecipes();

        RecyclerView recyclerView = findViewById(R.id.lunchRecView);

        LunchAdapter adapter = new LunchAdapter(this, lunchArr);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void showLunchPopup(View v) {
        PopupMenu popup = new PopupMenu(Lunch.this, v);
        popup.setOnMenuItemClickListener(Lunch.this);
        popup.getMenuInflater().inflate(R.menu.lunch_list_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item1){
            Intent i = new Intent(Lunch.this, Breakfast.class);
            Lunch.this.startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.item3){
            Intent i = new Intent(Lunch.this, Supper.class);
            Lunch.this.startActivity(i);
            return true;
        }
        return true;
    }
}