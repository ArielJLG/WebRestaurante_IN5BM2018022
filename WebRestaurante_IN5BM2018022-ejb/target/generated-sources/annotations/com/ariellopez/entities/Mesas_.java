package com.ariellopez.entities;

import com.ariellopez.entities.Areas;
import com.ariellopez.entities.Facturas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Mesas.class)
public class Mesas_ { 

    public static volatile SingularAttribute<Mesas, Integer> idmesas;
    public static volatile SingularAttribute<Mesas, Areas> idareas;
    public static volatile SingularAttribute<Mesas, Integer> numcomensales;
    public static volatile SingularAttribute<Mesas, String> descripcionmesas;
    public static volatile ListAttribute<Mesas, Facturas> facturasList;

}