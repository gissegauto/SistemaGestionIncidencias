CREATE TABLE `barrio` (
  `idBarrio` int(11) NOT NULL AUTO_INCREMENT,
  `barrio` varchar(255) DEFAULT NULL,
  `idCiudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBarrio`),
  KEY `FK_barrio_idCiudad` (`idCiudad`),
  CONSTRAINT `FK_barrio_idCiudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

