package com.example.buffetmanagement.controller;
import com.example.buffetmanagement.model.*;
import com.example.buffetmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/buffetevents")
public class BuffetEventController {
    @Autowired private BuffetEventRepository repo;
    @GetMapping public List<BuffetEvent> getAll() { return repo.findAll(); }
    @PostMapping public BuffetEvent create(@RequestBody BuffetEvent e) { return repo.save(e); }
    @GetMapping("/{id}") public Optional<BuffetEvent> get(@PathVariable Long id) { return repo.findById(id); }
    @PutMapping("/{id}") public BuffetEvent update(@PathVariable Long id, @RequestBody BuffetEvent e) { e.setId(id); return repo.save(e); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
