package sn.ism.auchan.services;

import java.util.List;

public interface Service <T> {
    // Use Case Categorie ==> Gérer Catégorie
    T create(T itemRequest);
    T update(Long id,T itemRequest);
    T getById(Long id);
    boolean delete(Long id);
    List<T> getAll();
}
