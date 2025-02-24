package sn.ism.auchan.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Récupérer un article par à travers son Id",
            description = "Retourne comme réponse un article ainsi que sa catégorie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'article a été trouvé"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Article non trouvé"
            )

    })
    ResponseEntity<ArticleOneResponse> getOne(@Parameter(description = "L'identifiant d'un article", required = true) @PathVariable Long id);
    @PostMapping("")
    ResponseEntity<ArticleOneResponse> create(@RequestBody() ArticleCreateRequest article);
    @PutMapping("/{id}")
    ResponseEntity<Article> update(@PathVariable Long id, @RequestBody() Article article);
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id);
    @GetMapping("/categorie/{categorieId}")
    ResponseEntity<List<ArticleOneResponse>> getArticlesByCategorie(@PathVariable Long categorieId);
}
