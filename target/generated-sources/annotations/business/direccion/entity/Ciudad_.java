package business.direccion.entity;

import business.direccion.entity.Barrio;
import business.direccion.entity.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, Departamento> idDepartamento;
    public static volatile SingularAttribute<Ciudad, Integer> estado;
    public static volatile SingularAttribute<Ciudad, String> ciudad;
    public static volatile CollectionAttribute<Ciudad, Barrio> barrioCollection;
    public static volatile SingularAttribute<Ciudad, Integer> idCiudad;

}