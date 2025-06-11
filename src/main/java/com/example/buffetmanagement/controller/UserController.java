package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors; // Pour utiliser Collectors

@RestController @RequestMapping("/api/users")
public class UserController {
    @Autowired private UserRepository repo;
    @Autowired private FoodItemRepository foodItemRepo;


    @GetMapping public List<User> getAll() { return repo.findAll(); }
    @PostMapping public User create(@RequestBody User u) { return repo.save(u); }
    @GetMapping("/{id}") public Optional<User> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User u) { u.setId(id); return repo.save(u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }

    @GetMapping("/{id}/imc")
    public ResponseEntity<Double> calculerIMC(@PathVariable Long id) {
        Optional<User> user = repo.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            double imc = user1.calculerIMC();
            return ResponseEntity.ok(imc);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/allergy-probability")
    public ResponseEntity<Double> getAllergyProbability(@PathVariable Long id) {
        Optional<User> userOptional = repo.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Utilisateur non trouvé
        }

        User user = userOptional.get();
        List<String> userAllergies = user.getKnownAllergies();

        if (userAllergies == null || userAllergies.isEmpty()) {
            return ResponseEntity.ok(0.0); // Pas d'allergies connues, donc probabilité 0
        }

        List<FoodItem> allFoodItems = foodItemRepo.findAll();
        if (allFoodItems.isEmpty()) {
            return ResponseEntity.ok(0.0); // Pas d'éléments alimentaires à vérifier
        }

        Set<String> userAllergiesSet = new HashSet<>(userAllergies.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList()));

        long foodItemsWithAllergenCount = allFoodItems.stream()
                .filter(foodItem -> foodItem.getAllergens() != null)
                .filter(foodItem -> foodItem.getAllergens().stream()
                        .map(String::toLowerCase)
                        .anyMatch(userAllergiesSet::contains))
                .count();

        double probability = (double) foodItemsWithAllergenCount / allFoodItems.size();
        return ResponseEntity.ok(probability);
    }
}