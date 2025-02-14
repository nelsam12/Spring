package sn.ism.auchan.devoir.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
 @Getter
 @Setter
 @Builder
public class ClientResponse {
//  au lieu de setNomComplet, il a mis nomComplet !
     private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;
    private List<CommandeResponse> commandes;
}
