/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Commentaire;
import models.Evenement;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CommentaireInterface {
    
      public void addComment(Commentaire t);
        public void modifier(Commentaire co);
        public void supprimer(int commentId);
        public Commentaire fetchCommentByEvemtId(int id);
        public List<Commentaire> fetchCommentaireByEvemtId(int id);
        public List<Evenement> fetchEvemts();
        public Evenement fetchEvemt(int id);
        public Commentaire fetchCommentByEvemtId(String description);
        public List<Commentaire> fetchCommentByPostId(int Id);
        public List<Commentaire> recuperer(int id);

    
}
