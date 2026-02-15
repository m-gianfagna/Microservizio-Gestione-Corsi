-- Tabella Docenti
CREATE TABLE IF NOT EXISTS docente (
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL
);

-- Tabella Corsi
CREATE TABLE IF NOT EXISTS corso (
    id UUID PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    codice VARCHAR(50) UNIQUE NOT NULL,
    descrizione TEXT,
    cfu INT NOT NULL
);

-- Tabella di join Corsi-Docenti (molti-a-molti)
CREATE TABLE IF NOT EXISTS corso_docente (
    corso_id UUID NOT NULL,
    docente_id UUID NOT NULL,
    PRIMARY KEY (corso_id, docente_id),
    CONSTRAINT fk_corso FOREIGN KEY (corso_id) REFERENCES corso (id) ON DELETE CASCADE,
    CONSTRAINT fk_docente FOREIGN KEY (docente_id) REFERENCES docente (id) ON DELETE CASCADE
);

-- Tabella Orari
CREATE TABLE IF NOT EXISTS orario (
    id UUID PRIMARY KEY,
    corso_id UUID NOT NULL,
    giorno VARCHAR(50) NOT NULL,
    ora_inizio VARCHAR(10) NOT NULL,
    ora_fine VARCHAR(10) NOT NULL,
    aula VARCHAR(100) NOT NULL,
    CONSTRAINT fk_corso_orario FOREIGN KEY (corso_id) REFERENCES corso (id) ON DELETE CASCADE
);

