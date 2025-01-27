package sn.ism.auchan.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.ism.auchan.data.entities.Categorie;
import sn.ism.auchan.services.CategorieService;
import sn.ism.auchan.web.controllers.CategorieController;
import sn.ism.auchan.web.dto.RestResponse;
import sn.ism.auchan.web.dto.response.CategorieAllResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CategorieControllerImpl implements CategorieController {

    private final CategorieService categorieService;

    @Override
    public ResponseEntity<List<CategorieAllResponse>> getAll() {
        var categories = categorieService.getAll();
        var categoriesList = categories
                .stream()
                .map(CategorieAllResponse::new)
                .toList();
        return new ResponseEntity<>(categoriesList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        var categorie = categorieService.getById(id);
        return new ResponseEntity<>(RestResponse.response(
                    HttpStatus.OK,
                    new CategorieAllResponse(categorie),
                    "CategorieAllResponse")
        , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> create( Categorie categorie) {
        var categorieCreated = categorieService.create(categorie);
        return new ResponseEntity<>(categorieCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Categorie> update(Long id,  Categorie categorie) {
        var categorieUpdated = categorieService.update(id, categorie);
        return new ResponseEntity<>(categorieUpdated, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        var categorie = categorieService.delete(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }
}
