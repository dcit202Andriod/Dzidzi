package com.example.dzidzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dzidzi.Database.RecipeDatabaseHelper;
import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.Models.RecipeCategory;

public class Splash extends AppCompatActivity {
    RecipeDatabaseHelper recipeDatabaseHelper = new RecipeDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RecipeCategory breakfastCategory = new RecipeCategory(1, getResources().getIdentifier("breakfast", "mipmap", getPackageName() ), "Breakfast");
        RecipeCategory lunchCategory = new RecipeCategory(2, getResources().getIdentifier("lunch", "mipmap", getPackageName() ), "Lunch");
        RecipeCategory dinnerCategory = new RecipeCategory(3, getResources().getIdentifier("supper", "mipmap", getPackageName() ), "Supper");

        recipeDatabaseHelper.fillCategoryTable(breakfastCategory);
        recipeDatabaseHelper.fillCategoryTable(lunchCategory);
        recipeDatabaseHelper.fillCategoryTable(dinnerCategory);

        com.example.dzidzi.Models.Recipe recipe1 = new Recipe(1, getResources().getString(R.string.rice_water_name), getResources().getIdentifier("rice_porridge_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.rice_water_ingredients), getResources().getString(R.string.rice_water_instructions), 1);
        com.example.dzidzi.Models.Recipe recipe2 = new Recipe(2, getResources().getString(R.string.wheat_porridge_name), getResources().getIdentifier("wheat_porridge_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.wheat_porridge_ingredients), getResources().getString(R.string.wheat_porridge_instructions), 1);
        com.example.dzidzi.Models.Recipe recipe3 = new Recipe(3, getResources().getString(R.string.omo_tuo_name), getResources().getIdentifier("omotuo_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.omo_tuo_ingredients), getResources().getString(R.string.omo_tuo_instructions), 2);
        com.example.dzidzi.Models.Recipe recipe4 = new Recipe(4, getResources().getString(R.string.jollof_rice_name), getResources().getIdentifier("jollof_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.jollof_rice_ingredients), getResources().getString(R.string.jollof_rice_instructions), 2);
        com.example.dzidzi.Models.Recipe recipe5 = new Recipe(5, getResources().getString(R.string.waakye_name), getResources().getIdentifier("waakye_supper", "mipmap", getPackageName() ), getResources().getString(R.string.waakye_ingredients), getResources().getString(R.string.waakye_instructions), 3);
        com.example.dzidzi.Models.Recipe recipe6 = new Recipe(6, getResources().getString(R.string.goat_light_soup_name), getResources().getIdentifier("fufu_supper", "mipmap", getPackageName() ), getResources().getString(R.string.goat_light_soup_ingredients), getResources().getString(R.string.goat_light_soup_instructions), 3);
        com.example.dzidzi.Models.Recipe recipe7 = new Recipe(7, getResources().getString(R.string.oat_name), getResources().getIdentifier("oats", "mipmap", getPackageName() ), getResources().getString(R.string.oat_ingredients), getResources().getString(R.string.oat_instructions), 1);
        com.example.dzidzi.Models.Recipe recipe8 = new Recipe(8, getResources().getString(R.string.rice_balls_name), getResources().getIdentifier("riceballs", "mipmap", getPackageName() ), getResources().getString(R.string.rice_balls_ingredients), getResources().getString(R.string.rice_balls_instructions), 2);
        com.example.dzidzi.Models.Recipe recipe9 = new Recipe(9, getResources().getString(R.string.CornPorridgeTitle), getResources().getIdentifier("corn_porridge_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.CornPorridgeIngredients), getResources().getString(R.string.CornPorridgeInstructions), 1);
        com.example.dzidzi.Models.Recipe recipe10 = new Recipe(10, getResources().getString(R.string.AmpesiwithKontomireTitle), getResources().getIdentifier("ampesi_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.AmpesiwithKontomireIngredients), getResources().getString(R.string.AmpesiwithKontomireInstructions), 2);
        com.example.dzidzi.Models.Recipe recipe11 = new Recipe(11, getResources().getString(R.string.TuoZaafiTitle), getResources().getIdentifier("tuozafi_supper", "mipmap", getPackageName() ), getResources().getString(R.string.TuoZaafiIngredients), getResources().getString(R.string.TuoZaafiInstructions), 3);
        com.example.dzidzi.Models.Recipe recipe12 = new Recipe(12, getResources().getString(R.string.OblayoTitle), getResources().getIdentifier("oblayo_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.OblayoIngredients), getResources().getString(R.string.OblayoInstructions), 1);
        com.example.dzidzi.Models.Recipe recipe13 = new Recipe(13, getResources().getString(R.string.KokonteandGroundnutSoupTitle), getResources().getIdentifier("kokonte_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.KokonteandGroundnutSoupIngredients), getResources().getString(R.string.KokonteandGroundnutSoupInstructions), 2);
        com.example.dzidzi.Models.Recipe recipe14 = new Recipe(14, getResources().getString(R.string.BeansandplantainTitle), getResources().getIdentifier("gobe_supper", "mipmap", getPackageName() ), getResources().getString(R.string.BeansandplantainIngredients), getResources().getString(R.string.BeansandplantainInstructions), 3);
        com.example.dzidzi.Models.Recipe recipe15 = new Recipe(15, getResources().getString(R.string.TigernutPuddingTitle), getResources().getIdentifier("pudding_breakfast", "mipmap", getPackageName() ), getResources().getString(R.string.TigernutPuddingIngredients), getResources().getString(R.string.TigernutPuddingInstructions), 1);
        com.example.dzidzi.Models.Recipe recipe16 = new Recipe(16, getResources().getString(R.string.AttiekewithGrilledTilapiaTitle), getResources().getIdentifier("attieke_lunch", "mipmap", getPackageName() ), getResources().getString(R.string.AttiekewithGrilledTilapiaIngredients), getResources().getString(R.string.AttiekewithGrilledTilapiaInstructions), 2);
        com.example.dzidzi.Models.Recipe recipe17 = new Recipe(17, getResources().getString(R.string.EbunuebunuTitle), getResources().getIdentifier("ebunuebunu_supper", "mipmap", getPackageName() ), getResources().getString(R.string.EbunuebunuIngredients), getResources().getString(R.string.EbunuebunuInstructions), 3);

        recipeDatabaseHelper.fillRecipeTable(recipe1);
        recipeDatabaseHelper.fillRecipeTable(recipe2);
        recipeDatabaseHelper.fillRecipeTable(recipe3);
        recipeDatabaseHelper.fillRecipeTable(recipe4);
        recipeDatabaseHelper.fillRecipeTable(recipe5);
        recipeDatabaseHelper.fillRecipeTable(recipe6);
        recipeDatabaseHelper.fillRecipeTable(recipe7);
        recipeDatabaseHelper.fillRecipeTable(recipe8);
        recipeDatabaseHelper.fillRecipeTable(recipe9);
        recipeDatabaseHelper.fillRecipeTable(recipe10);
        recipeDatabaseHelper.fillRecipeTable(recipe11);
        recipeDatabaseHelper.fillRecipeTable(recipe12);
        recipeDatabaseHelper.fillRecipeTable(recipe13);
        recipeDatabaseHelper.fillRecipeTable(recipe14);
        recipeDatabaseHelper.fillRecipeTable(recipe15);
        recipeDatabaseHelper.fillRecipeTable(recipe16);
        recipeDatabaseHelper.fillRecipeTable(recipe17);

        //code for splash screen run time

        final Intent intent = new Intent(Splash.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }}


