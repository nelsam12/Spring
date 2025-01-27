package sn.ism.auchan.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.ism.auchan.data.entities.Commande;

public interface CommandeService extends Service<Commande> {
    Page<Commande> getCommandeByClient(Long id,Pageable pageable);

}
