package com.example.buffetmanagement.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class BuffetEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String location;

    @OneToMany(mappedBy = "buffetEvent", cascade = CascadeType.ALL)
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<BuffetItem> getBuffetItems() {
        return buffetItems;
    }

    public void setBuffetItems(List<BuffetItem> buffetItems) {
        this.buffetItems = buffetItems;
    }
}
