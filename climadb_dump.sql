--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2015-04-05 19:19:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE climadb;
--
-- TOC entry 2028 (class 1262 OID 16395)
-- Name: climadb; Type: DATABASE; Schema: -; Owner: webapp
--

CREATE DATABASE climadb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE climadb OWNER TO webapp;

\connect climadb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2029 (class 1262 OID 16395)
-- Dependencies: 2028
-- Name: climadb; Type: COMMENT; Schema: -; Owner: webapp
--

COMMENT ON DATABASE climadb IS 'Base de datos climatologicos';


--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 178 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2032 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 16511)
-- Name: datos; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE datos (
    id integer NOT NULL,
    validado boolean,
    localidad character varying(20),
    temperatura integer,
    humedad integer,
    precipitacion integer,
    fecha date,
    tipodia character varying(20)
);


ALTER TABLE datos OWNER TO webapp;

--
-- TOC entry 176 (class 1259 OID 16509)
-- Name: datos_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE datos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE datos_id_seq OWNER TO webapp;

--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 176
-- Name: datos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE datos_id_seq OWNED BY datos.id;


--
-- TOC entry 173 (class 1259 OID 16453)
-- Name: dias; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE dias (
    id integer NOT NULL,
    tipodia character varying(20)
);


ALTER TABLE dias OWNER TO webapp;

--
-- TOC entry 172 (class 1259 OID 16451)
-- Name: dias_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE dias_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dias_id_seq OWNER TO webapp;

--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 172
-- Name: dias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE dias_id_seq OWNED BY dias.id;


--
-- TOC entry 175 (class 1259 OID 16494)
-- Name: localidades; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE localidades (
    id integer NOT NULL,
    nombre character varying(20)
);


ALTER TABLE localidades OWNER TO webapp;

--
-- TOC entry 174 (class 1259 OID 16492)
-- Name: localidades_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE localidades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE localidades_id_seq OWNER TO webapp;

--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 174
-- Name: localidades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE localidades_id_seq OWNED BY localidades.id;


--
-- TOC entry 1896 (class 2604 OID 16514)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY datos ALTER COLUMN id SET DEFAULT nextval('datos_id_seq'::regclass);


--
-- TOC entry 1894 (class 2604 OID 16456)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY dias ALTER COLUMN id SET DEFAULT nextval('dias_id_seq'::regclass);


--
-- TOC entry 1895 (class 2604 OID 16497)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY localidades ALTER COLUMN id SET DEFAULT nextval('localidades_id_seq'::regclass);


--
-- TOC entry 2023 (class 0 OID 16511)
-- Dependencies: 177
-- Data for Name: datos; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (1, true, 'Getafe', 15, 20, 0, '2014-02-15', 'Soleado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (2, false, 'Madrid', 10, 35, 50, '2008-10-23', 'Nublado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (3, true, 'Madrid', 20, 20, 20, '2015-04-03', 'Soleado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (4, true, 'Madrid', 20, 20, 20, '2015-04-03', 'Soleado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (6, true, 'Navacerrada', 15, 30, 50, '2015-04-17', 'Tsunami');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (7, false, 'Alcala de Henares', 60, 0, 0, '2015-04-01', 'Ventisca');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (8, true, 'Alcala de Henares', 4, 25, 9, '2015-04-09', 'Tornado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (9, true, 'Alcala de Henares', 4, 25, 9, '2015-04-09', 'Tornado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (10, true, 'Mostoles', 51, 54, 52, '2015-04-15', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (11, true, 'Mostoles', 54, 78, 65, '2015-04-16', 'Nublado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (12, true, 'Madrid', 250, 54, 66, '2015-04-16', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (13, true, 'Alcorcon', 45, 50, 50, '2015-04-01', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (14, true, 'Mostoles', 45, 50, 45, '2015-04-16', 'Tsunami');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (15, true, 'Alcala de Henares', -15, 20, 20, '2015-04-08', 'Tornado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (16, true, 'Navacerrada', -20, 35, 40, '2015-04-16', 'Ventisca');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (17, true, 'Getafe', -20, 30, 45, '2015-04-24', 'Niebla');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (18, true, 'Getafe', 50, 0, 20, '2015-04-02', 'Ventisca');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (19, true, 'Getafe', 35, 10, 50, '2015-04-02', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (20, true, 'Getafe', -8, 65, 123, '2015-04-08', 'Lluvioso');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (21, true, 'Getafe', 100, 100, 100, '2015-04-24', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (25, true, 'Navacerrada', -6, 20, 12, '2015-04-09', 'Nevado');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (26, false, 'Getafe', 89, 30, 12, '2015-04-16', 'Ventisca');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (27, true, 'Getafe', 85, 8, 12, '2015-04-25', 'Ventisca');
INSERT INTO datos (id, validado, localidad, temperatura, humedad, precipitacion, fecha, tipodia) VALUES (28, true, 'Alcala de Henares', -5, 15, 20, '2015-04-17', 'Nevado');


--
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 176
-- Name: datos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('datos_id_seq', 28, true);


--
-- TOC entry 2019 (class 0 OID 16453)
-- Dependencies: 173
-- Data for Name: dias; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO dias (id, tipodia) VALUES (1, 'Soleado');
INSERT INTO dias (id, tipodia) VALUES (2, 'Nublado');
INSERT INTO dias (id, tipodia) VALUES (3, 'Lluvioso');
INSERT INTO dias (id, tipodia) VALUES (4, 'Nevado');
INSERT INTO dias (id, tipodia) VALUES (7, 'Niebla');
INSERT INTO dias (id, tipodia) VALUES (5, 'Tornado');
INSERT INTO dias (id, tipodia) VALUES (6, 'Ventisca');
INSERT INTO dias (id, tipodia) VALUES (8, 'Tsunami');


--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 172
-- Name: dias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('dias_id_seq', 8, true);


--
-- TOC entry 2021 (class 0 OID 16494)
-- Dependencies: 175
-- Data for Name: localidades; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO localidades (id, nombre) VALUES (2, 'Madrid');
INSERT INTO localidades (id, nombre) VALUES (0, 'Getafe');
INSERT INTO localidades (id, nombre) VALUES (1, 'Alcala de Henares');
INSERT INTO localidades (id, nombre) VALUES (4, 'Mostoles');
INSERT INTO localidades (id, nombre) VALUES (5, 'Alcorcon');
INSERT INTO localidades (id, nombre) VALUES (3, 'Navacerrada');


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 174
-- Name: localidades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('localidades_id_seq', 5, true);


--
-- TOC entry 1906 (class 2606 OID 16516)
-- Name: datos_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY datos
    ADD CONSTRAINT datos_pkey PRIMARY KEY (id);


--
-- TOC entry 1898 (class 2606 OID 16461)
-- Name: dia_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY dias
    ADD CONSTRAINT dia_pkey PRIMARY KEY (id);


--
-- TOC entry 1900 (class 2606 OID 16508)
-- Name: dias_tipodia_key; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY dias
    ADD CONSTRAINT dias_tipodia_key UNIQUE (tipodia);


--
-- TOC entry 1902 (class 2606 OID 16506)
-- Name: localidades_nombre_key; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY localidades
    ADD CONSTRAINT localidades_nombre_key UNIQUE (nombre);


--
-- TOC entry 1904 (class 2606 OID 16499)
-- Name: localidades_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY localidades
    ADD CONSTRAINT localidades_pkey PRIMARY KEY (id);


--
-- TOC entry 1908 (class 2606 OID 16522)
-- Name: datos_localidad_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY datos
    ADD CONSTRAINT datos_localidad_fkey FOREIGN KEY (localidad) REFERENCES localidades(nombre);


--
-- TOC entry 1907 (class 2606 OID 16517)
-- Name: datos_tipodia_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY datos
    ADD CONSTRAINT datos_tipodia_fkey FOREIGN KEY (tipodia) REFERENCES dias(tipodia);


--
-- TOC entry 2031 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-05 19:19:07

--
-- PostgreSQL database dump complete
--
