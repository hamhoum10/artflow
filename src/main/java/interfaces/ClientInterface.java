/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import models.Client;

import java.util.List;

/**
 *
 * @author kanza
 */
public interface ClientInterface {
    public Client saveClient(Client p);
    public List<Client> fetchClient(int id);
    public Client getClient(int id);
    public void updateClient(Client p);
    public void deleteClient(int id);
    
}
