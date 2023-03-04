/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Artiste;
import Models.User;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ArtisteInterface {
    

          public Artiste saveArtiste(Artiste p);
    public List<Artiste> fetchArtiste();
    public Artiste getArtiste(int id);
    public void updateArtiste(Artiste p);
    public void deleteArtiste(int id);
    public User Userinsert (User a);
    public Artiste fetchClientByName(String name);
}
