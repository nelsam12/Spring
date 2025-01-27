package sn.ism.auchan.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.data.enums.StatusEnum;

import java.time.LocalDateTime;

@Getter
@Setter
public class SimpleCommandeCreate {
    private StatusEnum status;
    private LocalDateTime dateCommande;
    @NotBlank(message = "Le montant de la commande est obligatoire")
    private Double montant;
    private String pays;
    private String ville;
    private String rue;

    public SimpleCommandeCreate() {
        dateCommande = LocalDateTime.now();
        status = StatusEnum.ENCOURS;
    }
//
//    public StatusEnum getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusEnum status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getDateCommande() {
//        return dateCommande;
//    }
//
//    public void setDateCommande(LocalDateTime dateCommande) {
//        this.dateCommande = dateCommande;
//    }
//
//    public Double getMontant() {
//        return montant;
//    }
//
//    public void setMontant(Double montant) {
//        this.montant = montant;
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

    @Override
    public String toString() {
        return "SimpleCommandeCreate{" +
                "status=" + status +
                ", dateCommande=" + dateCommande +
                ", montant=" + montant +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                '}';
    }

    public Commande toEntity() {
        Commande commande = new Commande();
        commande.setDateCommande(LocalDateTime.now());
        commande.setMontant(montant);
        commande.setPays(pays);
        commande.setVille(ville);
        commande.setRue(rue);
        commande.setStatus(StatusEnum.ENCOURS);
        return commande;
    }
}
