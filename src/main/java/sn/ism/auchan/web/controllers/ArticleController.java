package sn.ism.auchan.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.web.dto.request.ArticleCreateRequest;
import sn.ism.auchan.web.dto.response.ArticleAllResponse;
import sn.ism.auchan.web.dto.response.ArticleOneResponse;

import java.util.List;

@RequestMapping("/article")
public interface ArticleController {
    @GetMapping("/list")
    ResponseEntity<List<ArticleAllResponse>> getAll();
    @GetMapping("/one/{id}")
    ResponseEntity<ArticleOneResponse> getOne(@PathVariable Long id);
    @PostMapping("/create")
    ResponseEntity<ArticleOneResponse> create(@RequestBody() ArticleCreateRequest article);
    @PutMapping("/update/{id}")
    ResponseEntity<Article> update(@PathVariable Long id, @RequestBody() Article article);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id);
    @GetMapping("/{categorieId}/articles")
    ResponseEntity<List<ArticleOneResponse>> getArticlesByCategorie(@PathVariable Long categorieId);
}
