/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and , open the template in the editor.
 */
package interfaces;

import models.Article;
import models.Rate;

/**
 *
 * @author MediaStudio
 */
public interface RateInterface {
   public void updateRating(Rate r);
   public Double afficherRating(Rate r);
   public Double afficherRateavg(Article e);
   
}
