package sn.ism.auchan.services;

import sn.ism.auchan.data.entities.Categorie;

import java.util.List;

public interface CategorieService {
    // Use Case Categorie ==> Gérer Catégorie
    Categorie create(Categorie categorieRequest);
    Categorie update(Long id,Categorie categorieRequest);
    Categorie getById(Long id);
    boolean delete(Long id);
    List<Categorie> getAll();
}
