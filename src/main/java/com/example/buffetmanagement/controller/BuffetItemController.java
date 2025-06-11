package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/buffetitems")
public class BuffetItemController {
    @Autowired private BuffetItemRepository repo;
    @GetMapping public List<BuffetItem> getAll() { return repo.findAll(); }
    @PostMapping public BuffetItem create(@RequestBody BuffetItem i) { return repo.save(i); }
    @GetMapping("/{id}") public Optional<BuffetItem> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public BuffetItem update(@PathVariable Long id, @RequestBody BuffetItem i) { i.setId(id); return repo.save(i); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
