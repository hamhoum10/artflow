/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class FXMLController_1 implements Initializable {

    @FXML
    private TextField id_Firstname;
    @FXML
    private TextField id_password;
    @FXML
    private TextField id_Username;
    @FXML
    private TextField id_Email;
    @FXML
    private TextField id_adress;
    @FXML
    private TextField id_Phonenumber;
    @FXML
    private TextField id_Lastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveClient(ActionEvent event) {
    }
    
}
