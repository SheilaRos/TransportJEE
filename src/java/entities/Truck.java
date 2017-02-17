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
@Table(name = "truck")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Truck.findAll", query = "SELECT t FROM Truck t")
    , @NamedQuery(name = "Truck.findByIdtruck", query = "SELECT t FROM Truck t WHERE t.idtruck = :idtruck")
    , @NamedQuery(name = "Truck.findByModel", query = "SELECT t FROM Truck t WHERE t.model = :model")
    , @NamedQuery(name = "Truck.findByCapacity", query = "SELECT t FROM Truck t WHERE t.capacity = :capacity")})
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "idtruck")
    private String idtruck;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @JoinColumn(name = "driver", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Truckdriver driver;

    public Truck() {
    }

    public Truck(String idtruck) {
        this.idtruck = idtruck;
    }

    public Truck(String idtruck, String model, int capacity) {
        this.idtruck = idtruck;
        this.model = model;
        this.capacity = capacity;
    }

    public String getIdtruck() {
        return idtruck;
    }

    public void setIdtruck(String idtruck) {
        this.idtruck = idtruck;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Truckdriver getDriver() {
        return driver;
    }

    public void setDriver(Truckdriver driver) {
        this.driver = driver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtruck != null ? idtruck.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Truck)) {
            return false;
        }
        Truck other = (Truck) object;
        if ((this.idtruck == null && other.idtruck != null) || (this.idtruck != null && !this.idtruck.equals(other.idtruck))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Truck[ idtruck=" + idtruck + " ]";
    }
    
}
