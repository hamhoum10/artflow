package services;

import models.Article;
import models.Ligne_panier;
import util.Conditions;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Ligne_PanierService {


    // Constructeur
    public Ligne_PanierService() {}

    // Connexion à la base de données
    Connection cnx = MyConnection.getInstance().getCnx();
    Conditions c =new Conditions();

    // Déconnexion de la base de données
    public void disconnect() {
    }
    // CRUD operations

    public void AjouterDansTableligne_Panier(Ligne_panier lp, int id_article) {
        try {//ken mesh mawjoud el article tzid ligne
            if(c.DoArticleIdExistinLignePanier(id_article,lp.getId_panier())==false){
                // Créer une requête préparée pour insérer les données dans la table
                String sql = "insert into ligne_panier(id_panier,id_article,Nom_article,description,prix_unitaire, quantity,Nom_artiste,Prenom_artiste) values (?, ?,?,?,?,?,?,?)";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getId_panier());//hethi te5o el id mta panier ki namlou instance ligne-panier(..,idpanier)
                st.setInt(2, id_article);
                st.setString(3, lp.getArticle().getNom_article());
                st.setString(4, lp.getArticle().getDescription());
                st.setDouble(5, lp.getArticle().getPrice());
                st.setDouble(6, lp.getQuantity());
                st.setString(7, lp.getArticle().getArtiste().getFirstname());
                st.setString(8, lp.getArticle().getArtiste().getLastname());
                // Exécuter la requête
                st.executeUpdate();
                System.out.println("product added dans la ligne_panier associe a la panier  d'ID "+ lp.getId_panier());
                //tesna3 ligne fil panier fih hethom fi front-end baed
            }else{//ken article mawjoud tzid quantity
                String sql = "UPDATE ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier SET lp.quantity = lp.quantity + ? WHERE lp.id_article =? AND p.id_panier =? ";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getQuantity());
                st.setInt(2, id_article);
                st.setInt(3,lp.getId_panier() );
                st.executeUpdate();
                System.out.println("quantity is added");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* public void AjouterDansTableligne_Panier(Ligne_panier lp) {
        try {//ken mesh mawjoud el article tzid ligne
            if(c.DoArticleIdExistinLignePanier(lp.getArticle().getId_article(),lp.getId_panier())==false){
                // Créer une requête préparée pour insérer les données dans la table
                String sql = "insert into ligne_panier(id_panier,id_article,Nom_article,description,prix_unitaire, quantity,Nom_artiste,Prenom_artiste) values (?, ?,?,?,?,?,?,?)";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getId_panier());//hethi te5o el id mta panier ki namlou instance ligne-panier(..,idpanier)
                st.setInt(2, lp.getArticle().getId_article());
                st.setString(3, lp.getArticle().getNom_article());
                st.setString(4, lp.getArticle().getDescription());
                st.setDouble(5, lp.getArticle().getPrice());
                st.setDouble(6, lp.getQuantity());
                st.setString(7, lp.getArticle().getArtiste().getFirstname());
                st.setString(8, lp.getArticle().getArtiste().getLastname());
                // Exécuter la requête
                st.executeUpdate();
                System.out.println("product added dans la ligne_panier associe a la panier  d'ID "+ lp.getId_panier());
                //tesna3 ligne fil panier fih hethom fi front-end baed
            }else{//ken article mawjoud tzid quantity
                String sql = "UPDATE ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier SET lp.quantity = lp.quantity + ? WHERE lp.id_article =? AND p.id_panier =? ";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getQuantity());
                st.setInt(2, lp.getArticle().getId_article());
                st.setInt(3,lp.getId_panier() );
                st.executeUpdate();
                System.out.println("quantity is added");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    // Supprimer un produit par son ID d'un user preciser par son iduser du panier
    public void deleteFromLigne_panierByArticle(int id_panier, int id_article) {
        try {
            // Créer une requête préparée pour supprimer l'entrée spécifiée
            //String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_client = ? AND lp.id_article = ?";
            String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_panier= ? AND lp.id_article = ?";
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.setInt(1, id_panier);
            p.setInt(2, id_article);
            p.executeUpdate();
            System.out.println("product d'ID "+ id_article +" " + "supprimé de la panier  d'ID "+id_panier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Supprimer un produit par son ID d'un user preciser par son iduser du panier
    public void deleteAllFromLigne_panier(int id_panier) {
        try {
            // Créer une requête préparée pour supprimer l'entrée spécifiée
            //String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_client = ?"; //cvlient fi parametre 9bal
            //String sqls = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_panier = ?";
            String sql ="DELETE lp FROM ligne_panier lp JOIN panier p ON p.id_panier = lp.id_panier WHERE p.id_panier =  "+ id_panier;
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.executeUpdate();
            System.out.println("la ligne panier est vider  "+id_panier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Ligne_panier> readelementPanierbyiduser(int id_client) {
        List<Ligne_panier> ps = new ArrayList<>();
        ArticleService as =new ArticleService();

        try {
            //String sql = "SELECT p.id_panier, lp.id_article, lp.prix_unitaire, lp.quantity,lp.Nom_article,lp.description FROM panier p JOIN ligne_panier lp ON p.id_panier = lp.id_panier WHERE p.id_client ="+id_client  ;
            String sql = "SELECT p.id_panier, lp.quantity, a.* FROM article a JOIN ligne_panier lp ON a.id_article = lp.id_article JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_client = "+ id_client ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Article a =new Article();
                Ligne_panier lp = new Ligne_panier();
                lp.setQuantity(rs.getInt("lp.quantity"));
                lp.setId_panier(rs.getInt("p.id_panier"));
                a.setId_article(rs.getInt("a.id_article"));
                a.setNom_article(rs.getString("a.Nom_article"));
                a.setPrice(rs.getDouble("a.price"));
                a.setDescription(rs.getString("a.description"));
                a.setType(rs.getString("a.type"));
                a.setQuantity(rs.getInt("a.quantity"));
                lp.setArticle(a);
                ps.add(lp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
        //tzid +1 qauntity fi "panier"
    public void updatequantitywith1Plus(int id_panier,int id_article) throws SQLException {
        String query = "UPDATE ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier SET lp.quantity = lp.quantity + ? WHERE lp.id_article =? AND p.id_panier =? ";

            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, 1);
            st.setInt(2, id_article);
            st.setInt(3,id_panier );
            st.executeUpdate();
            System.out.println("quantity is added");

    }
        //tna9es -1 qauntity fi "panier"
    public void updatequantitywith1Minus(int id_panier,int id_article) throws SQLException {
        String query = "UPDATE ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier SET lp.quantity = lp.quantity - ? WHERE lp.id_article =? AND p.id_panier =? AND lp.quantity > 1 ";
        //cindition si quantity =1
        PreparedStatement st = cnx.prepareStatement(query);
        st.setInt(1, 1);
        st.setInt(2, id_article);
        st.setInt(3,id_panier );
        st.executeUpdate();
        System.out.println("quantity is decreased");

    }

}
