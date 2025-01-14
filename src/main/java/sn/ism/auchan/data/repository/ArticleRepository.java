package sn.ism.auchan.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategorie(Categorie categorie);
}
