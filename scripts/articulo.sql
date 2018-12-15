CREATE TABLE `articulo` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fec_insercion` date DEFAULT NULL,
  `fec_modificacion` date DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `usu_insercion` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idArticulo`),
  KEY `FK_articulo_usu_insercion` (`usu_insercion`),
  KEY `FK_articulo_usu_modificacion` (`usu_modificacion`),
  CONSTRAINT `FK_articulo_usu_insercion` FOREIGN KEY (`usu_insercion`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `FK_articulo_usu_modificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SELECT * FROM mitv.servicio;
