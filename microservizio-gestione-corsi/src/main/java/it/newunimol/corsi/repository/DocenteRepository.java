package it.newunimol.corsi.repository;

import it.newunimol.corsi.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocenteRepository extends JpaRepository<Docente, UUID> {
}

