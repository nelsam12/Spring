package sn.ism.auchan.web.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ArticleOneResponse {

    protected Long id;
    protected String name;
    protected String code;
    private Integer qteStock;
    private Float prix;
    private CategorieAllResponse categorie;

//    public ArticleOneResponse(Article article) {
//        this.id = article.getId();
//        this.name = article.getName();
//        this.code = article.getCode();
//        this.qteStock = article.getQteStock();
//        this.prix = article.getPrix();
//        this.categorie = CategorieMapper.INSTANCE.toDto(article.getCategorie());
//    }

    // Entity ==> Dto

}
