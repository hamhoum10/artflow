/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Artiste;
import models.Categorie;

/**
 *
 * @author MediaStudio
 */
public interface ArtisteInterface {
    public Artiste fetchArtisteByName(String name);
    public List<Artiste> fetchArtiste();
}
