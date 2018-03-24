package business.funcionario.entity;

import business.funcionario.entity.FuncionarioHorario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Date> entradaAlmuerzo;
    public static volatile CollectionAttribute<Horario, FuncionarioHorario> funcionarioHorarioCollection;
    public static volatile SingularAttribute<Horario, Integer> idHorario;
    public static volatile SingularAttribute<Horario, Date> entrada;
    public static volatile SingularAttribute<Horario, Date> salida;
    public static volatile SingularAttribute<Horario, Date> salidaAlmuerzo;

}