package sn.ism.auchan.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.auchan.data.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
