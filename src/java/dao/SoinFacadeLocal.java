/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Soin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface SoinFacadeLocal {

    void create(Soin soin);

    void edit(Soin soin);

    void remove(Soin soin);

    Soin find(Object id);

    List<Soin> findAll();

    List<Soin> findRange(int[] range);

    int count();
    
}
