package com.ariellopez.entities;

import com.ariellopez.entities.Cocineros;
import com.ariellopez.entities.Facturas;
import com.ariellopez.entities.Platos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile ListAttribute<Detallefactura, Platos> platosList;
    public static volatile SingularAttribute<Detallefactura, Cocineros> idcocineros;
    public static volatile SingularAttribute<Detallefactura, Double> totalventa;
    public static volatile SingularAttribute<Detallefactura, Integer> cantidad;
    public static volatile SingularAttribute<Detallefactura, Double> precioventa;
    public static volatile SingularAttribute<Detallefactura, Integer> iddetallefactura;
    public static volatile SingularAttribute<Detallefactura, Facturas> idfacturas;

}