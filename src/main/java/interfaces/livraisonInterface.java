package interfaces;

import models.livraison;
import models.stock;

import java.util.Date;
import java.util.List;

public interface livraisonInterface {
    public void addlivraison(livraison s);
    public List<livraison> fetchlivraison();
    public void updateAlllivraison(livraison s);
    public void deleatlivraisonById(int id);
    public List<livraison> filtreParCommendeliv(int cmd);
    public void deleatalllivraison();
    public List<livraison> SelectByIdliv(int id);
    public List<livraison> SelectByArtisteliv(String art);
    public List<livraison> SelectByUserliv(String usr);
    public List<livraison>SlectByDateliv(Date d);

}
