package business.direccion.entity;

import business.direccion.entity.ZonaBarrio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T09:29:49")
@StaticMetamodel(Zona.class)
public class Zona_ { 

    public static volatile SingularAttribute<Zona, String> zona;
    public static volatile SingularAttribute<Zona, Integer> estado;
    public static volatile SingularAttribute<Zona, Integer> idZona;
    public static volatile CollectionAttribute<Zona, ZonaBarrio> zonaBarrioCollection;

}