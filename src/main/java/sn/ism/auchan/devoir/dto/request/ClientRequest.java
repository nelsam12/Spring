package sn.ism.auchan.devoir.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ClientRequest {
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

    private List<CommandeRequest> commandes;
}
