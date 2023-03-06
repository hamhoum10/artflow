package interfaces;

import models.stock;

import java.util.Date;
import java.util.List;

public interface stockInterface {
public void addstock(stock s);
    public List<stock> fetchstock();
    public void updateAllstock(stock s);
    public void deleatstockById(int id);
    public List<stock> filtreParCommende(int cmd);
    public void deleatallstock();
    public List<stock> SelectById(int id);
public List<stock> SelectByArtiste(String art);
    public List<stock> SelectByUser(String usr);
    public List<stock>SlectByDate(Date d);
    public void SmsNotification();
    public void moveToLivraison( stock s);

}
