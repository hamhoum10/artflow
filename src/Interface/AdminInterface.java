/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.Admin;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface AdminInterface {
    public Admin saveAdmin(Admin p);
    public List<Admin> fetchAdmin();
    public Admin getAdmin(int id);
    public void updateAdmin(Admin p);
    public void deleteAdmin(int id);
    
}
