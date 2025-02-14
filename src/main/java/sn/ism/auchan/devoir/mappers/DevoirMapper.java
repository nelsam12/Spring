package sn.ism.auchan.devoir.mappers;

//Convertir entité en DTO et vice-versa

import org.springframework.data.domain.Page;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.devoir.dto.request.ClientRequest;
import sn.ism.auchan.devoir.dto.request.CommandeRequest;
import sn.ism.auchan.devoir.dto.response.ClientResponse;
import sn.ism.auchan.devoir.dto.response.ClientResponseWithCommandes;
import sn.ism.auchan.devoir.dto.response.ClientSimpleResponse;
import sn.ism.auchan.devoir.dto.response.CommandeResponse;

public class DevoirMapper {

    public static CommandeResponse toCommandeResponse(Commande commande) {

        return CommandeResponse
                .builder()
                .date(commande.getDateCommande())
                .montant(commande.getMontant())
                .build();
    }

    // DTO to entity
    public static Client toClientRequestEntity(ClientRequest clientRequest) {
        Client client = new Client();
        client.setRue(clientRequest.getRue());
        client.setVille(clientRequest.getVille());
        client.setPays(clientRequest.getPays());
        client.setNomComplet(clientRequest.getNomComplet());
        client.setTelephone(clientRequest.getTelephone());
        // Commandes du client
        client.setCommandes(clientRequest.getCommandes().stream()
                .map(cmd ->DevoirMapper.toCommandeEntity(cmd, client)).toList());
        return client;
    }

    public static Commande toCommandeEntity(CommandeRequest commandeRequest, Client client) {
        Commande commande = new Commande();
        commande.setDateCommande(commandeRequest.getDate());
        commande.setMontant(commandeRequest.getMontant());
        commande.setClient(client);
        return commande;
    }

    public static ClientResponse toClientResponse(Client client) {
        return ClientResponse
                        .builder()
                .id(client.getId())
                        .rue(client.getRue())
                        .ville(client.getVille())
                        .pays(client.getPays())
                        .nomComplet(client.getNomComplet())
                        .telephone(client.getTelephone())
                        .commandes(client.getCommandes().stream().map(DevoirMapper::toCommandeResponse)
                                .toList())
                        .build();
    }

    public static ClientSimpleResponse toClientSimpleResponse(Client client) {
        return ClientSimpleResponse
                .builder()
                .nomComplet(client.getNomComplet())
                .telephone(client.getTelephone())
                .build();
    }

    public static ClientResponseWithCommandes toClientResponseWithCommandes(Page<Commande> commandes, Client client) {
        return ClientResponseWithCommandes
                .builder()
                .client(DevoirMapper.toClientSimpleResponse(client))
                .commandes(commandes.getContent().stream().map(DevoirMapper::toCommandeResponse)
                        .toList())
                .currentPage(commandes.getNumber())
                .totalPage(commandes.getTotalPages())
                .totalItems(commandes.getNumberOfElements())
//
                .build();
    }

}
