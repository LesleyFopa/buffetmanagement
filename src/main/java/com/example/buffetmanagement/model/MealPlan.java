package com.example.buffetmanagement.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class MealPlan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL)
    private List<MealItem> mealItems;
    // Getters/Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }
}
