package sn.ism.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.data.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private LocalDateTime dateCommande;
    private Double montant;
    @Column(nullable = false)
    private String pays;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String rue;
    // Relation
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;
    @OneToMany(mappedBy = "commande")
    private List<Detail> details;
    @ManyToOne(optional = false)
    private Client client; // client_id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
