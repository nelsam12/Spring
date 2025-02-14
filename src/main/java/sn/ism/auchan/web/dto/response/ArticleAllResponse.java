package sn.ism.auchan.web.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleAllResponse {
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
