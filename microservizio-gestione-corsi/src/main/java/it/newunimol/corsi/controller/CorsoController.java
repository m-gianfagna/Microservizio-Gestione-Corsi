package it.newunimol.corsi.controller;

import it.newunimol.corsi.dto.CorsoRequestDTO;
import it.newunimol.corsi.dto.CorsoResponseDTO;
import it.newunimol.corsi.service.CorsoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/corsi")
public class CorsoController {

    private final CorsoService corsoService;

    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping
    public ResponseEntity<List<CorsoResponseDTO>> listCorsi() {
        return ResponseEntity.ok(corsoService.listCorsi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorsoResponseDTO> getCorso(@PathVariable String id) {
        return corsoService.getCorsoById(UUID.fromString(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CorsoResponseDTO> createCorso(@RequestBody CorsoRequestDTO dto) {
        return ResponseEntity.status(201).body(corsoService.createCorso(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorso(@PathVariable String id) {
        corsoService.deleteCorso(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}

