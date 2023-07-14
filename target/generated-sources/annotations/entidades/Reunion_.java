package entidades;

import entidades.Acta;
import entidades.Persona;
import entidades.Sala;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-13T16:45:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Reunion.class)
public class Reunion_ { 

    public static volatile SingularAttribute<Reunion, LocalDateTime> fecha;
    public static volatile SingularAttribute<Reunion, Acta> acta;
    public static volatile SingularAttribute<Reunion, Sala> sala;
    public static volatile SingularAttribute<Reunion, String> asunto;
    public static volatile SingularAttribute<Reunion, Integer> id;
    public static volatile SetAttribute<Reunion, Persona> participantes;

}