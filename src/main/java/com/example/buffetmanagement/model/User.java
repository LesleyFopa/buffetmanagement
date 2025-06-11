package com.example.buffetmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "\"user\"")
public class User {


        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String email;
        private String password;
        private double poids;
        private double taille;

    @ElementCollection
    private List<String> knownAllergies;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<MealPlan> mealPlans;
        // Getters/Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MealPlan> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double calculerIMC(){
        if(taille > 0){
            return poids / (taille * taille);
        }else {
            return 0;
        }
    }

    public List<String> getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(List<String> knownAllergies) {
        this.knownAllergies = knownAllergies;
    }
}
