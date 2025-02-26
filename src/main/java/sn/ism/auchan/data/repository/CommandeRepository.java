package sn.ism.auchan.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.auchan.data.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> getCommandeByClientId(Long id, Pageable pageable);
}
