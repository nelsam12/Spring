package sn.ism.auchan.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.web.dto.request.ArticleCreateRequest;
import sn.ism.auchan.web.dto.response.ArticleAllResponse;
import sn.ism.auchan.web.dto.response.ArticleOneResponse;

import java.util.List;

@RequestMapping("/articles")
public interface ArticleController {
    @GetMapping("")
    ResponseEntity<List<ArticleAllResponse>> getAll();
    @GetMapping("/{id}")
    ResponseEntity<ArticleOneResponse> getOne(@PathVariable Long id);
    @PostMapping("")
    ResponseEntity<ArticleOneResponse> create(@RequestBody() ArticleCreateRequest article);
    @PutMapping("/{id}")
    ResponseEntity<Article> update(@PathVariable Long id, @RequestBody() Article article);
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id);
    @GetMapping("/categorie/{categorieId}")
    ResponseEntity<List<ArticleOneResponse>> getArticlesByCategorie(@PathVariable Long categorieId);
}
