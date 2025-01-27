package sn.ism.auchan.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.data.repository.CategorieRepository;
import sn.ism.auchan.services.CategorieService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {
    // Couplage Faible
    private final CategorieRepository categorieRepository;


//    public CategorieServiceImpl(CategorieRepository categorieRepository) {
//        this.categorieRepository = categorieRepository;
//    }

    @Override
    public Categorie create(Categorie categorieRequest) {
        return categorieRepository.save(categorieRequest);
    }

    @Override
    public Categorie update(Long id, Categorie categorieRequest) {
        Categorie cat = categorieRepository.findById(id).orElse(null);
        if (cat == null) {
            return null;
        }
        cat.setName(categorieRequest.getName());
        cat.setCode(categorieRequest.getCode());
        return categorieRepository.save(cat);
    }

    @Override
    public Categorie getById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        categorieRepository.findById(id).ifPresent(categorieRepository::delete);
        return false;
    }

    @Override
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }
}
