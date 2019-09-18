/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ariellopez.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "platos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platos.findAll", query = "SELECT p FROM Platos p")
    , @NamedQuery(name = "Platos.findByIdplatos", query = "SELECT p FROM Platos p WHERE p.idplatos = :idplatos")
    , @NamedQuery(name = "Platos.findByDescripcionPlatos", query = "SELECT p FROM Platos p WHERE p.descripcionPlatos = :descripcionPlatos")
    , @NamedQuery(name = "Platos.findByPrecioPlato", query = "SELECT p FROM Platos p WHERE p.precioPlato = :precioPlato")})
public class Platos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplatos")
    private Integer idplatos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcionPlatos")
    private String descripcionPlatos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioPlato")
    private double precioPlato;
    @JoinColumn(name = "iddetallefactura", referencedColumnName = "iddetallefactura")
    @ManyToOne(optional = false)
    private Detallefactura iddetallefactura;

    public Platos() {
    }

    public Platos(Integer idplatos) {
        this.idplatos = idplatos;
    }

    public Platos(Integer idplatos, String descripcionPlatos, double precioPlato) {
        this.idplatos = idplatos;
        this.descripcionPlatos = descripcionPlatos;
        this.precioPlato = precioPlato;
    }

    public Integer getIdplatos() {
        return idplatos;
    }

    public void setIdplatos(Integer idplatos) {
        this.idplatos = idplatos;
    }

    public String getDescripcionPlatos() {
        return descripcionPlatos;
    }

    public void setDescripcionPlatos(String descripcionPlatos) {
        this.descripcionPlatos = descripcionPlatos;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public Detallefactura getIddetallefactura() {
        return iddetallefactura;
    }

    public void setIddetallefactura(Detallefactura iddetallefactura) {
        this.iddetallefactura = iddetallefactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplatos != null ? idplatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platos)) {
            return false;
        }
        Platos other = (Platos) object;
        if ((this.idplatos == null && other.idplatos != null) || (this.idplatos != null && !this.idplatos.equals(other.idplatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Platos[ idplatos=" + idplatos + " ]";
    }
    
}
