package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/fooditems")
public class FoodItemController {
    @Autowired private FoodItemRepository repo;
    @GetMapping public List<FoodItem> getAll() { return repo.findAll(); }
    @PostMapping public FoodItem create(@RequestBody FoodItem f) { return repo.save(f); }
    @GetMapping("/{id}") public Optional<FoodItem> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public FoodItem update(@PathVariable Long id, @RequestBody FoodItem f) { f.setId(id); return repo.save(f); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
