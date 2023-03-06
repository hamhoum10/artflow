package models;

import java.util.Date;

public class livraison {

    //var
    private int id;
    private Date date_sort;

    public Date getDate_sort() {
        return date_sort;
    }

    public void setDate_entr(Date date_sort) {
        this.date_sort = date_sort;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Livraison{" +
//                "id=" + id +
                " user_name='" + user_name + '\'' + System.lineSeparator()+
                ", date_entr=" + date_sort + System.lineSeparator()+
                ", name='" + name + '\'' + System.lineSeparator()+
                ", addres='" + addres + '\'' + System.lineSeparator()+
                ", artiste='" + artiste + '\'' + System.lineSeparator()+
                ", id_commende=" + id_commende + System.lineSeparator()+
                '}';
    }

    private String name,user_name,addres;

    private String artiste;
    private int id_commende;
    //constructeure
    public livraison(){}

    public livraison(int id, String name, String artiste, String addres , Date date_sort, int id_commende, String user_name) {
        this.id = id;
        this.name = name;
        this.artiste = artiste;
        this.id_commende = id_commende;
        this.addres=addres;
        this.date_sort=date_sort;
        this.user_name=user_name;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getId_commende() {
        return id_commende;
    }

    public void setId_commende(int id_commende) {
        this.id_commende = id_commende;
    }
    //affichage du stock

}
