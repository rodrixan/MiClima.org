--
-- Data for table 'cities'
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
-- Data for table 'daytypes'
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
-- Data for table 'climaticdata'
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
