/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Enchere;
import models.Participant;

/**
 *
 * @author Elizabeth
 */
public interface EnchereParticipantInterface {
    
    
    public void AddEnchere(Enchere e);
    
    public Enchere fetchEnchereByname(String titre);
     public Enchere fetchEnchereById(int ide);
    public List<Enchere> fetchEnchere();
     public boolean updateEnchere(Enchere e);
     
     public  void deleteEnchere(int ide);

public boolean enchereExist(Participant p);
public void addParticipant(Participant p);
public boolean updateParticipant(Participant p);
public boolean deleteParticipant(Participant p);


public double getHighestBidAmount(Participant p);
 public void effectuerParticipation(Participant p);

//public Participant getWinningBidder(Participant p);

}
