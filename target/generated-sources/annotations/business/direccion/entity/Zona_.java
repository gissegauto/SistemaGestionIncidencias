package business.direccion.entity;

import business.cliente.entity.Cliente;
import business.direccion.entity.ZonaBarrio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(Zona.class)
public class Zona_ { 

    public static volatile SingularAttribute<Zona, String> zona;
    public static volatile SingularAttribute<Zona, Integer> estado;
    public static volatile SingularAttribute<Zona, Integer> idZona;
    public static volatile CollectionAttribute<Zona, ZonaBarrio> zonaBarrioCollection;
    public static volatile CollectionAttribute<Zona, Cliente> clienteCollection;

}