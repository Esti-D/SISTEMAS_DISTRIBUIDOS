CREATE DATABASE IF NOT EXISTS sisdisusers;
USE sisdisusers;

CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT NOT NULL AUTO_INCREMENT,
                                    username VARCHAR(255),
                                    password VARCHAR(255),
                                    role VARCHAR(20) NOT NULL DEFAULT 'USER',
                                    PRIMARY KEY (id)
);

INSERT INTO user (username, password, role) VALUES ('estibalitz', 'UBU1','ADMIN');
INSERT INTO user (username, password, role) VALUES ('aroca', 'UBU2','ADMIN');