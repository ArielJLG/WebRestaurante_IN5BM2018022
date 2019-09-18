package com.ariellopez.entities;

import com.ariellopez.entities.Mesas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Areas.class)
public class Areas_ { 

    public static volatile SingularAttribute<Areas, String> descripcion;
    public static volatile SingularAttribute<Areas, Integer> idareas;
    public static volatile SingularAttribute<Areas, Integer> cantidadpersonas;
    public static volatile ListAttribute<Areas, Mesas> mesasList;

}