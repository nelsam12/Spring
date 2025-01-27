package sn.ism.auchan.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.data.repository.CommandeRepository;
import sn.ism.auchan.services.CommandeService;

@Service
public class CommandeServiceImpl extends ServiceImpl<Commande, CommandeRepository> implements CommandeService {

    public CommandeServiceImpl(CommandeRepository repository) {
        super(repository);
    }

    @Override
    public Commande setValues(Commande itemRequest, Commande itemFound) {
        return null;
    }

    @Override
    public Page<Commande> getCommandeByClient(Long id, Pageable pageable) {
        return repository.getCommandeByClientId(id, pageable);
    }
}
