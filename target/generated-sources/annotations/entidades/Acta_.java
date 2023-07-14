package entidades;

import entidades.Reunion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-13T16:45:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Acta.class)
public class Acta_ { 

    public static volatile SingularAttribute<Acta, String> contenido;
    public static volatile SingularAttribute<Acta, Reunion> reunion;
    public static volatile SingularAttribute<Acta, Integer> id;

}