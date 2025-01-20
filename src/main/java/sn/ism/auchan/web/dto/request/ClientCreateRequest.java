package sn.ism.auchan.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import sn.ism.auchan.data.entities.Client;

public class ClientCreateRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le Téléphone est obligatoire")
    @Pattern(regexp = "^(77|78|76)([0-9]{7})/", message = "Le téléphone est invalide")
    private String telephone;
    @NotBlank(message = "Le pays est obligatoire")
    private String pays;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "La rue est obligatoire")
    private String rue;

    public Client toEntity(){
        Client client = new Client();
        client.setNomComplet(nomComplet);
        client.setTelephone(telephone);
        client.setPays(pays);
        client.setVille(ville);
        client.setRue(rue);

        return client;
    }
}
