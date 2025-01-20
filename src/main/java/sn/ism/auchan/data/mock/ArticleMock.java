package sn.ism.auchan.data.mock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.data.repository.ArticleRepository;
import sn.ism.auchan.data.repository.CategorieRepository;

import java.util.ArrayList;
import java.util.List;

@Order(2)
@Component
@RequiredArgsConstructor
public class ArticleMock implements CommandLineRunner {
    public ArticleMock(CategorieRepository categorieRepository, ArticleRepository articleRepository) {
        this.categorieRepository = categorieRepository;
        this.articleRepository = articleRepository;
    }

    private final CategorieRepository categorieRepository;
    private final ArticleRepository articleRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = categorieRepository.findAll();

        List<Article> articles = new ArrayList<>();

        for (Categorie categorie : categories) {
            for (int i = 1; i <= 10; i++) {
                Article article = new Article();
                article.setCode(categorie.getName() + "_art_"  + "_A00" + i);
                article.setName(categorie.getName() +"_article_" + i);
                article.setPrix(100.0F * i);
                article.setQteStock(10*i);
                article.setCategorie(categorie);
                articles.add(article);
            }
        }
        // Sauvegarder toutes les catégories
        articleRepository.saveAllAndFlush(articles);
    }
}
