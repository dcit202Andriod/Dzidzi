package com.example.dzidzi.Models;

public class Recipe {
    private int id;
    private String name;
    private int img;
    private String ingredients;
    private String instructions;
    private int fkId;

    public Recipe(int id, String name, int img, String ingredients, String instructions, int fkId) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.fkId = fkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getFkId() {
        return fkId;
    }

    public void setFkId(int fkId) {
        this.fkId = fkId;
    }
}
