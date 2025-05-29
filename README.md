# **Microservizio Gestione Corsi**

## Indice
1. [Panoramica](#panoramica)
2. [Tecnologie utilizzate](#tecnologie-utilizzate)
3. [Modello dati](#modello-dati)  
    - [Architettura Database](#architettura-database)
    - [DTO](#dto)
    - [API REST](#api-rest)

## Panoramica
Questo microservizio è responsabile della memorizzazione e della gestione delle informazioni relative ai corsi universitari:
- **(Amministrativi)** Creazione, modifica ed eliminazione di corsi. Ogni corso è associato a uno o più docenti.
- **(Tutti)** Visualizzazione dell'elenco dei corsi disponibili.
- **(Tutti)** Visualizzazione dei dettagli di un corso (nome, codice, descrizione, crediti, docenti, orari).

## Tecnologie utilizzate
- **Linguaggio di programmazione**: Java 17
- **Framework**: SpringBoot
- **Message Broker**: RabbitMQ
- **Documentazione API**: Swagger/OpenAPI 3.0
- **Database**: PostgreSQL

## Modello dati

## Architettura Database

Tabella **Docente**

| Colonna | Tipo | Descrizione | Vincoli |
|---------|------|-------------|---------|
| `id` | **UUID** | identificatore univoco del docente | PRIMARY KEY |
| `nome` | **String** | nome del docente | NOT NULL |
| `cognome` | **String** | cognome del docente | NOT NULL |
| `email` | **String** | email del docente |  UNIQUE NOT NULL |

Tabella **Corso**
| Colonna | Tipo | Descrizione | Vincoli |
|---------|------|-------------|---------|
| `id` | **UUID** | identificatore univoco del corso | PRIMARY KEY |
| `nome` | **String** | nome del corso | NOT NULL |
| `codice` | **String** | codice del corso | UNIQUE NOT NULL |
| `descrizione` | **TEXT** | descrizione del corso | - |
| `cfu` | **Integer** | crediti del corso | NOT NULL |

Tabella **Corso Docente**
| Colonna | Tipo | Descrizione | Vincoli |
|---------|------|-------------|---------|
| `corso_id` | **UUID** | identificatore univoco del corso | ON DELETE CASCADE |
| `docente_id` | **UUID** | identificatore univoco del docente | ON DELETE CASCADE |
| | | | PRIMARY KEY (corso_id, docente_id) |

Tabella **Orario**
| Colonna | Tipo | Descrizione | Vincoli |
|---------|------|-------------|---------|
| `id` | **UUID** | identificatore univoco dell'orario | PRIMARY KEY |
| `corso_id` | **UUID** | identificatore univoco del corso | ON DELETE CASCADE |
| `giorno` | **String** | giorno previsto di lezione da orario  | NOT NULL |
| `ora_inizio` | **TIME** | orario d'inizio del corso | NOT NULL |
| `ora_fine` | **TIME** | orario di fine del corso | NOT NULL |
| `aula` | **String** | aula di svolgimento del corso | NOT NULL |

### DTO

###### *DataTransferObject presenti nel microservizio.*

#### CorsoRequestDTO

```java
// Usato per la creazione e modifica di un corso da parte degli amministratori.

public class CorsoRequestDTO {
    private String nome;
    private String codice;
    private String descrizione;
    private int cfu;
    private List<UUID> docentiIds;
    private List<OrarioDTO> orari;
}
```

#### CorsoResponseDTO

```java
// Usato per la visualizzazione dell’elenco dei corsi e dei dettagli di un singolo corso.

public class CorsoResponseDTO {
    private UUID id;
    private String nome;
    private String codice;
    private String descrizione;
    private int cfu;
    private List<DocenteDTO> docenti;
    private List<OrarioDTO> orari;
}
```

#### DocenteDTO

```java
// Usato per rappresentare le informazioni base di un docente associato a un corso.

public class DocenteDTO {
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
}
```

#### OrarioDTO

```java
// Usato per rappresentare le fasce orarie di svolgimento di un corso.

public class OrarioDTO {
    private UUID id;
    private String giorno;
    private String oraInizio;
    private String oraFine;
    private String aula;
}
```

## API REST

### CORSI ENDPOINTS

```bash
#############################################################
# Crea un nuovo corso
# @func: createCorso()
# @param: CorsoRequestDTO corsoDTO
# @return: ResponseEntity<CorsoResponseDTO>
# @access: Amministrativi
#############################################################
POST    /corsi
```

```bash
#############################################################
# Modifica un corso esistente
# @func: updateCorso()
# @param: UUID id, CorsoRequestDTO corsoDTO
# @return: ResponseEntity<Void>
# @access: Amministrativi
#############################################################
PUT     /corsi/{id}
```

```bash
#############################################################
# Elimina un corso
# @func: deleteCorso()
# @param: UUID id
# @return: ResponseEntity<Void>
# @access: Amministrativi
#############################################################
DELETE  /corsi/{id}
```

```bash
#############################################################
# Ottieni l`elenco di tutti i corsi
# @func: listCorsi()
# @return: ResponseEntity<List<CorsoResponseDTO>>
# @access: Tutti
#############################################################
GET     /corsi
```

```bash
#############################################################
# Ottieni i dettagli di un singolo corso
# @func: getCorsoById()
# @param: UUID id
# @return: ResponseEntity<CorsoResponseDTO>
# @access: Tutti
#############################################################
GET     /corsi/{id}
```
