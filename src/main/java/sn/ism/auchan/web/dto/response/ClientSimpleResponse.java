package sn.ism.auchan.web.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSimpleResponse {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;

    @Override
    public String toString() {
        return "ClientSimpleResponse{" +
                "id=" + id +
                ", nomComplet='" + nomComplet + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                '}';
    }

//    public ClientSimpleResponse(Client client) {
//        this.id = client.getId();
//        this.nomComplet = client.getNomComplet();
//        this.telephone = client.getTelephone();
//        this.pays = client.getPays();
//        this.ville = client.getVille();
//        this.rue = client.getRue();
//    }
}
