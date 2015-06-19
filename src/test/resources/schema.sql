CREATE TABLE dias (
    id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tipodia character varying(20)
);

CREATE TABLE localidades (
    id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre character varying(20)
);

CREATE TABLE datos (
    id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,
    validado boolean,
    localidad character varying(20),
    temperatura integer,
    humedad integer,
    precipitacion integer,
    fecha date,
    tipodia character varying(20),
    FOREIGN KEY (localidad) REFERENCES localidades(nombre),
    FOREIGN KEY (tipodia) REFERENCES dias(tipodia)
);