DROP TABLE IF EXISTS Ranking CASCADE;
DROP TABLE IF EXISTS Institucion CASCADE;
DROP TABLE IF EXISTS Voluntario CASCADE;
DROP TABLE IF EXISTS Emergencia CASCADE;
DROP TABLE IF EXISTS Vol_habilidad CASCADE;
DROP TABLE IF EXISTS Eme_habilidad CASCADE;
DROP TABLE IF EXISTS Habilidad CASCADE;
DROP TABLE IF EXISTS Tarea CASCADE;
DROP TABLE IF EXISTS Tarea_habilidad CASCADE;
DROP TABLE IF EXISTS Estado_tarea CASCADE;


CREATE EXTENSION postgis;


CREATE TABLE Voluntario(

    id serial,
    nombre varchar(50),
    disponibilidad boolean,
    telefono varchar(10),
    direccion text,
    correo_electronico varchar(100),
    rut varchar(12) UNIQUE,
    ubicacion GEOMETRY (point),
    deleted boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id)

);

CREATE TABLE Institucion (

    id serial,
    nombre varchar(50),
    direccion text,
    telefono varchar(10),
    dominio varchar(50),
    deleted boolean NOT NULL DEFAULT false,

    PRIMARY KEY (id)

);

CREATE TABLE Habilidad (

    id serial,
    nombreH varchar(50),
    descripcion text,
    deleted boolean NOT NULL DEFAULT false,

    PRIMARY KEY (id)

);

CREATE TABLE Estado_tarea(

    id serial,
    estado varchar(50),
    deleted boolean NOT NULL DEFAULT false,

    PRIMARY KEY (id)

);

CREATE TABLE Emergencia (

    id serial,
    titulo varchar(50),
    direccion text,
    descripcion text,
    id_institucion integer,
    activo boolean,
    ubicacion GEOMETRY (point),
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_institucion) REFERENCES Institucion(id),
    PRIMARY KEY (id)

);

CREATE TABLE Tarea(

    id serial,
    titulo varchar(50),
    descripcion text,
    cant_voluntarios integer,
    id_estado integer NOT NULL,
    id_emergencia integer NOT NULL,
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_estado) REFERENCES Estado_tarea(id),
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id),
    PRIMARY KEY (id)

);

CREATE TABLE Vol_habilidad (
    id serial,
    id_voluntario integer NOT NULL,
    id_habilidad integer NOT NULL,
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id),
    PRIMARY KEY (id)
);

CREATE TABLE Eme_habilidad (

    id serial,
    id_emergencia integer NOT NULL,
    id_habilidad integer NOT NULL,
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id),
    PRIMARY KEY (id)

);

CREATE TABLE Tarea_habilidad(

    id serial,
    id_tarea integer NOT NULL,
    id_eme_habilidad integer NOT NULL,
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_tarea) REFERENCES Tarea(id),
    FOREIGN KEY (id_eme_habilidad) REFERENCES Eme_habilidad(id),
    PRIMARY KEY (id)

);

CREATE TABLE Ranking (

    id  serial,
    valor integer,
    id_tarea integer NOT NULL,
    id_voluntario integer NOT NULL,
    deleted boolean NOT NULL DEFAULT false,

    FOREIGN KEY (id_tarea) REFERENCES Tarea(id),
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id),
    PRIMARY KEY (id)

);
