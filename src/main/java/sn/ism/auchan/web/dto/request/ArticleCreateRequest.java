package sn.ism.auchan.web.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Article;
import sn.ism.auchan.data.entities.Categorie;


@Getter
@Setter
@Schema(description = "Ceci est le dto Request d'article")
public class ArticleCreateRequest {
    private String name;
    private String code;
    private Integer qteStock;
    private Float prix;
    @Schema(description = "L'id de la catégorie")
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
