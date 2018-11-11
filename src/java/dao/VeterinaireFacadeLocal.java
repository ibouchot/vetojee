/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Veterinaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface VeterinaireFacadeLocal {

    void create(Veterinaire veterinaire);

    void edit(Veterinaire veterinaire);

    void remove(Veterinaire veterinaire);

    Veterinaire find(Object id);

    List<Veterinaire> findAll();

    List<Veterinaire> findRange(int[] range);

    int count();
    
}
