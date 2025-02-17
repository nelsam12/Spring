package sn.ism.auchan.devoir.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import sn.ism.auchan.utils.validators.ListNotEmpty;
import sn.ism.auchan.utils.validators.TelephoneUnique;

import java.util.List;
@Getter
@Setter
public class ClientRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le Téléphone est obligatoire")
    @Pattern(regexp = "^(77|78|76)([0-9]{7})$", message = "Le téléphone est invalide")
    @TelephoneUnique()
    private String telephone;
    @NotBlank(message = "Le pays est obligatoire")
    private String pays;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "La rue est obligatoire")
    private String rue;
    @ListNotEmpty(message = "Vous devez avoir au moins une commande !")
    private List<CommandeRequest> commandes;
}
