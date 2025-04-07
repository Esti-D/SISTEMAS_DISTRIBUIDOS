CREATE DATABASE IF NOT EXISTS sisdisrequirements;
USE sisdisrequirements;

CREATE TABLE IF NOT EXISTS proyecto (
                                        id_pro INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre_pro VARCHAR(100) NOT NULL
                                        );

-- Tabla de subsistemas
CREATE TABLE IF NOT EXISTS subsistema (
                            id_sub INT AUTO_INCREMENT PRIMARY KEY,
                            nombre_sub VARCHAR(100) NOT NULL
);

-- Tabla de documentos
CREATE TABLE IF NOT EXISTS documento(
                           id_doc INT AUTO_INCREMENT PRIMARY KEY,
                           nombre_doc VARCHAR(100) NOT NULL,
                           id_pro INT,
                           FOREIGN KEY (id_pro) REFERENCES proyecto(id_pro)
);

-- Tabla intermedia: asociaciones entre documento y subsistema
CREATE TABLE IF NOT EXISTS asociaciones (
                              id_doc INT,
                              id_sub INT,
                              PRIMARY KEY (id_doc, id_sub),
                              FOREIGN KEY (id_doc) REFERENCES documento(id_doc),
                              FOREIGN KEY (id_sub) REFERENCES subsistema(id_sub)
);

-- Insertar proyecto
INSERT INTO proyecto (nombre_pro) VALUES ('Lieja');
INSERT INTO proyecto (nombre_pro) VALUES ('Jerusamen');
INSERT INTO proyecto (nombre_pro) VALUES ('Parramatta');
INSERT INTO proyecto (nombre_pro) VALUES ('Tel Aviv');
-- Insertar subsistemas
INSERT INTO subsistema (nombre_sub) VALUES ('ROLLING');
INSERT INTO subsistema (nombre_sub) VALUES ('CYBER');
INSERT INTO subsistema (nombre_sub) VALUES ('MEP');

-- Insertar documento
INSERT INTO documento (nombre_doc, id_pro) VALUES ('analisis_inicial.pdf', 1);
INSERT INTO documento (nombre_doc, id_pro) VALUES ('analisis_inicial.pdf', 2);
INSERT INTO documento (nombre_doc, id_pro) VALUES ('analisis_inicial.pdf', 3);

-- Asociar documento con subsistemas
INSERT INTO asociaciones (id_doc, id_sub) VALUES (1, 1), (1, 2);
INSERT INTO asociaciones (id_doc, id_sub) VALUES (2, 1), (3, 3);
INSERT INTO asociaciones (id_doc, id_sub) VALUES (3, 2), (2, 3);
