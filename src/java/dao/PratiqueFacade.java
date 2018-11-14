/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Pratique;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivan
 */
@Stateless
public class PratiqueFacade extends AbstractFacade<Pratique> implements PratiqueFacadeLocal {

    @PersistenceContext(unitName = "vetoprojectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PratiqueFacade() {
        super(Pratique.class);
    }
    
}
