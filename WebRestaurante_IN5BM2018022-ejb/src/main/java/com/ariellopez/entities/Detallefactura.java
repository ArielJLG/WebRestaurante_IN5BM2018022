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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d")
    , @NamedQuery(name = "Detallefactura.findByIddetallefactura", query = "SELECT d FROM Detallefactura d WHERE d.iddetallefactura = :iddetallefactura")
    , @NamedQuery(name = "Detallefactura.findByCantidad", query = "SELECT d FROM Detallefactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallefactura.findByPrecioventa", query = "SELECT d FROM Detallefactura d WHERE d.precioventa = :precioventa")
    , @NamedQuery(name = "Detallefactura.findByTotalventa", query = "SELECT d FROM Detallefactura d WHERE d.totalventa = :totalventa")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallefactura")
    private Integer iddetallefactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioventa")
    private double precioventa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalventa")
    private Double totalventa;
    @JoinColumn(name = "idcocineros", referencedColumnName = "idcocineros")
    @ManyToOne(optional = false)
    private Cocineros idcocineros;
    @JoinColumn(name = "idfacturas", referencedColumnName = "idfacturas")
    @ManyToOne(optional = false)
    private Facturas idfacturas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddetallefactura")
    private List<Platos> platosList;

    public Detallefactura() {
    }

    public Detallefactura(Integer iddetallefactura) {
        this.iddetallefactura = iddetallefactura;
    }

    public Detallefactura(Integer iddetallefactura, int cantidad, double precioventa) {
        this.iddetallefactura = iddetallefactura;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
    }

    public Integer getIddetallefactura() {
        return iddetallefactura;
    }

    public void setIddetallefactura(Integer iddetallefactura) {
        this.iddetallefactura = iddetallefactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public Double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(Double totalventa) {
        this.totalventa = totalventa;
    }

    public Cocineros getIdcocineros() {
        return idcocineros;
    }

    public void setIdcocineros(Cocineros idcocineros) {
        this.idcocineros = idcocineros;
    }

    public Facturas getIdfacturas() {
        return idfacturas;
    }

    public void setIdfacturas(Facturas idfacturas) {
        this.idfacturas = idfacturas;
    }

    @XmlTransient
    public List<Platos> getPlatosList() {
        return platosList;
    }

    public void setPlatosList(List<Platos> platosList) {
        this.platosList = platosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallefactura != null ? iddetallefactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.iddetallefactura == null && other.iddetallefactura != null) || (this.iddetallefactura != null && !this.iddetallefactura.equals(other.iddetallefactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Detallefactura[ iddetallefactura=" + iddetallefactura + " ]";
    }
    
}
