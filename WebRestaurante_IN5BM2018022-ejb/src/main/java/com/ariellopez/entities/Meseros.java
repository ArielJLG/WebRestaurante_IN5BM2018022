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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meseros.findAll", query = "SELECT m FROM Meseros m")
    , @NamedQuery(name = "Meseros.findByIdmeseros", query = "SELECT m FROM Meseros m WHERE m.idmeseros = :idmeseros")
    , @NamedQuery(name = "Meseros.findByNombres", query = "SELECT m FROM Meseros m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Meseros.findByApellidos", query = "SELECT m FROM Meseros m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Meseros.findBySexo", query = "SELECT m FROM Meseros m WHERE m.sexo = :sexo")
    , @NamedQuery(name = "Meseros.findBySalario", query = "SELECT m FROM Meseros m WHERE m.salario = :salario")})
public class Meseros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmeseros")
    private Integer idmeseros;
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
    @Column(name = "salario")
    private double salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmeseros")
    private List<Facturas> facturasList;

    public Meseros() {
    }

    public Meseros(Integer idmeseros) {
        this.idmeseros = idmeseros;
    }

    public Meseros(Integer idmeseros, String nombres, String apellidos, String sexo, double salario) {
        this.idmeseros = idmeseros;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.salario = salario;
    }

    public Integer getIdmeseros() {
        return idmeseros;
    }

    public void setIdmeseros(Integer idmeseros) {
        this.idmeseros = idmeseros;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmeseros != null ? idmeseros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meseros)) {
            return false;
        }
        Meseros other = (Meseros) object;
        if ((this.idmeseros == null && other.idmeseros != null) || (this.idmeseros != null && !this.idmeseros.equals(other.idmeseros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Meseros[ idmeseros=" + idmeseros + " ]";
    }
    
}
