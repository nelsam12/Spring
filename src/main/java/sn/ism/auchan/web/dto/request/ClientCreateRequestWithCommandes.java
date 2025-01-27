package sn.ism.auchan.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientCreateRequestWithCommandes {
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le Téléphone est obligatoire")
    @Pattern(regexp = "^(77|78|76)([0-9]{7})", message = "Le téléphone est invalide")
    private String telephone;
    @NotBlank(message = "Le pays est obligatoire")
    private String pays;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "La rue est obligatoire")
    private String rue;
    private List<SimpleCommandeCreate> commandes = new ArrayList<>();

    @Override
    public String toString() {
        return "ClientCreateRequestWithCommandes{" +
                "commandes=" + commandes +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                '}';
    }

//    public String getNomComplet() {
//        return nomComplet;
//    }
//
//    public void setNomComplet(String nomComplet) {
//        this.nomComplet = nomComplet;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getPays() {
//        return pays;
//    }
//
//    public void setPays(String pays) {
//        this.pays = pays;
//    }
//
//    public String getVille() {
//        return ville;
//    }
//
//    public void setVille(String ville) {
//        this.ville = ville;
//    }
//
//    public String getRue() {
//        return rue;
//    }
//
//    public void setRue(String rue) {
//        this.rue = rue;
//    }
//
//    public List<SimpleCommandeCreate> getCommandes() {
//        return commandes;
//    }
//
//    public void setCommandes(List<SimpleCommandeCreate> commandes) {
//        this.commandes = commandes;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Client toEntity(){
        Client client = new Client();
        client.setNomComplet(nomComplet);
        client.setTelephone(telephone);
        client.setPays(pays);
        client.setVille(ville);
        client.setRue(rue);
        client.setCommandes(commandes.stream().map(c -> {
            Commande cmd = c.toEntity();
            cmd.setClient(client);
            return cmd;
        }).collect(Collectors.toList()));
        return client;
    }
}
