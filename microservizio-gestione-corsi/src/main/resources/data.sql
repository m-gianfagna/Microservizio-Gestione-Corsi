-- Inseriamo un docente
INSERT INTO docente (id, nome, cognome, email)
VALUES ('00000000-0000-0000-0000-000000000001', 'Mario', 'Rossi', 'mario.rossi@unimol.it');
INSERT INTO docente (id, nome, cognome, email)
VALUES ('00000000-0000-0000-0000-000000000002', 'Lucia', 'Bianchi', 'lucia.bianchi@unimol.it');
INSERT INTO docente (id, nome, cognome, email)
VALUES ('00000000-0000-0000-0000-000000000003', 'Zio', 'Tonino', 'zio.tonino@unimol.it');

-- Inseriamo un corso
INSERT INTO corso (id, codice, nome, descrizione, cfu)
VALUES ('00000000-0000-0000-0000-000000000101', 'INF101', 'Programmazione 1', 'Corso base di Java e algoritmi', 9);
INSERT INTO corso (id, codice, nome, descrizione, cfu)
VALUES ('00000000-0000-0000-0000-000000000102', 'INF102', 'AWS', 'Cloud Computing con Amazon Web Services', 9);
INSERT INTO corso (id, codice, nome, descrizione, cfu)
VALUES ('00000000-0000-0000-0000-000000000103', 'AGR101', 'Agricoltura', 'Vai a zappare', 3);

-- Associazione corso-docente
INSERT INTO corso_docente (corso_id, docente_id)
VALUES ('00000000-0000-0000-0000-000000000101', '00000000-0000-0000-0000-000000000001');
INSERT INTO corso_docente (corso_id, docente_id)
VALUES ('00000000-0000-0000-0000-000000000102', '00000000-0000-0000-0000-000000000002');
INSERT INTO corso_docente (corso_id, docente_id)
VALUES ('00000000-0000-0000-0000-000000000103', '00000000-0000-0000-0000-000000000003');

-- Inseriamo un orario
INSERT INTO orario (id, aula, giorno, ora_inizio, ora_fine, corso_id)
VALUES ('00000000-0000-0000-0000-000000000201', 'Aula Magna', 'Lunedì', '09:00', '11:00', '00000000-0000-0000-0000-000000000101');
INSERT INTO orario (id, aula, giorno, ora_inizio, ora_fine, corso_id)
VALUES ('00000000-0000-0000-0000-000000000202', 'I. Bird', 'Martedì', '10:00', '13:00', '00000000-0000-0000-0000-000000000102');
INSERT INTO orario (id, aula, giorno, ora_inizio, ora_fine, corso_id)
VALUES ('00000000-0000-0000-0000-000000000203', 'In campagna', 'Tutti i giorni', '06:00', '10:00', '00000000-0000-0000-0000-000000000103');

