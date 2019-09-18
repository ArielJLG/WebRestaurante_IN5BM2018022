package com.ariellopez.entities;

import com.ariellopez.entities.Facturas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Meseros.class)
public class Meseros_ { 

    public static volatile SingularAttribute<Meseros, String> apellidos;
    public static volatile SingularAttribute<Meseros, Double> salario;
    public static volatile SingularAttribute<Meseros, Integer> idmeseros;
    public static volatile SingularAttribute<Meseros, String> sexo;
    public static volatile ListAttribute<Meseros, Facturas> facturasList;
    public static volatile SingularAttribute<Meseros, String> nombres;

}