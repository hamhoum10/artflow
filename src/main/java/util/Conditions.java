package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conditions {

    Connection cnx = MyConnection.getInstance().getCnx();
    public boolean DoPanierIdExistinCommande(int id_panier) throws SQLException {
        String query = "SELECT id_panier FROM commande WHERE id_panier = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, id_panier);
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }
    public boolean DoUserIdExistinPanier(int id_client) throws SQLException {
        String query = "SELECT id_client FROM panier WHERE id_client = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, id_client);
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }
    public boolean DoArticleIdExistinLignePanier(int id_article,int id_panier) throws SQLException {
        String query = "SELECT lp.id_article FROM ligne_panier lp JOIN panier p ON p.id_panier = lp.id_panier  WHERE lp.id_article = ? AND lp.id_panier =? ";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, id_article);
            statement.setInt(2, id_panier);
            //System.out.println(id_article);
            //System.out.println(id_panier);
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }
}
