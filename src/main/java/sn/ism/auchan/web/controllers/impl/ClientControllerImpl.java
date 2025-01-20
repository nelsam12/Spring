package sn.ism.auchan.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.services.ClientService;
import sn.ism.auchan.web.controllers.ClientController;
import sn.ism.auchan.web.dto.RestResponse;
import sn.ism.auchan.web.dto.request.ClientCreateRequestWithCommandes;
import sn.ism.auchan.web.dto.response.ClientSimpleResponse;
import sn.ism.auchan.web.dto.response.ClientWithCommande;
import sn.ism.auchan.web.dto.response.ClientWithPaginateCommandeResponse;

import java.util.Map;

@RestController
//@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients = clientService.getAllClients(pageable);
        Page<ClientSimpleResponse> simpleClientResponse = clients.map(ClientSimpleResponse::new);
        return new ResponseEntity<>(simpleClientResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> getOne(Long id) {
        var client = clientService.getById(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(new ClientSimpleResponse(client), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> create(Client client) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createWithCommande(ClientCreateRequestWithCommandes client, BindingResult bindingResult) {
        System.out.println("createWithCommande");
        System.out.println("client: " + client);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(RestResponse.responseError(bindingResult),HttpStatus.BAD_REQUEST);
        }else {
            var clientSaved = clientService.create(client.toEntity());
            return new ResponseEntity<>(
                    RestResponse.response(HttpStatus.OK,
                            RestResponse.response(HttpStatus.CREATED, clientSaved, "ClientCreateRequestWithCommandes"),
                            "ClientWithPaginateCommandeResponse"), HttpStatus.OK
            );
        }

    }

    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> update(Long id, Client client) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ClientWithCommande> getClientWithCommandes(@PathVariable() Long id) {

        var client = clientService.getById(id);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        System.out.println(client.getCommandes().get(0).getId());
        return new ResponseEntity<>(new ClientWithCommande(client), HttpStatus.OK);
    }
}
