/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author dam
 */
@Entity
@Table(name = "truckdriver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Truckdriver.findAll", query = "SELECT t FROM Truckdriver t")
    , @NamedQuery(name = "Truckdriver.findByDni", query = "SELECT t FROM Truckdriver t WHERE t.dni = :dni")
    , @NamedQuery(name = "Truckdriver.findByName", query = "SELECT t FROM Truckdriver t WHERE t.name = :name")
    , @NamedQuery(name = "Truckdriver.findByPhone", query = "SELECT t FROM Truckdriver t WHERE t.phone = :phone")
    , @NamedQuery(name = "Truckdriver.findBySalary", query = "SELECT t FROM Truckdriver t WHERE t.salary = :salary")})
public class Truckdriver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Collection<Package> packageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Collection<Truck> truckCollection;

    public Truckdriver() {
    }

    public Truckdriver(String dni) {
        this.dni = dni;
    }

    public Truckdriver(String dni, String name, String phone, double salary) {
        this.dni = dni;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @XmlTransient
    public Collection<Package> getPackageCollection() {
        return packageCollection;
    }

    public void setPackageCollection(Collection<Package> packageCollection) {
        this.packageCollection = packageCollection;
    }

    @XmlTransient
    public Collection<Truck> getTruckCollection() {
        return truckCollection;
    }

    public void setTruckCollection(Collection<Truck> truckCollection) {
        this.truckCollection = truckCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Truckdriver)) {
            return false;
        }
        Truckdriver other = (Truckdriver) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Truckdriver[ dni=" + dni + " ]";
    }
    
}
