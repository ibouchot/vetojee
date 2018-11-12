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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByIdA", query = "SELECT a FROM Animal a WHERE a.idA = :idA")
    , @NamedQuery(name = "Animal.findByNomA", query = "SELECT a FROM Animal a WHERE a.nomA = :nomA")
    , @NamedQuery(name = "Animal.findByDateNaissanceA", query = "SELECT a FROM Animal a WHERE a.dateNaissanceA = :dateNaissanceA")
    , @NamedQuery(name = "Animal.findByTatouage", query = "SELECT a FROM Animal a WHERE a.tatouage = :tatouage")
    , @NamedQuery(name = "Animal.findByVivant", query = "SELECT a FROM Animal a WHERE a.vivant = :vivant")
    , @NamedQuery(name = "Animal.findByNomRace", query = "SELECT a FROM Animal a WHERE a.nomRace = :nomRace")
    , @NamedQuery(name = "Animal.findByNomProprietaire", query = "SELECT a FROM Animal a WHERE a.nomProprietaire = :nomProprietaire")
    , @NamedQuery(name = "Animal.findByPrenomProprietaire", query = "SELECT a FROM Animal a WHERE a.prenomProprietaire = :prenomProprietaire")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdA")
    private Integer idA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nomA")
    private String nomA;
    @Column(name = "dateNaissanceA")
    @Temporal(TemporalType.DATE)
    private Date dateNaissanceA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tatouage")
    private String tatouage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vivant")
    private int vivant;
    @Size(max = 30)
    @Column(name = "nomRace")
    private String nomRace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nomProprietaire")
    private String nomProprietaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenomProprietaire")
    private String prenomProprietaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idA")
    private Collection<Consultation> consultationCollection;

    public Animal() {
    }

    public Animal(Integer idA) {
        this.idA = idA;
    }

    public Animal(Integer idA, String nomA, String tatouage, int vivant, String nomProprietaire, String prenomProprietaire) {
        this.idA = idA;
        this.nomA = nomA;
        this.tatouage = tatouage;
        this.vivant = vivant;
        this.nomProprietaire = nomProprietaire;
        this.prenomProprietaire = prenomProprietaire;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getNomA() {
        return nomA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public Date getDateNaissanceA() {
        return dateNaissanceA;
    }

    public void setDateNaissanceA(Date dateNaissanceA) {
        this.dateNaissanceA = dateNaissanceA;
    }

    public String getTatouage() {
        return tatouage;
    }

    public void setTatouage(String tatouage) {
        this.tatouage = tatouage;
    }

    public int getVivant() {
        return vivant;
    }

    public void setVivant(int vivant) {
        this.vivant = vivant;
    }

    public String getNomRace() {
        return nomRace;
    }

    public void setNomRace(String nomRace) {
        this.nomRace = nomRace;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Animal[ idA=" + idA + " ]";
    }
    
}
