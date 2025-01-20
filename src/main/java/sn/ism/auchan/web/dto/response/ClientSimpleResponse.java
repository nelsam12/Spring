package sn.ism.auchan.web.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Client;

@Getter
@Setter
public class ClientSimpleResponse {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;

    public ClientSimpleResponse(Client client) {
        this.id = client.getId();
        this.nomComplet = client.getNomComplet();
        this.telephone = client.getTelephone();
        this.pays = client.getPays();
        this.ville = client.getVille();
        this.rue = client.getRue();
    }
}
