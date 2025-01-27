package sn.ism.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomComplet;
    @Column(nullable = false)
    private String telephone;
    private String pays;
    private String ville;
    private String rue;
    // Relation
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Commande> commandes = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nomComplet='" + nomComplet + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                '}';
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
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
//    public List<Commande> getCommandes() {
//        return commandes;
//    }
//
//    public void setCommandes(List<Commande> commandes) {
//        this.commandes = commandes;
//    }
}
