package sn.ism.auchan.web.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.web.dto.request.ClientCreateRequestWithCommandes;
import sn.ism.auchan.web.dto.response.ClientSimpleResponse;
import sn.ism.auchan.web.dto.response.ClientWithCommande;
import sn.ism.auchan.web.dto.response.ClientWithPaginateCommandeResponse;

import java.util.Map;

@RequestMapping("/clients")
public interface ClientController {
    //?page=1&size=1
    @GetMapping("")
    ResponseEntity<Page<ClientSimpleResponse>> getAll(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "8")int size
    );
    @GetMapping("/{id}")
    ResponseEntity<ClientSimpleResponse> getOne(@PathVariable Long id);
    @PostMapping("")
    ResponseEntity<Page<ClientSimpleResponse>> create(@Valid @RequestBody() Client client);
    @PostMapping("/commande")
    ResponseEntity<Map<String, Object>> createWithCommande(@Valid @RequestBody() ClientCreateRequestWithCommandes client, BindingResult bindingResult);
    @PutMapping("/{id}")
    ResponseEntity<Page<ClientSimpleResponse>> update(@PathVariable Long id, @RequestBody() Client client);
    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id);
    @GetMapping("/{id}/commandes")
    ResponseEntity<ClientWithCommande> getClientWithCommandes(@PathVariable() Long id);
}
