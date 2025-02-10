package sn.ism.auchan.devoir.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.auchan.devoir.dto.request.ClientRequest;
import sn.ism.auchan.devoir.dto.response.ClientResponse;
import sn.ism.auchan.devoir.dto.response.ClientResponseWithCommandes;

@RequestMapping("api/v1/devoir")
public interface DevoirController {
    @PostMapping("/clients/commandes")
    ResponseEntity<ClientResponse> createClient(@RequestBody()ClientRequest clientRequest);

    @GetMapping("clients/{id}/commandes")
    ResponseEntity<ClientResponseWithCommandes> getCommandes(
                                            @PathVariable("id") Long clientId,
                                            @RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "5") int size);
}
