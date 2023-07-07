package com.example.dzidzi.Models;

public class RecipeCategory {
    private int id;
    private int img;

    private String category;

    public RecipeCategory(int id, int img, String category) {
        this.id = id;
        this.img = img;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
