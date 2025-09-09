CREATE TABLE corsi (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descrizione TEXT,
    docente VARCHAR(100)
);

