package sn.ism.auchan.web.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommandeSimpleResponse {

    private  Long id;
    private LocalDateTime dateCommande;
    private Double montant;
    private String pays;
    private String ville;
    private String rue;

    public CommandeSimpleResponse(Commande commande) {
        this.id = commande.getId();
        this.dateCommande = commande.getDateCommande();
        this.montant = commande.getMontant();
        this.pays = commande.getPays();
        this.ville = commande.getVille();
        this.rue = commande.getRue();
    }
}
