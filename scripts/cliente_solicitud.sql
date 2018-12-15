CREATE TABLE `cliente_solicitud` (
  `idClienteSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idSolicitudConexion` int(11) DEFAULT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`idClienteSolicitud`),
  KEY `FK_cliente_solicitud_idCliente` (`idCliente`),
  KEY `FK_cliente_solicitud_idFuncionario` (`idFuncionario`),
  KEY `FK_cliente_solicitud_idSolicitudConexion` (`idSolicitudConexion`),
  CONSTRAINT `FK_cliente_solicitud_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_cliente_solicitud_idFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`),
  CONSTRAINT `FK_cliente_solicitud_idSolicitudConexion` FOREIGN KEY (`idSolicitudConexion`) REFERENCES `solicitud_conexion` (`idSolicitudConexion`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
SELECT * FROM mitv.cliente_solicitud;
