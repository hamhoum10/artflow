/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Client;
import models.Enchere;

/**
 *
 * @author Elizabeth
 */
public interface ClientInterface {
    
    public void addClient(Client c);
    
    
        public Client fetchClientByName(String username);
        public List<Client> fetchClient();

    
}
