/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ReservationInterface {
    public void addReservation(Reservation r);
    
    
    //list : select
    public List<Reservation> fetchReservations();
    public void modReservation(Reservation r);
    public void suppReservation(int id);
    public ArrayList sortBy(String nom_column, String Asc_Dsc);
     public Reservation readById(int id);
}
