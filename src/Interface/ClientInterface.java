/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Client;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ClientInterface {
    public Client saveClient(Client p);
    public List<Client> fetchClients();
    
    public Client getClient(int id);
    public void updateClient(Client p);
    public void deleteClient(int id);
    public Client fetchClientByName(String name);
}
