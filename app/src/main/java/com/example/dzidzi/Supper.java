package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dzidzi.Adapters.BreakfastAdapter;
import com.example.dzidzi.Adapters.SupperAdapter;
import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;

import java.util.ArrayList;

public class Supper extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    RecyclerView supperRecView;
    RecipeDatabaseHelper supperDatabaseHelper = new RecipeDatabaseHelper(this);
    ArrayList<Recipe> supperArr = new ArrayList<>();
    TextView supperHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supper);

        supperHeader = findViewById(R.id.supperHeader);

        supperHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Supper.this;
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

        supperRecView = findViewById(R.id.supperrecview);

        //Supper array from database.
        supperArr = supperDatabaseHelper.getSupperRecipes();

        SupperAdapter adapter = new SupperAdapter(this, supperArr);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        supperRecView.setLayoutManager(gridLayoutManager);
        supperRecView.setAdapter(adapter);



    }

    public void showSupperPopup(View v) {
        PopupMenu popup = new PopupMenu(Supper.this, v);
        popup.setOnMenuItemClickListener(Supper.this);
        popup.getMenuInflater().inflate(R.menu.supper_list_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item1){
            Intent i = new Intent(Supper.this, Breakfast.class);
            Supper.this.startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.item2){
            Intent i = new Intent(Supper.this, Lunch.class);
            Supper.this.startActivity(i);
            return true;
        }
        return true;
    }
}