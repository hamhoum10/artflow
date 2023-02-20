/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import models.Artiste;

import java.util.List;

/**
 *
 * @author kanza
 */
public interface ArtisteInterface {
        public Artiste saveArtiste(Artiste p);
    public List<Artiste> fetchArtiste(int id);
    public Artiste getArtiste(int id);
    public void updateArtiste(Artiste p);
    public void deleteArtiste(int id);
}
