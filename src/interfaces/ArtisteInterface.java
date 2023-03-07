/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Artiste;
import models.Categorie;
import models.User;

/**
 *
 * @author MediaStudio
 */
public interface ArtisteInterface {
    public Artiste fetchArtisteByName(String name);
    
     public Artiste saveArtiste(Artiste p);
    public List<Artiste> fetchArtiste();
    public Artiste getArtiste(int id);
    public void updateArtiste(Artiste p);
    public void deleteArtiste(String username);
    public User Userinsert (User a);
    public Artiste getArtistebyusername(String username);
}
