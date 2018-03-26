package business.direccion.entity;

import business.direccion.entity.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T09:29:49")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile CollectionAttribute<Pais, Departamento> departamentoCollection;
    public static volatile SingularAttribute<Pais, Integer> estado;
    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile SingularAttribute<Pais, String> nombre;

}