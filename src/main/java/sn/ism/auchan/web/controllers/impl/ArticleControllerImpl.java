package sn.ism.auchan.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.services.ArticleService;
import sn.ism.auchan.services.CategorieService;
import sn.ism.auchan.utils.mappers.ArticleMapper;
import sn.ism.auchan.web.controllers.ArticleController;
import sn.ism.auchan.web.dto.request.ArticleCreateRequest;
import sn.ism.auchan.web.dto.response.ArticleAllResponse;
import sn.ism.auchan.web.dto.response.ArticleOneResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="Articles", description = "Gestion des articles")
public class ArticleControllerImpl implements ArticleController {

    private final ArticleService articleService;
    private final CategorieService categorieService;

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAll() {
        var articles = articleService.getAll();
        // Mappage
        var articlesList = articles
                .stream()
                .map(ArticleMapper.INSTANCE::toDto)
                .toList();
        return new ResponseEntity<>(articlesList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> getOne(Long id) {
        var article = articleService.getById(id);
        if (article == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ArticleMapper.INSTANCE.toDto2(article), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> create( ArticleCreateRequest article) {
        var articleCreated = articleService.create(article.toEntity());
        var categorie = categorieService.getById(articleCreated.getCategorie().getId());
        articleCreated.setCategorie(categorie);
        return new ResponseEntity<>(ArticleMapper.INSTANCE.toDto2(articleCreated), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Article> update(Long id,  Article article) {
        var articleUpdated = articleService.update(id, article);
        var categorie = categorieService.getById(articleUpdated.getCategorie().getId());
        articleUpdated.setCategorie(categorie);
        return new ResponseEntity<>(articleUpdated, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        var article = articleService.delete(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ArticleOneResponse>> getArticlesByCategorie(Long categorieId) {
        var articles = articleService.findAllByCategorie(categorieId);
        var articlesList = articles
                .stream()
                .map(ArticleMapper.INSTANCE::toDto2)
                .toList();
        return new ResponseEntity<>(articlesList,HttpStatus.OK);
    }
}
