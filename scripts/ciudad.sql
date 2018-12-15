CREATE TABLE `ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCiudad`),
  KEY `FK_ciudad_idDepartamento` (`idDepartamento`),
  CONSTRAINT `FK_ciudad_idDepartamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `contrato` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fec_actualizacion` date DEFAULT NULL,
  `fec_registro` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nro_documento` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tip_documento` varchar(255) DEFAULT NULL,
  `id_barrio` int(11) DEFAULT NULL,
  `id_usu_actualizacion` int(11) DEFAULT NULL,
  `id_usu_registro` int(11) DEFAULT NULL,
  `id_zona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FK_cliente_id_barrio` (`id_barrio`),
  KEY `FK_cliente_id_zona` (`id_zona`),
  KEY `FK_cliente_id_usu_actualizacion` (`id_usu_actualizacion`),
  KEY `FK_cliente_id_usu_registro` (`id_usu_registro`),
  CONSTRAINT `FK_cliente_id_barrio` FOREIGN KEY (`id_barrio`) REFERENCES `barrio` (`idBarrio`),
  CONSTRAINT `FK_cliente_id_usu_actualizacion` FOREIGN KEY (`id_usu_actualizacion`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `FK_cliente_id_usu_registro` FOREIGN KEY (`id_usu_registro`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `FK_cliente_id_zona` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`idZona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
SELECT * FROM mitv.ciudad;
