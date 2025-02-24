package sn.ism.auchan.web.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Ceci est le dto Response d'article avec sa catégorie en chaine de caractère")

public class ArticleAllResponse {
    @Schema(description = "Id unique de l'article", example = "15")
    protected Long id;
    protected String name;
    protected String code;
    private Integer qteStock;
    private Float prix;
    private String categorieName;

//    public ArticleAllResponse(Article article) {
//        this.id = article.getId();
//        this.name = article.getName();
//        this.code = article.getCode();
//        this.qteStock = article.getQteStock();
//        this.prix = article.getPrix();
//        this.categorieName = article.getCategorie().getName();
//    }

    // Entity ==> Dto

}
