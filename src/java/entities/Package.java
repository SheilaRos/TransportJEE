/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author dam
 */
@Entity
@Table(name = "package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p")
    , @NamedQuery(name = "Package.findByIdpackage", query = "SELECT p FROM Package p WHERE p.idpackage = :idpackage")
    , @NamedQuery(name = "Package.findByCustomer", query = "SELECT p FROM Package p WHERE p.customer = :customer")})
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpackage")
    private Integer idpackage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "customer")
    private String customer;
    @JoinColumn(name = "driver", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Truckdriver driver;
    @JoinColumn(name = "city", referencedColumnName = "postalcode")
    @ManyToOne(optional = false)
    private City city;

    public Package() {
    }

    public Package(Integer idpackage) {
        this.idpackage = idpackage;
    }

    public Package(Integer idpackage, String customer) {
        this.idpackage = idpackage;
        this.customer = customer;
    }

    public Integer getIdpackage() {
        return idpackage;
    }

    public void setIdpackage(Integer idpackage) {
        this.idpackage = idpackage;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Truckdriver getDriver() {
        return driver;
    }

    public void setDriver(Truckdriver driver) {
        this.driver = driver;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpackage != null ? idpackage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Package)) {
            return false;
        }
        Package other = (Package) object;
        if ((this.idpackage == null && other.idpackage != null) || (this.idpackage != null && !this.idpackage.equals(other.idpackage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Package[ idpackage=" + idpackage + " ]";
    }
    
}
