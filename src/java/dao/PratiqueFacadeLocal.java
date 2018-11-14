/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Pratique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface PratiqueFacadeLocal {

    void create(Pratique pratique);

    void edit(Pratique pratique);

    void remove(Pratique pratique);

    Pratique find(Object id);

    List<Pratique> findAll();

    List<Pratique> findRange(int[] range);

    int count();
    
}
