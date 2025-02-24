package sn.ism.auchan.web.controllers.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.services.ClientService;
//import sn.ism.auchan.services.CommandeService;
import sn.ism.auchan.services.CommandeService;
import sn.ism.auchan.utils.mappers.ClientMapper;
import sn.ism.auchan.web.controllers.ClientController;
import sn.ism.auchan.web.dto.RestResponse;
import sn.ism.auchan.web.dto.request.ClientCreateRequestWithCommandes;
import sn.ism.auchan.web.dto.response.ClientSimpleResponse;
import sn.ism.auchan.web.dto.response.ClientWithCommande;
import sn.ism.auchan.web.dto.response.CommandeSimpleResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name="Clients", description = "Gestion des clients")
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;
    private final CommandeService commandeService;
//    private final CommandeService commandeService;


    @Override
    public ResponseEntity<Map<String, Object>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients = clientService.getAllClients(pageable);
        Page<ClientSimpleResponse> simpleClientResponse = clients.map(ClientMapper.INSTANCE::toDto);
        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        simpleClientResponse.getContent(),
                        simpleClientResponse.getNumber(),
                        simpleClientResponse.getTotalPages(),
                        simpleClientResponse.getTotalElements(),
                        simpleClientResponse.isFirst(),
                        simpleClientResponse.isLast(),
                        "simpleClientResponse"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        var client = clientService.getById(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK,
                ClientMapper.INSTANCE.toDto(client),
                "ClientSimpleResponse"),
                HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> create(Client client) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createWithCommande(ClientCreateRequestWithCommandes client, BindingResult bindingResult) {
        System.out.println("createWithCommande");
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(RestResponse.responseError(bindingResult),HttpStatus.BAD_REQUEST);
        }else {
            var clientSaved = clientService.create(client.toEntity());
            System.out.println(ClientMapper.INSTANCE.toDto(clientSaved));
            return new ResponseEntity<>(
                    RestResponse.response(HttpStatus.OK,
                            ClientMapper.INSTANCE.toDto(clientSaved),
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
        System.out.println(client.getCommandes().getFirst().getId());
        return new ResponseEntity<>(new ClientWithCommande(client), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getClientWithCommandesV2(Long id,
                                                                        int page,
                                                                        int size) {
        var client = clientService.getById(id);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandes = commandeService.getCommandeByClient(id, pageable);
        Page<CommandeSimpleResponse> commandeClientPaginate = commandes.map(CommandeSimpleResponse::new);
//        var clientSimpleResponse = new ClientSimpleResponse(client);
        var clientSimpleResponse = ClientMapper.INSTANCE.toDto(client);
        Map<String, Object> response = new HashMap<>();
        response.put("client", clientSimpleResponse);
        response.put("commandes", RestResponse.responsePaginate(
                HttpStatus.OK,
                commandeClientPaginate.getContent(),
                commandeClientPaginate.getNumber(),
                commandeClientPaginate.getTotalPages(),
                commandeClientPaginate.getTotalElements(),
                commandeClientPaginate.isFirst(),
                commandeClientPaginate.isLast(),
                "commandeClientPaginate"
        ));

        return new ResponseEntity<>(RestResponse.response(
                HttpStatus.OK,
                response,
                "ClientWithPaginateCommandeResponse"
        ), HttpStatus.OK);
    }
}
