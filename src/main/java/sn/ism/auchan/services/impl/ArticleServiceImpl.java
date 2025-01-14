package sn.ism.auchan.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.data.repository.ArticleRepository;
import sn.ism.auchan.data.repository.CategorieRepository;
import sn.ism.auchan.services.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
    // Couplage Faible
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public Article create(Article articleRequest) {
        System.out.println("Create Article");
        return articleRepository.save(articleRequest);
    }

    @Override
    public Article update(Long id, Article articleRequest) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            return null;
        }
        article.setName(articleRequest.getName());
        article.setCode(articleRequest.getCode());
        article.setPrix(articleRequest.getPrix());
        article.setQteStock(articleRequest.getQteStock());

        return articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        articleRepository.findById(id).ifPresent(articleRepository::delete);
        return false;
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findAllByCategorie(Long categorieId) {
        Categorie categorie = categorieRepository.findById(categorieId).orElse(null);
        if (categorie != null) {
            return articleRepository.findAllByCategorie(categorie);
        }
        return List.of();
    }
}
