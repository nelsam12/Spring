package sn.ism.auchan.services;

import sn.ism.auchan.data.entities.Article;

import java.util.List;

public interface ArticleService {
    // Use Case Categorie ==> Gérer Catégorie
    Article create(Article articleRequest);
    Article update(Long id,Article articleRequest);
    Article getById(Long id);
    boolean delete(Long id);
    List<Article> getAll();
    List<Article> findAllByCategorie(Long categorieId);
}
