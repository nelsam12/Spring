package sn.ism.auchan.web.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.web.dto.response.CategorieAllResponse;

import java.util.List;
import java.util.Map;

@RequestMapping("/categories")
public interface CategorieController {
    @GetMapping("")
    ResponseEntity<List<CategorieAllResponse>> getAll();
    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getOne(@PathVariable Long id);
    @PostMapping("")
    ResponseEntity<Categorie> create(@Valid @RequestBody() Categorie categorie);
    @PutMapping("/{id}")
    ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody() Categorie categorie);
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id);
}
