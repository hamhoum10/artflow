/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Commentaire;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CommentaireInterface {
    
     public void ajouter(Commentaire t);
     public void modifier(Commentaire t);
      public void supprimer(Commentaire t);
      public List<Commentaire> recuperer(int idp);
     
    
}
