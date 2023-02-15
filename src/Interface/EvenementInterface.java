/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Evenement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EvenementInterface {
    
    public void addEvenement(Evenement e);
    
    
    //list : select
    public List<Evenement> fetchEvenements();
    public void modEvenement(Evenement e);
    public void suppEvenement(int id);
     public ArrayList sortBy(String nom_column, String Asc_Dsc);
     public Evenement readById(int id);
    
    
}
