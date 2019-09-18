/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ariellopez.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "cocineros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cocineros.findAll", query = "SELECT c FROM Cocineros c")
    , @NamedQuery(name = "Cocineros.findByIdcocineros", query = "SELECT c FROM Cocineros c WHERE c.idcocineros = :idcocineros")
    , @NamedQuery(name = "Cocineros.findByNombres", query = "SELECT c FROM Cocineros c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Cocineros.findByApellidos", query = "SELECT c FROM Cocineros c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cocineros.findBySexo", query = "SELECT c FROM Cocineros c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Cocineros.findBySueldo", query = "SELECT c FROM Cocineros c WHERE c.sueldo = :sueldo")
    , @NamedQuery(name = "Cocineros.findByEspecialidad", query = "SELECT c FROM Cocineros c WHERE c.especialidad = :especialidad")})
public class Cocineros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcocineros")
    private Integer idcocineros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private double sueldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcocineros")
    private List<Detallefactura> detallefacturaList;

    public Cocineros() {
    }

    public Cocineros(Integer idcocineros) {
        this.idcocineros = idcocineros;
    }

    public Cocineros(Integer idcocineros, String nombres, String apellidos, String sexo, double sueldo, String especialidad) {
        this.idcocineros = idcocineros;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public Integer getIdcocineros() {
        return idcocineros;
    }

    public void setIdcocineros(Integer idcocineros) {
        this.idcocineros = idcocineros;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcocineros != null ? idcocineros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cocineros)) {
            return false;
        }
        Cocineros other = (Cocineros) object;
        if ((this.idcocineros == null && other.idcocineros != null) || (this.idcocineros != null && !this.idcocineros.equals(other.idcocineros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Cocineros[ idcocineros=" + idcocineros + " ]";
    }
    
}
