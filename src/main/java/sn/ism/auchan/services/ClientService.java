package sn.ism.auchan.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.ism.auchan.data.entities.Client;

import java.util.List;

public interface ClientService extends Service<Client> {
//    Client getClientWithCommandes(Long clientId);
    Page<Client> getAllClients(Pageable pageable);
    void saveAll(List<Client> clients);
}
