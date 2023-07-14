package entidades;

import entidades.Reunion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-13T16:45:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sala.class)
public class Sala_ { 

    public static volatile SingularAttribute<Sala, String> descripcion;
    public static volatile ListAttribute<Sala, Reunion> reuniones;
    public static volatile SingularAttribute<Sala, String> id;
    public static volatile SingularAttribute<Sala, Integer> capacidad;

}