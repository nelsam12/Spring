package sn.ism.auchan.devoir.controller.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.devoir.controller.DevoirController;
import sn.ism.auchan.devoir.dto.request.ClientRequest;
import sn.ism.auchan.devoir.dto.response.ClientResponse;
import sn.ism.auchan.devoir.dto.response.ClientResponseWithCommandes;
import sn.ism.auchan.devoir.mappers.DevoirMapper;
import sn.ism.auchan.devoir.services.DevoirService;

@RestController
@RequiredArgsConstructor
public class DevoirControllerImpl implements DevoirController {
    private final DevoirService devoirService;
    @Override
    public ResponseEntity<ClientResponse> createClient(ClientRequest clientRequest) {
        var client = devoirService.createClient(DevoirMapper.toClientRequestEntity(clientRequest));
        return new ResponseEntity<>(DevoirMapper.toClientResponse(client), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientResponseWithCommandes> getCommandes(Long clientId, int page, int size) {
        Client client = devoirService.findClientById(clientId);
        Page<Commande> commandes = devoirService.findAllCommandesByClientId(PageRequest.of(page, size), clientId);
        var commandeResponse = DevoirMapper.toClientResponseWithCommandes(commandes, client);
        return ResponseEntity.ok(commandeResponse);
    }

}
