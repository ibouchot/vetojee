/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Entity.Animal;
import Entity.Consultation;
import Entity.Veterinaire;

import dao.AnimalFacadeLocal;
import dao.ConsultationFacadeLocal;
import dao.VeterinaireFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author ivan
 */
@Named(value = "vue")
@SessionScoped
@ManagedBean
public class vue implements Serializable {
    private Animal animal;
    private Veterinaire veterinaire;

    private Consultation consultation;
    
    private List<Veterinaire> listveto;
    

   

   
    private List<Animal> listanimal;
    private List<Consultation> listconsul;
    
    private DualListModel<Animal> animaux;




    
   @EJB
   AnimalFacadeLocal animaldao;
   @EJB
   ConsultationFacadeLocal consultationdao;
   @EJB
   VeterinaireFacadeLocal veterinairedao;
   
    /**
     * Creates a new instance of vue
     */
    public vue() {
       
        animal= new Animal();
        consultation = new Consultation();
        veterinaire = new Veterinaire();
        
    }

    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
    
    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(Veterinaire veterinaire) {
        this.veterinaire = veterinaire;
    }
    
    public List<Veterinaire> getListVeterinaire() {
        return veterinairedao.findAll();
    }
    public List<Animal> getListeAnimal(){     
       return animaldao.findAll();
    }
    
    public String getValeur(){
        
       return animaldao.find(1).getNomA();
       
    }
    
    public List<Consultation> getAllConsultation(){
     return consultationdao.findAll();
    }
    
    public void addAnimal(){
        
        
        animaldao.create(animal);     
    }
    public Animal getIdAFromTTatouage(String tatoo){
        Animal animalfromtatoo = new Animal();
        listanimal = animaldao.findAll();
        for(int i=0 ; i<animaldao.findAll().size();i++){
            Animal lanimal= new Animal();
            lanimal= listanimal.get(i);
            if(lanimal.getTatouage().equals(tatoo)){                
                animalfromtatoo = lanimal;
            }   
        }
        System.out.println(animalfromtatoo);
        return animalfromtatoo;
    }
    public Veterinaire getVeterinaireFromIDV(int veto){
        Veterinaire veterinairefromid= new Veterinaire();
        listveto = veterinairedao.findAll();
        for(int i = 0; i < listveto.size(); i++){
            Veterinaire vet = new Veterinaire();
            vet = listveto.get(i);
            System.err.println("ERROR");
            if(vet.getIdV() == veto){
                System.err.println("in function");
                veterinairefromid = vet;
            }   
        }  
        System.err.println(veterinairefromid);
        return veterinairefromid;
    }
    public Consultation getObjectFromIdConsultation(int idConsul){
        Consultation consultationfromid= new Consultation();
        listconsul = consultationdao.findAll();
        for(int i = 0; i < listconsul.size(); i++){
            Consultation consul = new Consultation();
            consul = listconsul.get(i);
            
            if(consul.getIdC() == idConsul){
                System.err.println("in function");
                consultationfromid = consul;
            }   
        } 
        return consultationfromid;
    }
    public void addConsultation(){   
        consultation.setIdA(getIdAFromTTatouage(animal.getTatouage()));
        consultation.setIdV(getVeterinaireFromIDV(veterinaire.getIdV()));
        consultationdao.create(consultation);     
    }
    public void updateConsultation(){
        consultation.setIdC(consultation.getIdC());
        consultation.setIdA(getIdAFromTTatouage(animal.getTatouage()));
        consultation.setIdV(getVeterinaireFromIDV(veterinaire.getIdV()));
        consultationdao.edit(consultation);  
         
    }
    public void deleteConsultation(){
        
        consultationdao.remove(getObjectFromIdConsultation(consultation.getIdC()));        
    }
   
 



         
    
    
    
   
    
//////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////
}
