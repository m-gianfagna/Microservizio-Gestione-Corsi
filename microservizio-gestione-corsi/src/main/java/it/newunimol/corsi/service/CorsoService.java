package it.newunimol.corsi.service;

import it.newunimol.corsi.dto.*;
import it.newunimol.corsi.entity.*;
import it.newunimol.corsi.messaging.CorsoEventProducer;
import it.newunimol.corsi.repository.CorsoRepository;
import it.newunimol.corsi.repository.DocenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;
    private final DocenteRepository docenteRepository;
    private final CorsoEventProducer eventProducer;

    public CorsoService(CorsoRepository corsoRepository, DocenteRepository docenteRepository, CorsoEventProducer eventProducer) {
        this.corsoRepository = corsoRepository;
        this.docenteRepository = docenteRepository;
        this.eventProducer = eventProducer;
    }

    public List<CorsoResponseDTO> listCorsi() {
        return corsoRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<CorsoResponseDTO> getCorsoById(UUID id) {
        return corsoRepository.findById(id).map(this::mapToResponse);
    }

    @Transactional
    public CorsoResponseDTO createCorso(CorsoRequestDTO dto) {
        Corso corso = new Corso();
        corso.setNome(dto.getNome());
        corso.setCodice(dto.getCodice());
        corso.setDescrizione(dto.getDescrizione());
        corso.setCfu(dto.getCfu());

        if(dto.getDocentiIds() != null){
            Set<Docente> docenti = dto.getDocentiIds().stream()
                    .map(UUID::fromString)
                    .map(docenteRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            corso.setDocenti(docenti);
        }

        if(dto.getOrari() != null){
            Set<Orario> orari = dto.getOrari().stream().map(o -> {
                Orario orario = new Orario();
                orario.setGiorno(o.getGiorno());
                orario.setOraInizio(o.getOraInizio());
                orario.setOraFine(o.getOraFine());
                orario.setAula(o.getAula());
                orario.setCorso(corso);
                return orario;
            }).collect(Collectors.toSet());
            corso.setOrari(orari);
        }

        Corso saved = corsoRepository.save(corso);
        eventProducer.publishCorsoCreated(mapToResponse(saved));
        return mapToResponse(saved);
    }

    @Transactional
    public void deleteCorso(UUID id) {
        corsoRepository.deleteById(id);
        eventProducer.publishCorsoDeleted(id.toString());
    }

    private CorsoResponseDTO mapToResponse(Corso corso) {
        CorsoResponseDTO dto = new CorsoResponseDTO();
        dto.setId(corso.getId().toString());
        dto.setNome(corso.getNome());
        dto.setCodice(corso.getCodice());
        dto.setDescrizione(corso.getDescrizione());
        dto.setCfu(corso.getCfu());

        dto.setDocenti(corso.getDocenti().stream().map(d -> {
            DocenteDTO docenteDTO = new DocenteDTO();
            docenteDTO.setId(d.getId().toString());
            docenteDTO.setNome(d.getNome());
            docenteDTO.setCognome(d.getCognome());
            docenteDTO.setEmail(d.getEmail());
            return docenteDTO;
        }).collect(Collectors.toList()));

        dto.setOrari(corso.getOrari().stream().map(o -> {
            OrarioDTO orarioDTO = new OrarioDTO();
            orarioDTO.setId(o.getId().toString());
            orarioDTO.setGiorno(o.getGiorno());
            orarioDTO.setOraInizio(o.getOraInizio());
            orarioDTO.setOraFine(o.getOraFine());
            orarioDTO.setAula(o.getAula());
            return orarioDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
}

