package business.direccion.entity;

import business.direccion.entity.Ciudad;
import business.direccion.entity.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-05T13:54:26")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile SingularAttribute<Departamento, Integer> estado;
    public static volatile SingularAttribute<Departamento, Pais> idPais;
    public static volatile CollectionAttribute<Departamento, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Departamento, String> departamento;

}