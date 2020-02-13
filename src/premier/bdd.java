package premier;


import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import premier.Joueur;
import java.sql.*;

public abstract class bdd {
	
	//Connexion à la base de données
    public static Connection getConnection() {
        Connection connection = null;
        // ------------------------------
        String url = "jdbc:mysql://localhost:3306/borne_arcade" + "?autoReconnect=true&useSSL=false";
        String user = "root";
        String pwd = "";
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ------------------------------
        return connection;
    }

   /* public static void pseudo(Joueur p2) {
        String requete = "INSERT INTO score (pseudo_joueur) VALUES (?)";
        Connection connection = getConnection();
        try {
            PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(requete);
            // je viens binder le 1er ?
            prepare.setString(1, Joueur.pseudo_joueur);
            prepare.execute();
            prepare.close();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
    public static void score(Joueur p) {
        String requete = "INSERT INTO score (score, pseudo_joueur) VALUES (?, ?)";
        Connection connection = getConnection();
        try {
            PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(requete);
            // je viens binder le 1er ?
            prepare.setInt(1, MapGameState.finalScore);
            prepare.setString(2, Joueur.pseudo_joueur);
            prepare.execute();
            prepare.close();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void score2(Joueur2 p2) {
        String requete = "INSERT INTO score (score, pseudo_joueur) VALUES (?, ?)";
        Connection connection = getConnection();
        try {
            PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(requete);
            // je viens binder le 1er ?
            prepare.setInt(1, MapGameState.finalScore2);
            prepare.setString(2, Joueur2.pseudo_joueur);
            prepare.execute();
            prepare.close();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    	//Fonction qui gère la requête pour tout sélectionner dans la table score
    public static ArrayList<Joueur> selectAll() {
        ArrayList<Joueur> liste = new ArrayList<Joueur>();
        Connection connection = getConnection();
        // ------------------------------
        String requete = "select * from score order by score desc limit 10";
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = state.executeQuery(requete);
            while (result.next()) {
                String pseudo_joueur = result.getString("pseudo_joueur");
                String score = result.getString("score");
                Joueur p = new Joueur(pseudo_joueur, score);
                liste.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ------------------------------
        return liste;
    }
    
    
    

    


}
