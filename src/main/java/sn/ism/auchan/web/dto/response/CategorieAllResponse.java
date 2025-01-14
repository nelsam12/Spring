package sn.ism.auchan.web.dto.response;

import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Categorie;

@Getter
@Setter
public class CategorieAllResponse {
    protected Long id;
    protected String name;
    protected String code;

    public CategorieAllResponse(Categorie categorie) {
        this.id = categorie.getId();
        this.name = categorie.getName();
        this.code = categorie.getCode();
    }
}
