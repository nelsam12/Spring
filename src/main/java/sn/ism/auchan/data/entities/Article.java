package sn.ism.auchan.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article extends AbstractType {
    private Integer qteStock;
    private Float prix;

    // Relation
    @ManyToOne // categorie_id
    private Categorie categorie;

//    @OneToMany
//    private List<Detail> details;

}
