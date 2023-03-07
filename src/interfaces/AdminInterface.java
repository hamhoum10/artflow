/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Admin;
import models.User;
import java.util.List;

/**
 *
 * @author kanza
 */
public interface AdminInterface {
    public Admin saveAdmin(Admin p);
    public List<Admin> fetchAdmin();
    public Admin getAdmin(int id);
    public void updateAdmin(Admin p);
    public void deleteAdmin(String username);
}
