package sn.ism.auchan.devoir.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.data.repository.ClientRepository;
import sn.ism.auchan.data.repository.CommandeRepository;
import sn.ism.auchan.devoir.services.DevoirService;

@Service
@Transactional
@RequiredArgsConstructor // Injection de Dépendance via le constructeur

// @Autowired à éviter !!!!
public class DevoirServiceImpl implements DevoirService {
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;

//    public DevoirServiceImpl(ClientRepository clientRepository, CommandeRepository commandeRepository) {
//        this.clientRepository = clientRepository;
//        this.commandeRepository = commandeRepository;
//    }


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Page<Commande> findAllCommandesByClientId(Pageable pageable, Long clientId) {
        return commandeRepository.getCommandeByClientId(clientId, pageable);
    }

    @Override
    public Client findClientById(Long clientId) {
//        return clientRepository.findById(clientId).get(); // Si l'id existe (on est sûr)
//        le cas des exceptions, (eg : lors de l'ajout d'une commande avec un client qui n'existe pas
        return clientRepository
                .findById(clientId)
                .orElseThrow(
                        () -> new RuntimeException("L'id n'existe pas")
                ); // On n'est pas sûr de l'existence de l'ID


    }


}
