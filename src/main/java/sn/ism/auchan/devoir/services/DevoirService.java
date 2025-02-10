package sn.ism.auchan.devoir.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;


public interface DevoirService {
    Client createClient(Client client);
    Page<Commande> findAllCommandesByClientId(Pageable pageable, Long clientId);
    Client findClientById(Long clientId);

}
