/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_malek;

import models.User;
import services.UserService;
import util.MyConnection;

/**
 *
 * @author kanza
 */
public class UserMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       UserService user= new UserService();
       //User u= user.Userinsert(new User("kk","kk","client"));
        
        //User u= user.authentification(new User("nada", "nada", "client"));
                 //User p = user.(new User("rym","saidi","tunis","12345678","rym@gmail.com","77777","rym"));
        //System.out.println(user.getUserbyusername("nada"));
       
//       User u =new User();
//      u.setUsername("nada");
//       u.setPassword("nada");
//       u.setType("client");
       // System.out.println(user.test("kk","kk"));
//        User p=new User();
//                
//                
//                p.setUsername("nada1");
//                p.setPassword("ff");
//                //p.setType("client");
//                user.UpdateUser(p);
    }
    
}
