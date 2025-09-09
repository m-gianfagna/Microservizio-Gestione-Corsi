package it.newunimol.corsi.repository;

import it.newunimol.corsi.entity.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CorsoRepository extends JpaRepository<Corso, UUID> {
    Optional<Corso> findByCodice(String codice);
}

