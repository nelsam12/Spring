package sn.ism.auchan.web.dto.response;

import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientWithCommande {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private List<CommandeSimpleResponse> commandes = new ArrayList<>();

    public ClientWithCommande(Client client) {
        this.id = client.getId();
        this.nomComplet = client.getNomComplet();
        this.telephone = client.getTelephone();
        this.pays = client.getPays();
        this.ville = client.getVille();
        this.commandes = client.getCommandes().stream().map(CommandeSimpleResponse::new).toList();
    }
}
