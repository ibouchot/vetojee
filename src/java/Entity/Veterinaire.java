/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "veterinaire")
@NamedQueries({
    @NamedQuery(name = "Veterinaire.findAll", query = "SELECT v FROM Veterinaire v")
    , @NamedQuery(name = "Veterinaire.findByIdV", query = "SELECT v FROM Veterinaire v WHERE v.idV = :idV")
    , @NamedQuery(name = "Veterinaire.findByNomV", query = "SELECT v FROM Veterinaire v WHERE v.nomV = :nomV")
    , @NamedQuery(name = "Veterinaire.findByPrenomV", query = "SELECT v FROM Veterinaire v WHERE v.prenomV = :prenomV")})
public class Veterinaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdV")
    private Integer idV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nomV")
    private String nomV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "prenomV")
    private String prenomV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idV")
    private Collection<Consultation> consultationCollection;

    public Veterinaire() {
    }

    public Veterinaire(Integer idV) {
        this.idV = idV;
    }

    public Veterinaire(Integer idV, String nomV, String prenomV) {
        this.idV = idV;
        this.nomV = nomV;
        this.prenomV = prenomV;
    }

    public Integer getIdV() {
        return idV;
    }

    public void setIdV(Integer idV) {
        this.idV = idV;
    }

    public String getNomV() {
        return nomV;
    }

    public void setNomV(String nomV) {
        this.nomV = nomV;
    }

    public String getPrenomV() {
        return prenomV;
    }

    public void setPrenomV(String prenomV) {
        this.prenomV = prenomV;
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
        hash += (idV != null ? idV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veterinaire)) {
            return false;
        }
        Veterinaire other = (Veterinaire) object;
        if ((this.idV == null && other.idV != null) || (this.idV != null && !this.idV.equals(other.idV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Veterinaire[ idV=" + idV + " ]";
    }
    
}
