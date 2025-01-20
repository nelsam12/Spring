package sn.ism.auchan.web.dto.request;


import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;


@Getter
@Setter
public class ArticleCreateRequest {
    private String name;
    private String code;
    private Integer qteStock;
    private Float prix;
    private Long categorieId;

    // Dto ==> Entity

    public Article toEntity(){
        Article article = new Article();
        Categorie categorie = new Categorie();
        article.setName(name);
        article.setCode(code);
        article.setQteStock(qteStock);
        article.setPrix(prix);
        categorie.setId(categorieId);
        article.setCategorie(categorie);
        return article;
    }

}
