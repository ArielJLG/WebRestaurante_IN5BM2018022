/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ariellopez.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByIdfacturas", query = "SELECT f FROM Facturas f WHERE f.idfacturas = :idfacturas")
    , @NamedQuery(name = "Facturas.findByDetalle", query = "SELECT f FROM Facturas f WHERE f.detalle = :detalle")
    , @NamedQuery(name = "Facturas.findByFechafactura", query = "SELECT f FROM Facturas f WHERE f.fechafactura = :fechafactura")
    , @NamedQuery(name = "Facturas.findByNit", query = "SELECT f FROM Facturas f WHERE f.nit = :nit")
    , @NamedQuery(name = "Facturas.findByTipodepago", query = "SELECT f FROM Facturas f WHERE f.tipodepago = :tipodepago")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacturas")
    private Integer idfacturas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafactura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipodepago")
    private String tipodepago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfacturas")
    private List<Detallefactura> detallefacturaList;
    @JoinColumn(name = "idclientes", referencedColumnName = "idclientes")
    @ManyToOne(optional = false)
    private Clientes idclientes;
    @JoinColumn(name = "idmesas", referencedColumnName = "idmesas")
    @ManyToOne(optional = false)
    private Mesas idmesas;
    @JoinColumn(name = "idmeseros", referencedColumnName = "idmeseros")
    @ManyToOne(optional = false)
    private Meseros idmeseros;

    public Facturas() {
    }

    public Facturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }

    public Facturas(Integer idfacturas, String detalle, Date fechafactura, String nit, String tipodepago) {
        this.idfacturas = idfacturas;
        this.detalle = detalle;
        this.fechafactura = fechafactura;
        this.nit = nit;
        this.tipodepago = tipodepago;
    }

    public Integer getIdfacturas() {
        return idfacturas;
    }

    public void setIdfacturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(String tipodepago) {
        this.tipodepago = tipodepago;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    public Clientes getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(Clientes idclientes) {
        this.idclientes = idclientes;
    }

    public Mesas getIdmesas() {
        return idmesas;
    }

    public void setIdmesas(Mesas idmesas) {
        this.idmesas = idmesas;
    }

    public Meseros getIdmeseros() {
        return idmeseros;
    }

    public void setIdmeseros(Meseros idmeseros) {
        this.idmeseros = idmeseros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturas != null ? idfacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idfacturas == null && other.idfacturas != null) || (this.idfacturas != null && !this.idfacturas.equals(other.idfacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Facturas[ idfacturas=" + idfacturas + " ]";
    }
    
}
