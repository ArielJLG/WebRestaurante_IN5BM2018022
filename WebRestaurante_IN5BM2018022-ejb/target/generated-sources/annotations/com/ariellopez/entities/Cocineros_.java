package com.ariellopez.entities;

import com.ariellopez.entities.Detallefactura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-17T10:52:36")
@StaticMetamodel(Cocineros.class)
public class Cocineros_ { 

    public static volatile SingularAttribute<Cocineros, String> apellidos;
    public static volatile ListAttribute<Cocineros, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Cocineros, Integer> idcocineros;
    public static volatile SingularAttribute<Cocineros, Double> sueldo;
    public static volatile SingularAttribute<Cocineros, String> sexo;
    public static volatile SingularAttribute<Cocineros, String> especialidad;
    public static volatile SingularAttribute<Cocineros, String> nombres;

}