package sn.ism.auchan.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ism.auchan.data.entities.Client;
import sn.ism.auchan.data.repository.ClientRepository;
import sn.ism.auchan.services.ClientService;

import java.util.List;

@Transactional
@Service
public class ClientServiceImpl extends ServiceImpl<Client, ClientRepository> implements ClientService {


    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

    @Override
    public Client setValues(Client itemRequest, Client itemFound) {
        itemFound.setTelephone(itemFound.getTelephone());
        itemFound.setNomComplet(itemFound.getNomComplet());
        itemFound.setPays(itemFound.getPays());
        itemFound.setVille(itemFound.getVille());
        itemFound.setRue(itemFound.getRue());
        itemFound.setCommandes(itemFound.getCommandes());
        return itemFound;
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void saveAll(List<Client> clients) {
        repository.saveAllAndFlush(clients);
    }

//    @Override
//    public Client getClientWithCommandes(Long clientId) {
//        return null;
//    }
}
