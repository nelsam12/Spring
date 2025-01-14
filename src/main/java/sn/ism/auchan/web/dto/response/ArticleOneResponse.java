package sn.ism.auchan.web.dto.response;


import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;

@Getter
@Setter

public class ArticleOneResponse {

    protected Long id;
    protected String name;
    protected String code;
    private Integer qteStock;
    private Float prix;
    private CategorieAllResponse categorie;

    public ArticleOneResponse(Article article) {
        this.id = article.getId();
        this.name = article.getName();
        this.code = article.getCode();
        this.qteStock = article.getQteStock();
        this.prix = article.getPrix();
        this.categorie = new CategorieAllResponse(article.getCategorie());
    }

    // Entity ==> Dto

}
