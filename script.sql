DROP DATABASE `mitv`;
-- CREAR BASE DE DATOS
create database mitv;


-- CREAR ROL ADMINISTRADOR
INSERT INTO `mitv`.`rol` (`idrol`, `descripcion`, `estado`) VALUES ('1', 'Administrador', 'Activo');


select * from mitv.rol;

--- CREAR USUARIO ADMIN
INSERT INTO `mitv`.`usuario` (`idusuario`, `estado`, `password`, `username`, `id_rol`) VALUES ('1', 'Activo', '21232f297a57a5a743894a0e4a801fc3', 'admin', '1');


select * from mitv.usuario;

-- CREAR PAIS 
INSERT INTO `mitv`.`pais` (`idPais`, `estado`, `nombre`) VALUES ('1', 'Activo', 'Paraguay');

-- CREAR DEPARTAMENTO 
INSERT INTO `mitv`.`departamento` (`idDepartamento`, `departamento`, `estado`, `idPais`) VALUES ('4', 'Guairá', 'Activo', '1');

-- CREAR CIUDAD 
INSERT INTO `mitv`.`ciudad` (`idCiudad`, `ciudad`, `estado`, `idDepartamento`) VALUES ('1', 'M. J. Troche', 'Activo', '4');


-- CREAR BARRIOS
INSERT INTO `mitv`.`barrio` (`idBarrio`, `barrio`, `idCiudad`) VALUES ('1', 'Centro', '1');
INSERT INTO `mitv`.`barrio` (`idBarrio`, `barrio`, `idCiudad`) VALUES ('2', 'Loma Clavel', '1');

SELECT * FROM mitv.barrio;





