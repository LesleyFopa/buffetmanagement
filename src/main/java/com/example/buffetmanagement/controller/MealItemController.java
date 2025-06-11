package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/mealitems")
public class MealItemController {
    @Autowired private MealItemRepository repo;
    @GetMapping public List<MealItem> getAll() { return repo.findAll(); }
    @PostMapping public MealItem create(@RequestBody MealItem i) { return repo.save(i); }
    @GetMapping("/{id}") public Optional<MealItem> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public MealItem update(@PathVariable Long id, @RequestBody MealItem i) { i.setId(id); return repo.save(i); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
