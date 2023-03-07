/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevArtiste;

import interfaces.ArtisteInterface;
import models.Artiste;
import models.User;
import services.ArtisteService;
import services.UserService;
import util.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class AddArtisteController implements Initializable {
        Connection cnx = MyConnection.getInstance().getCnx();
               UserService user = new UserService();

    ArtisteInterface artiste = new ArtisteService();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField email;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField adress;
    @FXML
    private TextField description;
    @FXML
    private DatePicker birthdate;
    @FXML
    private TextField birthplace;
    @FXML
    private TextField lastname;
//    @FXML
//    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private Button image;
    @FXML
    private Button AddArtiste;
    private File selectedFile;

    private FileChooser filechooser;
    private File file;
    private Stage stage;
    @FXML
    private AnchorPane ancorepane;
    private ImageView imageView;
    
    private Image imagee;
        @FXML
    private TextField imagefield;
    @FXML
    private ImageView image_view;
    @FXML
    private PasswordField password;
    private Label labelartist;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filechooser = new FileChooser();
        //filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image", "*.*")
        //);
    }    
 public String displayId(String Artiste){
        //labelartist.setText("hello  "+ Artiste);
        return "artiste";
    }
    @FXML
    private void saveArtiste(ActionEvent event) throws IOException {                
        Artiste c = new Artiste();
            //User u=new User();

        if (firstname.getText().length() == 0||lastname.getText().length() == 0||birthplace.getText() == null||description.getText().length() == 0||imagefield.getText()==null||adress.getText()==null||phonenumber.getText()==null||email.getText()==null||username.getText()==null||password.getText()==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();

        } else if(!phonenumber.getText().matches("\\d{8}")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("your phone number has to contain 8 caracter"+ "");
            alert.show();
          
          }else {
            
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());        
        c.setBirthplace(birthplace.getText());
        LocalDate date = birthdate.getValue();
        c.setBirthdate(java.sql.Date.valueOf(date));
        c.setDescription(description.getText());
        c.setImage(imagefield.getText());
        c.setAddress(adress.getText());
        c.setPhonenumber(phonenumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());


try {
    String pwd = password.getText();
    String encryptedPassword = BCrypt.hashpw(pwd, BCrypt.gensalt());
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`, `password`,`type`) VALUES (?,?,?)");
    a1.setString(1, username.getText());
    a1.setString(2, encryptedPassword);
    a1.setString(3, displayId("artiste"));
    a1.executeUpdate();
        System.out.println("0000");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
        
         String htdocsPath = "C:/xampp/htdocs/img/";
                 File destinationFile = new File(htdocsPath + imagefield.getText());
            if(selectedFile!=null){
                try (InputStream in = new FileInputStream(selectedFile);
                 OutputStream out = new FileOutputStream(destinationFile)) {
                byte[] buf = new byte[8192];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
                //user.Userinsert(u);

        artiste.saveArtiste(c);
        String Email= email.getText();
        pidevAuthAdmin.MailSender m =new pidevAuthAdmin.MailSender();
        m.sendVerificationCode(Email, "you're registered succesfully");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../pidevAuthArtiste/LoginArtiste.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                }else{
                System.out.println("selected file is null "+selectedFile);
            }
        }
        
    }

    @FXML
    private void takeimage(ActionEvent event) {
//        FileChooser fc = new FileChooser();
//           fc.getExtensionFilters().addAll(
//            new ExtensionFilter("Image Files","*.png"));
//           File selectedFile = fc.showOpenDialog(null);
//           if(selectedFile != null) {
//               imagefield.setText(selectedFile.getAbsolutePath());
//           } else {
//               System.err.println("file is not valid");
//           }

            FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.JPG", "*.gif"));
          fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
         if (selectedFile != null) {
                imagefield.setText(selectedFile.getName());
                 try {
                Image images = new Image("file:"+selectedFile.getPath().toString());
                image_view.setImage(images);
                System.out.println(selectedFile.getPath().toString());
        } catch (Exception ex) {
                     System.out.println(ex);
        }
                
            }
    }

    @FXML
    private void gotologin(MouseEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuthArtiste/LoginArtiste.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
}
    
    

