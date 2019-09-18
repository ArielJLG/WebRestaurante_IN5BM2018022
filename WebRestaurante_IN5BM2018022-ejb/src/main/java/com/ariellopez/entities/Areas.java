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
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")
    , @NamedQuery(name = "Areas.findByIdareas", query = "SELECT a FROM Areas a WHERE a.idareas = :idareas")
    , @NamedQuery(name = "Areas.findByDescripcion", query = "SELECT a FROM Areas a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Areas.findByCantidadpersonas", query = "SELECT a FROM Areas a WHERE a.cantidadpersonas = :cantidadpersonas")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idareas")
    private Integer idareas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadpersonas")
    private int cantidadpersonas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idareas")
    private List<Mesas> mesasList;

    public Areas() {
    }

    public Areas(Integer idareas) {
        this.idareas = idareas;
    }

    public Areas(Integer idareas, String descripcion, int cantidadpersonas) {
        this.idareas = idareas;
        this.descripcion = descripcion;
        this.cantidadpersonas = cantidadpersonas;
    }

    public Integer getIdareas() {
        return idareas;
    }

    public void setIdareas(Integer idareas) {
        this.idareas = idareas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(int cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    @XmlTransient
    public List<Mesas> getMesasList() {
        return mesasList;
    }

    public void setMesasList(List<Mesas> mesasList) {
        this.mesasList = mesasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idareas != null ? idareas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.idareas == null && other.idareas != null) || (this.idareas != null && !this.idareas.equals(other.idareas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ariellopez.entities.Areas[ idareas=" + idareas + " ]";
    }
    
}
