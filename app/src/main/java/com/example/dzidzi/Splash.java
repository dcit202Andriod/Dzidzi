package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.Models.RecipeCategory;

public class Splash extends AppCompatActivity {
    RecipeDatabaseHelper recipeDatabaseHelper = new RecipeDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RecipeCategory breakfastCategory = new RecipeCategory(getResources().getIdentifier("breakfast", "mipmap", getPackageName() ), "Breakfast");
        RecipeCategory lunchCategory = new RecipeCategory(getResources().getIdentifier("lunch", "mipmap", getPackageName() ), "Lunch");
        RecipeCategory dinnerCategory = new RecipeCategory(getResources().getIdentifier("supper", "mipmap", getPackageName() ), "Supper");

        recipeDatabaseHelper.fillCategoryTable(breakfastCategory);
        recipeDatabaseHelper.fillCategoryTable(lunchCategory);
        recipeDatabaseHelper.fillCategoryTable(dinnerCategory);

        com.example.dzidzi.Models.Recipe recipe1 = new com.example.dzidzi.Models.Recipe(1, getResources().getString(R.string.rice_water_name), getResources().getIdentifier("rice_porridge_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.rice_water_ingredients), getResources().getString(R.string.rice_water_instructions), 1);
        com.example.dzidzi.Models.Recipe recipe2 = new com.example.dzidzi.Models.Recipe(2, getResources().getString(R.string.wheat_porridge_name), getResources().getIdentifier("wheat_porridge_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.wheat_porridge_ingredients), getResources().getString(R.string.wheat_porridge_instructions), 1);
        com.example.dzidzi.Models.Recipe recipe3 = new com.example.dzidzi.Models.Recipe(3, getResources().getString(R.string.omo_tuo_name), getResources().getIdentifier("omotuo_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.omo_tuo_ingredients), getResources().getString(R.string.omo_tuo_instructions), 2);
        com.example.dzidzi.Models.Recipe recipe4 = new com.example.dzidzi.Models.Recipe(4, getResources().getString(R.string.jollof_rice_name), getResources().getIdentifier("jollof_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.jollof_rice_ingredients), getResources().getString(R.string.jollof_rice_instructions), 2);
        com.example.dzidzi.Models.Recipe recipe5 = new com.example.dzidzi.Models.Recipe(5, getResources().getString(R.string.waakye_name), getResources().getIdentifier("waakye_supper", "mipmap", getPackageName() ), getResources().getString(R.string.waakye_ingredients), getResources().getString(R.string.waakye_instructions), 3);
        com.example.dzidzi.Models.Recipe recipe6 = new Recipe(6, getResources().getString(R.string.goat_light_soup_name), getResources().getIdentifier("fufu_supper", "mipmap", getPackageName() ), getResources().getString(R.string.goat_light_soup_ingredients), getResources().getString(R.string.goat_light_soup_instructions), 3);

        recipeDatabaseHelper.fillRecipeTable(recipe1);
        recipeDatabaseHelper.fillRecipeTable(recipe2);
        recipeDatabaseHelper.fillRecipeTable(recipe3);
        recipeDatabaseHelper.fillRecipeTable(recipe4);
        recipeDatabaseHelper.fillRecipeTable(recipe5);
        recipeDatabaseHelper.fillRecipeTable(recipe6);
    }
}