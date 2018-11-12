/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
    , @NamedQuery(name = "Consultation.findByIdC", query = "SELECT c FROM Consultation c WHERE c.idC = :idC")
    , @NamedQuery(name = "Consultation.findByDateC", query = "SELECT c FROM Consultation c WHERE c.dateC = :dateC")
    , @NamedQuery(name = "Consultation.findByHeureC", query = "SELECT c FROM Consultation c WHERE c.heureC = :heureC")
    , @NamedQuery(name = "Consultation.findByPrixC", query = "SELECT c FROM Consultation c WHERE c.prixC = :prixC")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdC")
    private Integer idC;
    @Column(name = "dateC")
    @Temporal(TemporalType.DATE)
    private Date dateC;
    @Column(name = "heureC")
    private Integer heureC;
    @Column(name = "prixC")
    private Integer prixC;
    @JoinTable(name = "pratique", joinColumns = {
        @JoinColumn(name = "idC", referencedColumnName = "IdC")}, inverseJoinColumns = {
        @JoinColumn(name = "IdS", referencedColumnName = "IdS")})
    @ManyToMany
    private Collection<Soin> soinCollection;
    @JoinColumn(name = "idV", referencedColumnName = "IdV")
    @ManyToOne(optional = false)
    private Veterinaire idV;
    @JoinColumn(name = "IdA", referencedColumnName = "IdA")
    @ManyToOne(optional = false)
    private Animal idA;

    public Consultation() {
    }

    public Consultation(Integer idC) {
        this.idC = idC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public Integer getHeureC() {
        return heureC;
    }

    public void setHeureC(Integer heureC) {
        this.heureC = heureC;
    }

    public Integer getPrixC() {
        return prixC;
    }

    public void setPrixC(Integer prixC) {
        this.prixC = prixC;
    }

    @XmlTransient
    public Collection<Soin> getSoinCollection() {
        return soinCollection;
    }

    public void setSoinCollection(Collection<Soin> soinCollection) {
        this.soinCollection = soinCollection;
    }

    public Veterinaire getIdV() {
        return idV;
    }

    public void setIdV(Veterinaire idV) {
        this.idV = idV;
    }

    public Animal getIdA() {
        return idA;
    }

    public void setIdA(Animal idA) {
        this.idA = idA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Consultation[ idC=" + idC + " ]";
    }
    
}
