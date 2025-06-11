package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/mealplans")
public class MealPlanController {
    @Autowired private MealPlanRepository repo;
    @GetMapping public List<MealPlan> getAll() { return repo.findAll(); }
    @PostMapping public MealPlan create(@RequestBody MealPlan p) { return repo.save(p); }
    @GetMapping("/{id}") public Optional<MealPlan> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public MealPlan update(@PathVariable Long id, @RequestBody MealPlan p) { p.setId(id); return repo.save(p); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
