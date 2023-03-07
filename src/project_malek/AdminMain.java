/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_malek;

/**
 *
 * @author kanza
 */
import models.Admin;
import models.Client;
import services.AdminService;
import services.ClientService;

/**
 *
 * @author kanza
 */
public class AdminMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*// singleton
        MyConnection m1 = MyConnection.getInstance(); 
        m1.getCnx();
        MyConnection m2 = MyConnection.getInstance(); 
        m2.getCnx();*/
        
                AdminService as= new AdminService();
                
                
                //add 
         Admin p = as.saveAdmin(new Admin("rym","saidi","rym1A@gmail.com","12345678","mappppppp ","rym"));
         
          //affichage
         //System.out.println(as.fetchAdmin());
        
        
         
                //update 
                //Admin p=new Admin();
                //p.setId(2);
                //p.setFirstname("emna");
                //p.setLastname("cheniti");
                //p.setEmail("emna@gmail.com");
                //p.setPhoneNumber("87654321");
                //p.setUsername("emna");
                //p.setPassword("amna");
                //as.updateAdmin(p);
        
         
         //delete admin
         //as.deleteAdmin(2);
             }
    
}
