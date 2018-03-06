package business.usuario.entity;

import business.usuario.entity.RolPantalla;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-05T13:54:26")
@StaticMetamodel(Pantalla.class)
public class Pantalla_ { 

    public static volatile SingularAttribute<Pantalla, String> descripcion;
    public static volatile SingularAttribute<Pantalla, Integer> idpantalla;
    public static volatile CollectionAttribute<Pantalla, RolPantalla> rolPantallaCollection;
    public static volatile SingularAttribute<Pantalla, String> codigoPantalla;

}