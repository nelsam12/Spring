package sn.ism.auchan.data.mock;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.data.enums.StatusEnum;
import sn.ism.auchan.services.ClientService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Order(1)
@Component
@RequiredArgsConstructor
public class ClientMock implements CommandLineRunner {

    private final ClientService clientService;

//    public ClientMock(ClientService clientService) {
//        this.clientService = clientService;
//    }

    @Override
    public void run(String... args) {
        List<Client> clients = new ArrayList<>();
        Random random = new Random();
        String[] prefixes = {"77", "78", "70"};
        for (int i = 1; i <= 10; i++) {
            Client c = new Client();
            c.setTelephone(generatePhoneNumber(random, prefixes));
            c.setNomComplet("Nom_" + i + "Prénom_" + i);
            c.setRue("Rue_" + i);
            c.setVille("Ville_" + i);
            c.setPays("Pays_" + i);
            clients.add(c);
            // Insertion des Commandes du client
            for (int j = 1; j <= 10; j++) {
                Commande commande = new Commande();
                commande.setDateCommande(LocalDateTime.now());
                commande.setStatus(StatusEnum.ENCOURS);
                commande.setMontant(10000.0 * j);
                commande.setPays("Pays_Com_" + j);
                commande.setVille("Ville_Com" + j);
                commande.setRue("Rue_Com" + j);
                c.getCommandes().add(commande); //OneToMany
                commande.setClient(c); // ManyToOne
            }
        }
        // Sauvegarder toutes les catégories
        clientService.saveAll(clients);
    }

    private String generatePhoneNumber(Random random, String[] prefixes) {
        String prefix = prefixes[random.nextInt(prefixes.length)];
        int remainingDigits = 7; // 9 chiffres au total moins les 2 ou 3 du préfixe
        StringBuilder phoneNumber = new StringBuilder(prefix);

        for (int i = 0; i < remainingDigits; i++) {
            phoneNumber.append(random.nextInt(10)); // Génère un chiffre aléatoire de 0 à 9
        }

        return phoneNumber.toString();
    }
}
