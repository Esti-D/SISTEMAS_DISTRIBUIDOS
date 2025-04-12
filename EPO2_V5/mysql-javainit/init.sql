CREATE DATABASE IF NOT EXISTS sisdisusers;
USE sisdisusers;

CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT NOT NULL AUTO_INCREMENT,
                                    username VARCHAR(255),
                                    password VARCHAR(255),
                                    PRIMARY KEY (id)
);

INSERT INTO user (username, password) VALUES ('estibalitz', 'UBU1');
INSERT INTO user (username, password) VALUES ('aroca', 'UBU2');