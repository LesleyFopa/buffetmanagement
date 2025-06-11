package com.example.buffetmanagement.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class FoodItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Double calories;
    private String imageUrl;
    @ElementCollection // Permet de stocker une collection de types de base
    private List<String> allergens;


    @OneToMany(mappedBy = "foodItem", cascade = CascadeType.ALL)
    private List<MealItem> mealItems;

    @OneToMany(mappedBy = "foodItem", cascade = CascadeType.ALL)
    private List<BuffetItem> buffetItems;
    // Getters/Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public List<BuffetItem> getBuffetItems() {
        return buffetItems;
    }

    public void setBuffetItems(List<BuffetItem> buffetItems) {
        this.buffetItems = buffetItems;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }
}
