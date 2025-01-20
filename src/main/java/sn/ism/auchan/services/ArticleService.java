package sn.ism.auchan.services;

import sn.ism.auchan.data.entities.Article;

import java.util.List;

public interface ArticleService extends Service<Article> {
    // Use Case Categorie ==> Gérer Catégorie
    List<Article> findAllByCategorie(Long categorieId);
}
