/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "soin")
@NamedQueries({
    @NamedQuery(name = "Soin.findAll", query = "SELECT s FROM Soin s")
    , @NamedQuery(name = "Soin.findByIdS", query = "SELECT s FROM Soin s WHERE s.idS = :idS")
    , @NamedQuery(name = "Soin.findByNomS", query = "SELECT s FROM Soin s WHERE s.nomS = :nomS")
    , @NamedQuery(name = "Soin.findByDureeS", query = "SELECT s FROM Soin s WHERE s.dureeS = :dureeS")
    , @NamedQuery(name = "Soin.findByTarifS", query = "SELECT s FROM Soin s WHERE s.tarifS = :tarifS")})
public class Soin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdS")
    private Integer idS;
    @Size(max = 30)
    @Column(name = "nomS")
    private String nomS;
    @Column(name = "dureeS")
    private Integer dureeS;
    @Column(name = "tarifS")
    private Integer tarifS;
    @ManyToMany(mappedBy = "soinCollection")
    private Collection<Consultation> consultationCollection;

    public Soin() {
    }

    public Soin(Integer idS) {
        this.idS = idS;
    }

    public Integer getIdS() {
        return idS;
    }

    public void setIdS(Integer idS) {
        this.idS = idS;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public Integer getDureeS() {
        return dureeS;
    }

    public void setDureeS(Integer dureeS) {
        this.dureeS = dureeS;
    }

    public Integer getTarifS() {
        return tarifS;
    }

    public void setTarifS(Integer tarifS) {
        this.tarifS = tarifS;
    }

    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idS != null ? idS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soin)) {
            return false;
        }
        Soin other = (Soin) object;
        if ((this.idS == null && other.idS != null) || (this.idS != null && !this.idS.equals(other.idS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Soin[ idS=" + idS + " ]";
    }
    
}