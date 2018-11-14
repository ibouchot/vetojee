/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "pratique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pratique.findAll", query = "SELECT p FROM Pratique p")
    , @NamedQuery(name = "Pratique.findByIdP", query = "SELECT p FROM Pratique p WHERE p.idP = :idP")})
public class Pratique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idP")
    private Integer idP;
    @JoinColumn(name = "idC", referencedColumnName = "IdC")
    @ManyToOne(optional = false)
    private Consultation idC;
    @JoinColumn(name = "IdS", referencedColumnName = "IdS")
    @ManyToOne(optional = false)
    private Soin idS;

    public Pratique() {
    }

    public Pratique(Integer idP) {
        this.idP = idP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public Consultation getIdC() {
        return idC;
    }

    public void setIdC(Consultation idC) {
        this.idC = idC;
    }

    public Soin getIdS() {
        return idS;
    }

    public void setIdS(Soin idS) {
        this.idS = idS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pratique)) {
            return false;
        }
        Pratique other = (Pratique) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Pratique[ idP=" + idP + " ]";
    }
    
}
