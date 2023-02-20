/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Categorie;

import java.util.List;


/**
 *
 * @author MediaStudio
 */
public interface CategorieInterface {
    //ajout
    public void addCategorie(Categorie c);
    
    //modification
    public void ModifyCategorie(Categorie c);
    
    //suppression
    public void deleteCategorie(int id);
    
    
    //list : select
    public List<Categorie> fetchCategorie();
    
    //affectation
    //public void affecterJoueur(Player p, Team t);
        
            public List<Categorie> fetchCategorieById(int id);
             public List<Categorie> fetchCategorieByName(String name);

        
    
}
