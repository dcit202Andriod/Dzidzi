package com.example.dzidzi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dzidzi.Models.Recipe;
import com.example.dzidzi.Models.RecipeCategory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_CATEGORY = "category";
    public static final String RECIPE_CATEGORY_TABLE = "recipe_" + COLUMN_CATEGORY + "_table";
    public static final String COLUMN_CATEGORY_IMG = COLUMN_CATEGORY + "_image";
    public static final String COLUMN_CATEGORY_ID = COLUMN_CATEGORY + "_id";
    public static final String RECIPE_TABLE = "recipe_table";
    public static final String COLUMN_RECIPE_ID = "recipe_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_INGREDIENTS = "ingredients";
    public static final String COLUMN_INSTRUCTIONS = "instructions";
    public static final String COLUMN_CATEGORY_REF_ID = RECIPE_CATEGORY_TABLE;

    public RecipeDatabaseHelper(@Nullable Context context) {
        super(context, "recipe.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryStringCategory = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s INTEGER NOT NULL, %s TEXT NOT NULL)", RECIPE_CATEGORY_TABLE, COLUMN_CATEGORY_ID, COLUMN_CATEGORY_IMG, COLUMN_CATEGORY);
        String queryStringRecipe = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY (%s) REFERENCES %s(%s))", RECIPE_TABLE, COLUMN_RECIPE_ID, COLUMN_NAME, COLUMN_IMG, COLUMN_INGREDIENTS, COLUMN_INSTRUCTIONS, COLUMN_CATEGORY_REF_ID, COLUMN_CATEGORY_REF_ID, RECIPE_CATEGORY_TABLE, COLUMN_CATEGORY_ID);
        db.execSQL(queryStringCategory);
        db.execSQL(queryStringRecipe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_CATEGORY_TABLE);
        onCreate(db);
    }

    SQLiteDatabase db;

    public boolean fillCategoryTable(RecipeCategory recipeCategory){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CATEGORY_ID, recipeCategory.getId());
        cv.put(COLUMN_CATEGORY_IMG, recipeCategory.getImg());
        cv.put(COLUMN_CATEGORY, recipeCategory.getCategory());

        long result = db.insert(RECIPE_CATEGORY_TABLE, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<RecipeCategory> getAllCategories() {
        db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + RECIPE_CATEGORY_TABLE;
        ArrayList<RecipeCategory> categoryArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int categoryId = cursor.getInt(0);
                int categoryImg = cursor.getInt(1);
                String categoryName = cursor.getString(2);

                RecipeCategory recipeCategory = new RecipeCategory(categoryId, categoryImg, categoryName);
                categoryArrayList.add(recipeCategory);
            } while (cursor.moveToNext());
        } else {
            //Do nothing
        }

        cursor.close();
        db.close();
        return categoryArrayList;
    }

    public boolean fillRecipeTable(Recipe recipe){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RECIPE_ID, recipe.getId());
        cv.put(COLUMN_NAME, recipe.getName());
        cv.put(COLUMN_IMG, recipe.getImg());
        cv.put(COLUMN_INGREDIENTS, recipe.getIngredients());
        cv.put(COLUMN_INSTRUCTIONS, recipe.getInstructions());
        cv.put(COLUMN_CATEGORY_REF_ID, recipe.getFkId());

        long result = db.insert(RECIPE_TABLE, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Recipe> getAllRecipes(){
        db = this.getReadableDatabase();
        ArrayList<Recipe> recipeArray = new ArrayList<>();
        String queryString = "SELECT * FROM " + RECIPE_TABLE;
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int img = cursor.getInt(2);
                String ingredients = cursor.getString(3);
                String instructions = cursor.getString(4);
                int fk = cursor.getInt(5);

                Recipe recipe = new Recipe(id, name, img, ingredients, instructions, fk);
                recipeArray.add(recipe);
            } while (cursor.moveToNext());
        } else {
            //do nothing
        }
        cursor.close();
        db.close();
        return recipeArray;
    }
    public ArrayList<Recipe> getBreakfastRecipes(){
        db = this.getReadableDatabase();
        ArrayList<Recipe> recipeArray = new ArrayList<>();
        String queryString = "SELECT * FROM " + RECIPE_TABLE + " WHERE " + COLUMN_CATEGORY_REF_ID + " = " + 1;
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int img = cursor.getInt(2);
                String ingredients = cursor.getString(3);
                String instructions = cursor.getString(4);
                int fk = cursor.getInt(5);

                Recipe recipe = new Recipe(id, name, img, ingredients, instructions, fk);
                recipeArray.add(recipe);
            } while (cursor.moveToNext());
        } else {
            //do nothing
        }
        cursor.close();
        db.close();
        return recipeArray;
    }

    public ArrayList<Recipe> getLunchRecipes(){
        db = this.getReadableDatabase();
        ArrayList<Recipe> recipeArray = new ArrayList<>();
        String queryString = "SELECT * FROM " + RECIPE_TABLE + " WHERE " + COLUMN_CATEGORY_REF_ID + " = " + 2;
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int img = cursor.getInt(2);
                String ingredients = cursor.getString(3);
                String instructions = cursor.getString(4);
                int fk = cursor.getInt(5);

                Recipe recipe = new Recipe(id, name, img, ingredients, instructions, fk);
                recipeArray.add(recipe);
            } while (cursor.moveToNext());
        } else {
            //do nothing
        }
        cursor.close();
        db.close();
        return recipeArray;
    }

    public ArrayList<Recipe> getSupperRecipes(){
        db = this.getReadableDatabase();
        ArrayList<Recipe> recipeArray = new ArrayList<>();
        String queryString = "SELECT * FROM " + RECIPE_TABLE + " WHERE " + COLUMN_CATEGORY_REF_ID + " = " + 3;
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int img = cursor.getInt(2);
                String ingredients = cursor.getString(3);
                String instructions = cursor.getString(4);
                int fk = cursor.getInt(5);

                Recipe recipe = new Recipe(id, name, img, ingredients, instructions, fk);
                recipeArray.add(recipe);
            } while (cursor.moveToNext());
        } else {
            //do nothing
        }
        cursor.close();
        db.close();
        return recipeArray;
    }
}
