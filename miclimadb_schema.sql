-- DROP DATABASE miclimadb;

-- CREATE DATABASE miclimadb;


--
-- Table 'cities'
--

CREATE TABLE cities (
    id serial PRIMARY KEY NOT NULL,
    cityname character varying(20) UNIQUE
);


--
-- Table 'daytypes'
--

CREATE TABLE daytypes (
    id serial PRIMARY KEY NOT NULL,
    daytypename character varying(20) UNIQUE
);


--
-- Table 'climaticdata'
--

CREATE TABLE climaticdata (
    id serial PRIMARY KEY NOT NULL,
    validated boolean,
    cityname character varying(20) REFERENCES cities(cityname),
    temperature integer,
    humidity integer,
    precipitation integer,
    date date,
    daytypename character varying(20) REFERENCES daytypes(daytypename)
);
