package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

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
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Recipe.this;
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

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

    public void showRecipePopup(View v) {
        PopupMenu popup = new PopupMenu(Recipe.this, v);
        popup.setOnMenuItemClickListener(Recipe.this);
        popup.getMenuInflater().inflate(R.menu.recipe_list_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item1){
            Intent i = new Intent(Recipe.this, Breakfast.class);
            Recipe.this.startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.item2){
            Intent i = new Intent(Recipe.this, Lunch.class);
            Recipe.this.startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.item3){
            Intent i = new Intent(Recipe.this, Supper.class);
            Recipe.this.startActivity(i);
            return true;
        }
        return true;
    }
}