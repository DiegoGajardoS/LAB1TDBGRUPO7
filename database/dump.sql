INSERT INTO Voluntario(id,nombre,disponibilidad,telefono,direccion, correo_electronico, rut, ubicacion)
VALUES(1,'Juan','TRUE','+1234234','santiago','aa@aa.com', '12345678-0', ST_GeomFromText('POINT(-70.665676 -33.444925 )', 4326 )),
       (2,'Pedro','TRUE','+1231231','arica','p@gmail.com', '15463423-0', ST_GeomFromText('POINT(-70.293039 -18.468494 )', 4326 )), 
       (3,'Diego', 'TRUE', '+5432122', 'neltume', 'diego@hotmail.com', '11231239-0', ST_GeomFromText('POINT(-71.946096 -39.848355 )', 4326 )),
       (4,'Carla', 'TRUE', '+1234567', 'concepcion', 'carla@gmail.com', '11235264-0', ST_GeomFromText('POINT(-73.058309 -36.820649 )' , 4326 )),
       (5,'Camila', 'TRUE', '+1234567', 'chiloe', 'camila@gmail.com', '20235564-0', ST_GeomFromText('POINT(-73.766722 -42.473056 )' , 4326  )),
       (6,'Carolina', 'TRUE', '+1234567', 'puerto natales', 'carolina@gmail.com', '21235567-0',ST_GeomFromText('POINT(-72.499265 -51.735308 )', 4326  )),
       (7,'Valentina', 'TRUE', '+1234567', 'talca', 'valentina@gmail.com', '21338564-0',ST_GeomFromText('POINT(-71.659534 -35.434628 )', 4326   )),
       (8,'Cristiano', 'TRUE', '+1234567', 'valdivia', 'cristianoGOAT@gmail.com', '11237564-0',ST_GeomFromText('POINT(-73.245709 -39.824919 )', 4326   )),
       (9,'Ronaldo', 'TRUE', '+1234567', 'canete', 'ronaldo@gmail.com', '11235864-0',ST_GeomFromText('POINT(-73.390526 -37.791163 )', 4326   ) ),
       (10,'Shrek', 'TRUE', '+1234567', 'farellones', 'shrek@gmail.com', '11238564-0',ST_GeomFromText('POINT(-70.301374 -33.359879)' , 4326  ) ),
       (11,'Elsa', 'TRUE', '+1234567', 'villarrica', 'elsa@gmail.com', '11239564-0',ST_GeomFromText('POINT(-72.229159 -39.284744)' , 4326 ) ),
       (12,'Pato', 'TRUE', '+1234567', 'constitucion', 'pato@gmail.com', '11235964-0',ST_GeomFromText('POINT(-72.429450 -35.331009)', 4326   ) ),
       (13,'Olivia', 'TRUE', '+1234567', 'atacama', 'olivia@gmail.com', '11231564-0',ST_GeomFromText('POINT(-69.623951 -26.252269)', 4326   ) ),
       (14,'Rodrigo', 'TRUE', '+1234567', 'Talagante', 'rodrigo@gmail.com', '21235564-0',ST_GeomFromText('POINT(-70.920522 -33.665714)' , 4326  ) ),
       (15,'Drake', 'TRUE', '+1234567', 'puerto montt', 'drake@gmail.com', '11235564-0',ST_GeomFromText('POINT(-72.966927 -41.468711)' , 4326  )),
       (16,'Josh', 'TRUE', '+1234567', 'coquimbo', 'josh@gmail.com', '11295564-0',ST_GeomFromText('POINT(-71.322881 -29.971611)', 4326   )),
       (17,'Panda', 'TRUE', '+1234567', 'valparaiso', 'panda@gmail.com', '12235564-0',ST_GeomFromText('POINT(-71.650387 -33.048961)', 4326  )),
       (18,'Pardo', 'TRUE', '+1234567', 'temuco', 'pardo@gmail.com', '18235464-0',ST_GeomFromText('POINT(-72.630037 -38.732503)', 4326   )),
       (19,'Polar', 'TRUE', '+1234567', 'frutillar', 'polarparapresidente@gmail.com', '19225564-0', ST_GeomFromText('POINT(-73.052353 -41.121209)', 4326  )),
       (20,'Elmer', 'TRUE', '+1234567', 'antofagasta', 'elmer@gmail.com', '11243264-0',ST_GeomFromText('POINT(-70.390717 -23.606989)' , 4326  ));
       

INSERT INTO Institucion(id,nombre,direccion,telefono,dominio)
VALUES(1,'todosxchile','calle real 1234','223434','@todosxchile.cl'),
	(2,'sos','calle falsa 4567','223434','@sos.cl'),
      (3,'helpus','calle existente 7890','223434','@helpus.cl'),
      (4,'notteleton','calle sin salida 0000','223434','@notteleton.cl'),
      (5,'tetcho','calle los santos 0201','223434','@tetcho.cl');
             
INSERT INTO Emergencia(id,titulo,direccion,descripcion,id_institucion,activo, ubicacion)
VALUES(1,'Terremoto 9.5','Antofagasta','Cientos de hogares afectados','5', TRUE, ST_GeomFromText('POINT(-70.387154 -23.633290)' , 4326 )),
      (2,'Incendio forestal','Cerro San Cristobal','Incendio a un lado del zoologico','2', FALSE,ST_GeomFromText('POINT(-70.630222 -33.420470)', 4326  )),
      (3,'Aluvion','Atacama','muchos escombros y barro','3', TRUE,ST_GeomFromText('POINT(-69.099664 -26.081048)' , 4326  )),
      (4,'Tsunami','Constitucion','destruccion total','4', TRUE, ST_GeomFromText('POINT(-72.416268 -35.318228)' , 4326  )),
      (5,'Incendio forestal','La Araucania','miles de hectareas afectadas','1', TRUE,ST_GeomFromText('POINT(-71.921069 -38.675047)', 4326  )),
      (6,'Inundacion','Valdivia','perdida total','1', TRUE,ST_GeomFromText('POINT(-73.208392 -39.819949)' , 4326  )),
      (7,'Erupcion volcanica','Villa Rica','lava volcanica por todas partes','2', TRUE,ST_GeomFromText('POINT(-72.226159 -39.276256)' , 4326 )),
      (8,'Avalancha','Farellones','personas desaparecisas ','3', TRUE,ST_GeomFromText('POINT(-70.245745 -33.332637)', 4326  )),
      (9,'Tormenta','Region Metropolitana','levantamiento de techumbre','4', TRUE, ST_GeomFromText('POINT(-70.882984 -33.295563)', 4326 ) ),
      (10,'Tornado','Puerto Montt','destruccion muelle y botes','5', TRUE, ST_GeomFromText('POINT(-72.939739 -41.472780)', 4326   )  );

INSERT INTO Habilidad(id,nombreH,descripcion)
VALUES(1,'Habilidad 1','Todo lo relacionado con construccion'),
      (2,'Habilidad 2','calmar y controlar personas'),
      (3,'Habilidad 3','organizar y repartir alimentos'),
      (4,'Habilidad 4','manejo de heridas y enfermedades'),
      (5,'Habilidad 5','liderazgo y proactividad');
     
INSERT INTO Eme_habilidad(id,id_habilidad,id_emergencia)
VALUES(1,1,1),
      (2,2,4),
      (3,3,5),
      (4,4,3),
      (5,5,2),
      (6,5,6),
      (7,4,7),
      (8,3,8),
      (9,4,9),
      (10,1,10),
      (11,1,1),
      (12,2,2),
      (13,3,3),
      (14,4,4),
      (15,5,5),
      (16,3,6),
      (17,2,7),
      (18,1,8),
      (19,4,9),
      (20,5,10);
      
     
INSERT INTO Estado_tarea(id,estado)
VALUES (1,'aceptar'),
       (2,'rechazar'),
	   (3,'cancelar'),
	   (4,'terminar');

INSERT INTO Tarea( id,titulo ,descripcion,cant_voluntarios,id_estado,id_emergencia)
VALUES(1,'Buscar personas','Busqueda de personas desaparecidad',10, 1, 1),
      (2,'Quitar escombros','Remover escombros de la emergencia',100, 2,2),
      (3,'Recontruir casas','Reconstruir casas dañadas',400, 3, 3),
      (4,'Limpiar calles','Quitar todo tipo de basura o deshecho',100, 4,4),
      (5,'Cocinar','Cocina comunitaria',10, 1, 5),
      (6,'Evacuar','Dirigir a las personas a una zona segura', 50, 2,6),
      (7,'Quitar Barro','Sacar barro de calles, casas',200, 3,7),
      (8,'Rescatar mascotas','Llevar a un lugar seguro a las mascotas',34,4,8),
      (9,'Realizar encuestas','Realizas catastros de personas afectadas',90,1,9),
      (10,'Repartir comida y aseo','distribuir alimentos y utilies de aseo',300,2,10);



INSERT INTO Tarea_Habilidad(id,id_tarea, id_eme_habilidad)
VALUES (1,1,10),
       (2,2,9),
       (3,3,8),
       (4,4,7),
       (5,5,6),
       (6,6,5),
       (7,7,4),
       (8,8,3),
       (9,9,2),
       (10,10,1),
       (11,10,10),
       (12,9,7),
       (13,8,8),
       (14,7,9),
       (15,6,6),
       (16,5,4),
       (17,4,5),
       (18,3,2),
       (19,2,3),
       (20,1,1);

INSERT INTO Vol_Habilidad(id,id_voluntario,id_habilidad)
VALUES (1,1,1),
       (2,2,2),
       (3,3,3),
       (4,4,4),
       (5,5,5),
       (6,6,5),
       (7,7,4),
       (8,8,3),
       (9,9,2),
       (10,10,1),
       (11,11,2),
       (12,12,3),
       (13,13,4),
       (14,14,5),
       (15,15,4),
       (16,16,3),
       (17,17,2),
       (18,18,1),
       (19,19,5),
       (20,20,2),
       (21,3,3),
       (22,15,4),
       (23,16,5),
       (24,20,1),
       (25,2,2),
       (26,18,4),
       (27,9,5),
       (28,17,3),
       (29,3,1),
       (30,8,2);

INSERT INTO Ranking(id,valor,id_tarea,id_voluntario)
VALUES (1,100,1,1),
       (2,100,2,2),
       (3,100,10,3),
       (4,100,5,4);


