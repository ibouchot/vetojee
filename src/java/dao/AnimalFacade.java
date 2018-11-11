/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Animal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivan
 */
@Stateless
public class AnimalFacade extends AbstractFacade<Animal> implements AnimalFacadeLocal {

    @PersistenceContext(unitName = "vetoprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnimalFacade() {
        super(Animal.class);
    }
    
}
