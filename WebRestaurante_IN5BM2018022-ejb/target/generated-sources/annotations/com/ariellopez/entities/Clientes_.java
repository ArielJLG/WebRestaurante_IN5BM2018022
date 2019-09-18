package com.ariellopez.entities;

import com.ariellopez.entities.Facturas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> apellidos;
    public static volatile SingularAttribute<Clientes, String> tipodecliente;
    public static volatile SingularAttribute<Clientes, Integer> idclientes;
    public static volatile ListAttribute<Clientes, Facturas> facturasList;
    public static volatile SingularAttribute<Clientes, String> nombres;

}