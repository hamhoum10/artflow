package interfaces;

import models.livraison;
import models.retour;
import models.stock;

import java.util.Date;
import java.util.List;

public interface retourInterface {
    public void addretour(retour s);
    public List<retour> fetchretour();
    public void updateAllretour(retour s);
    public void deleatretourById(int id);
    public List<retour> filtreParCommenderet(int cmd);
    public void deleatallretour();
    public List<retour> SelectByIdret(int id);
    public List<retour> SelectByArtistere(String art);
    public List<retour> SelectByUserret(String usr);
    public List<retour>SlectByDatere(Date d);
    public void mouveToLivraison(retour s);
    public void SmsNotification(String id);



}
