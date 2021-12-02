/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author poramet
 */
@Entity
@Table(name = "VACCINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaccine.findAll", query = "SELECT v FROM Vaccine v"),
    @NamedQuery(name = "Vaccine.findById", query = "SELECT v FROM Vaccine v WHERE v.id = :id"),
    @NamedQuery(name = "Vaccine.findByDose", query = "SELECT v FROM Vaccine v WHERE v.dose = :dose"),
    @NamedQuery(name = "Vaccine.findByVaccine1", query = "SELECT v FROM Vaccine v WHERE v.vaccine1 = :vaccine1"),
    @NamedQuery(name = "Vaccine.findByVaccine2", query = "SELECT v FROM Vaccine v WHERE v.vaccine2 = :vaccine2"),
    @NamedQuery(name = "Vaccine.findByVaccine3", query = "SELECT v FROM Vaccine v WHERE v.vaccine3 = :vaccine3")})
public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DOSE")
    private Integer dose;
    @Size(max = 20)
    @Column(name = "VACCINE1")
    private String vaccine1;
    @Size(max = 20)
    @Column(name = "VACCINE2")
    private String vaccine2;
    @Size(max = 20)
    @Column(name = "VACCINE3")
    private String vaccine3;

    public Vaccine() {
    }

    public Vaccine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getVaccine1() {
        return vaccine1;
    }

    public void setVaccine1(String vaccine1) {
        this.vaccine1 = vaccine1;
    }

    public String getVaccine2() {
        return vaccine2;
    }

    public void setVaccine2(String vaccine2) {
        this.vaccine2 = vaccine2;
    }

    public String getVaccine3() {
        return vaccine3;
    }

    public void setVaccine3(String vaccine3) {
        this.vaccine3 = vaccine3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaccine)) {
            return false;
        }
        Vaccine other = (Vaccine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vaccine[ id=" + id + " ]";
    }
    
}
