package business.usuario.entity;

import business.usuario.entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-05T13:54:26")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Rol> idrol;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, String> username;

}