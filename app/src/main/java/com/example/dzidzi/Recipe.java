package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Recipe extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView ingredients;
    TextView instructions;
    TextView recipeName;
    ImageView recipeImage;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ingredients = findViewById(R.id.ingredients);
        instructions = findViewById(R.id.instructions);
        recipeName = findViewById(R.id.recipeName);
        recipeImage = findViewById(R.id.recipeImg);
        logo = findViewById(R.id.logo);

        String ingredientsData = getIntent().getStringExtra("Ingredients");
        String instructionsData = getIntent().getStringExtra("Instructions");
        String recipeNameData = getIntent().getStringExtra("RecipeName");
        int recipeImgData = getIntent().getIntExtra("RecipeImg", 1);

        try {
            ingredients.setText(ingredientsData);
            instructions.setText(instructionsData);
            recipeName.setText(recipeNameData);
            recipeImage.setImageResource(recipeImgData);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(Recipe.this, v);
        popup.setOnMenuItemClickListener(Recipe.this);
        popup.getMenuInflater().inflate(R.menu.list_menu, popup.getMenu());

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item1){
            Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;
    }
}