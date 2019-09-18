package com.ariellopez.entities;

import com.ariellopez.entities.Clientes;
import com.ariellopez.entities.Detallefactura;
import com.ariellopez.entities.Mesas;
import com.ariellopez.entities.Meseros;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Facturas.class)
public class Facturas_ { 

    public static volatile SingularAttribute<Facturas, Mesas> idmesas;
    public static volatile SingularAttribute<Facturas, String> tipodepago;
    public static volatile ListAttribute<Facturas, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Facturas, Date> fechafactura;
    public static volatile SingularAttribute<Facturas, String> nit;
    public static volatile SingularAttribute<Facturas, Meseros> idmeseros;
    public static volatile SingularAttribute<Facturas, Clientes> idclientes;
    public static volatile SingularAttribute<Facturas, Integer> idfacturas;
    public static volatile SingularAttribute<Facturas, String> detalle;

}