package it.newunimol.corsi.controller;

import it.newunimol.corsi.dto.CorsoRequestDTO;
import it.newunimol.corsi.dto.CorsoResponseDTO;
import it.newunimol.corsi.service.CorsoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/corsi")
@Tag(name = "Corsi", description = "API per la gestione dei corsi")
public class CorsoController {

    private final CorsoService corsoService;

    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping
    @Operation(summary = "Ottieni tutti i corsi", description = "Restituisce l'elenco di tutti i corsi disponibili")
    public ResponseEntity<List<CorsoResponseDTO>> listCorsi() {
        return ResponseEntity.ok(corsoService.listCorsi());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ottieni corso per ID", description = "Restituisce i dettagli di un singolo corso")
    public ResponseEntity<CorsoResponseDTO> getCorso(@PathVariable String id) {
        return corsoService.getCorsoById(UUID.fromString(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
        summary = "Crea un nuovo corso",
        description = "Crea un nuovo corso con docenti e orari associati",
        requestBody = @RequestBody(
            description = "Dati del corso da creare",
            required = true,
            content = @Content(schema = @Schema(implementation = CorsoRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Corso creato con successo",
                content = @Content(schema = @Schema(implementation = CorsoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
        }
    )
    public ResponseEntity<CorsoResponseDTO> createCorso(@org.springframework.web.bind.annotation.RequestBody CorsoRequestDTO dto) {
        return ResponseEntity.status(201).body(corsoService.createCorso(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un corso", description = "Elimina un corso esistente per ID")
    public ResponseEntity<Void> deleteCorso(@PathVariable String id) {
        corsoService.deleteCorso(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}