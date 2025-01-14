package sn.ism.auchan.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.web.dto.response.CategorieAllResponse;

import java.util.List;
@RequestMapping("/categorie")
public interface CategorieController {
    @GetMapping("/list")
    ResponseEntity<List<CategorieAllResponse>> getAll();
    @GetMapping("/one/{id}")
    ResponseEntity<CategorieAllResponse> getOne(@PathVariable Long id);
    @PostMapping("/create")
    ResponseEntity<Categorie> create(@RequestBody() Categorie categorie);
    @PutMapping("/update/{id}")
    ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody() Categorie categorie);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id);
}
