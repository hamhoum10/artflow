/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Artiste;
import models.stock;

/**
 *
 * @author MediaStudio
 */
public interface StockInterface {
     public stock fetchStockByName(String name);
    public List<stock> fetchStock();
    
}
