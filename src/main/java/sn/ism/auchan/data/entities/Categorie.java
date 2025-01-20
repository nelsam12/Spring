package sn.ism.auchan.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Categorie extends AbstractType {
    // Relation
    @OneToMany(mappedBy = "categorie") // categorie_articles (categorie_id, article_id)
    private List<Article> articles;
}
