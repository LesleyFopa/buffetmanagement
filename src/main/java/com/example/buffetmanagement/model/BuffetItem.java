package com.example.buffetmanagement.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class BuffetItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToOne @JoinColumn(name = "buffet_event_id")
    private BuffetEvent buffetEvent;

    @ManyToOne @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;
    // Getters/Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BuffetEvent getBuffetEvent() {
        return buffetEvent;
    }

    public void setBuffetEvent(BuffetEvent buffetEvent) {
        this.buffetEvent = buffetEvent;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
