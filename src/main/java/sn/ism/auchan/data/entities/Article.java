package sn.ism.auchan.data.entities;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article extends AbstractType {
    private Integer qteStock;
    private Float prix;
    // Relation
    @ManyToOne // categorie_id
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<Detail> details;

//    public Integer getQteStock() {
//        return qteStock;
//    }
//
//    public void setQteStock(Integer qteStock) {
//        this.qteStock = qteStock;
//    }
//
//    public Float getPrix() {
//        return prix;
//    }
//
//    public void setPrix(Float prix) {
//        this.prix = prix;
//    }
//
//    public Categorie getCategorie() {
//        return categorie;
//    }
//
//    public void setCategorie(Categorie categorie) {
//        this.categorie = categorie;
//    }
//
//    public List<Detail> getDetails() {
//        return details;
//    }
//
//    public void setDetails(List<Detail> details) {
//        this.details = details;
//    }

}
