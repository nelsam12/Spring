package sn.ism.auchan.services.impl;

import sn.ism.auchan.data.entities.Commande;
import sn.ism.auchan.data.repository.CommandeRepository;
import sn.ism.auchan.services.CommandeService;

public class CommandeServiceImpl extends ServiceImpl<Commande, CommandeRepository> implements CommandeService {

    public CommandeServiceImpl(CommandeRepository repository) {
        super(repository);
    }

    @Override
    public Commande setValues(Commande itemRequest, Commande itemFound) {
        return null;
    }
}
