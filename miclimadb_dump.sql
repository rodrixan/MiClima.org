--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2015-08-10 17:07:48 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE miclimadb;
--
-- TOC entry 2293 (class 1262 OID 16433)
-- Name: miclimadb; Type: DATABASE; Schema: -; Owner: webapp
--

CREATE DATABASE miclimadb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE miclimadb OWNER TO webapp;

\connect miclimadb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2294 (class 1262 OID 16433)
-- Dependencies: 2293
-- Name: miclimadb; Type: COMMENT; Schema: -; Owner: webapp
--

COMMENT ON DATABASE miclimadb IS 'Base de datos para la aplicación "miclima.org"';


--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2295 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 178 (class 3079 OID 12123)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2297 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 175 (class 1259 OID 16468)
-- Name: cities; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE cities (
    id integer NOT NULL,
    cityname character varying(20)
);


ALTER TABLE cities OWNER TO webapp;

--
-- TOC entry 174 (class 1259 OID 16466)
-- Name: cities_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cities_id_seq OWNER TO webapp;

--
-- TOC entry 2298 (class 0 OID 0)
-- Dependencies: 174
-- Name: cities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE cities_id_seq OWNED BY cities.id;


--
-- TOC entry 177 (class 1259 OID 16492)
-- Name: climaticdata; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE climaticdata (
    id integer NOT NULL,
    validated boolean,
    cityname character varying(20),
    temperature integer,
    humidity integer,
    precipitation integer,
    date date,
    daytypename character varying(20)
);


ALTER TABLE climaticdata OWNER TO webapp;

--
-- TOC entry 176 (class 1259 OID 16490)
-- Name: climaticdata_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE climaticdata_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE climaticdata_id_seq OWNER TO webapp;

--
-- TOC entry 2299 (class 0 OID 0)
-- Dependencies: 176
-- Name: climaticdata_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE climaticdata_id_seq OWNED BY climaticdata.id;


--
-- TOC entry 173 (class 1259 OID 16460)
-- Name: daytypes; Type: TABLE; Schema: public; Owner: webapp; Tablespace: 
--

CREATE TABLE daytypes (
    id integer NOT NULL,
    daytypename character varying(20)
);


ALTER TABLE daytypes OWNER TO webapp;

--
-- TOC entry 172 (class 1259 OID 16458)
-- Name: daytypes_id_seq; Type: SEQUENCE; Schema: public; Owner: webapp
--

CREATE SEQUENCE daytypes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE daytypes_id_seq OWNER TO webapp;

--
-- TOC entry 2300 (class 0 OID 0)
-- Dependencies: 172
-- Name: daytypes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webapp
--

ALTER SEQUENCE daytypes_id_seq OWNED BY daytypes.id;


--
-- TOC entry 2160 (class 2604 OID 16471)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY cities ALTER COLUMN id SET DEFAULT nextval('cities_id_seq'::regclass);


--
-- TOC entry 2161 (class 2604 OID 16495)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY climaticdata ALTER COLUMN id SET DEFAULT nextval('climaticdata_id_seq'::regclass);


--
-- TOC entry 2159 (class 2604 OID 16463)
-- Name: id; Type: DEFAULT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY daytypes ALTER COLUMN id SET DEFAULT nextval('daytypes_id_seq'::regclass);


--
-- TOC entry 2286 (class 0 OID 16468)
-- Dependencies: 175
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO cities (id, cityname) VALUES (1, 'Madrid');
INSERT INTO cities (id, cityname) VALUES (2, 'Getafe');
INSERT INTO cities (id, cityname) VALUES (3, 'Alcalá de Henares');
INSERT INTO cities (id, cityname) VALUES (4, 'Móstoles');
INSERT INTO cities (id, cityname) VALUES (5, 'Alcorcón');
INSERT INTO cities (id, cityname) VALUES (6, 'Navacerrada');
INSERT INTO cities (id, cityname) VALUES (7, 'San Fernando');
INSERT INTO cities (id, cityname) VALUES (8, 'Torrejón');


--
-- TOC entry 2301 (class 0 OID 0)
-- Dependencies: 174
-- Name: cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('cities_id_seq', 8, true);


--
-- TOC entry 2288 (class 0 OID 16492)
-- Dependencies: 177
-- Data for Name: climaticdata; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (7, true, 'Getafe', 15, 20, 0, '2014-02-15', 'Soleado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (8, true, 'Madrid', 10, 35, 50, '2008-10-23', 'Nublado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (9, true, 'Madrid', 20, 20, 20, '2015-04-03', 'Soleado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (10, true, 'Madrid', 20, 20, 20, '2015-04-03', 'Soleado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (11, true, 'Navacerrada', 15, 30, 50, '2015-04-17', 'Tsunami');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (12, true, 'Alcalá de Henares', 60, 0, 0, '2015-04-01', 'Ventisca');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (13, true, 'Alcalá de Henares', 4, 25, 9, '2015-04-09', 'Tornado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (14, true, 'Alcalá de Henares', 4, 25, 9, '2015-04-09', 'Tornado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (15, true, 'Móstoles', 51, 54, 52, '2015-04-15', 'Nevado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (16, true, 'Móstoles', 54, 78, 65, '2015-04-16', 'Nublado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (17, true, 'Madrid', 250, 54, 66, '2015-04-16', 'Nevado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (18, true, 'Alcorcón', 45, 50, 50, '2015-04-01', 'Nevado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (19, true, 'Móstoles', 45, 50, 45, '2015-04-16', 'Tsunami');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (20, true, 'Alcalá de Henares', -15, 20, 20, '2015-04-08', 'Tornado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (21, true, 'Navacerrada', -20, 35, 40, '2015-04-16', 'Ventisca');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (22, true, 'Getafe', -20, 30, 45, '2015-04-24', 'Niebla');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (23, true, 'Getafe', 50, 0, 20, '2015-04-02', 'Ventisca');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (24, true, 'Getafe', 35, 10, 50, '2015-04-02', 'Nevado');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (25, true, 'Getafe', -8, 65, 123, '2015-04-08', 'Lluvioso');
INSERT INTO climaticdata (id, validated, cityname, temperature, humidity, precipitation, date, daytypename) VALUES (26, true, 'Torrejón', 14, 20, 40, '2015-08-12', 'Soleado');


--
-- TOC entry 2302 (class 0 OID 0)
-- Dependencies: 176
-- Name: climaticdata_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('climaticdata_id_seq', 26, true);


--
-- TOC entry 2284 (class 0 OID 16460)
-- Dependencies: 173
-- Data for Name: daytypes; Type: TABLE DATA; Schema: public; Owner: webapp
--

INSERT INTO daytypes (id, daytypename) VALUES (1, 'Soleado');
INSERT INTO daytypes (id, daytypename) VALUES (2, 'Nublado');
INSERT INTO daytypes (id, daytypename) VALUES (3, 'Lluvioso');
INSERT INTO daytypes (id, daytypename) VALUES (4, 'Nevado');
INSERT INTO daytypes (id, daytypename) VALUES (5, 'Niebla');
INSERT INTO daytypes (id, daytypename) VALUES (6, 'Tornado');
INSERT INTO daytypes (id, daytypename) VALUES (7, 'Ventisca');
INSERT INTO daytypes (id, daytypename) VALUES (8, 'Tsunami');


--
-- TOC entry 2303 (class 0 OID 0)
-- Dependencies: 172
-- Name: daytypes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webapp
--

SELECT pg_catalog.setval('daytypes_id_seq', 8, true);


--
-- TOC entry 2167 (class 2606 OID 16487)
-- Name: cities_cityname_key; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY cities
    ADD CONSTRAINT cities_cityname_key UNIQUE (cityname);


--
-- TOC entry 2169 (class 2606 OID 16485)
-- Name: cities_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- TOC entry 2171 (class 2606 OID 16497)
-- Name: climaticdata_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY climaticdata
    ADD CONSTRAINT climaticdata_pkey PRIMARY KEY (id);


--
-- TOC entry 2163 (class 2606 OID 16489)
-- Name: daytypes_daytypename_key; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY daytypes
    ADD CONSTRAINT daytypes_daytypename_key UNIQUE (daytypename);


--
-- TOC entry 2165 (class 2606 OID 16465)
-- Name: daytypes_pkey; Type: CONSTRAINT; Schema: public; Owner: webapp; Tablespace: 
--

ALTER TABLE ONLY daytypes
    ADD CONSTRAINT daytypes_pkey PRIMARY KEY (id);


--
-- TOC entry 2172 (class 2606 OID 16498)
-- Name: climaticdata_cityname_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY climaticdata
    ADD CONSTRAINT climaticdata_cityname_fkey FOREIGN KEY (cityname) REFERENCES cities(cityname);


--
-- TOC entry 2173 (class 2606 OID 16503)
-- Name: climaticdata_daytypename_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webapp
--

ALTER TABLE ONLY climaticdata
    ADD CONSTRAINT climaticdata_daytypename_fkey FOREIGN KEY (daytypename) REFERENCES daytypes(daytypename);


--
-- TOC entry 2296 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-08-10 17:07:48 CEST

--
-- PostgreSQL database dump complete
--

