package sn.ism.auchan.data.mock;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.data.repository.CategorieRepository;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@Component
@RequiredArgsConstructor
public class CategorieMock implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Categorie c = new Categorie();
            c.setCode("C00" + i);
            c.setName("Categorie_" + i);
            categories.add(c);
        }
        // Sauvegarder toutes les catégories
        categorieRepository.saveAllAndFlush(categories);
    }
}
