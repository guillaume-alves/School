import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ecole";
        String user = "root";
        String password = "gasql";

        try {
            // Get connection to the database
            Connection myConn = DriverManager.getConnection(url, user, password);

            // Get statement defined
            Statement state = myConn.createStatement();

            String query = "SELECT professeur.nom, professeur.prenom, matiere.nom FROM ((professeur INNER JOIN matiere_professeur ON matiere_professeur.professeur_id = professeur.idprofesseur)INNER JOIN matiere ON matiere_professeur.matiere_id = matiere.idmatiere)";

            ResultSet result = state.executeQuery(query);
            String nom = "";

            while(result.next()){
                if(!nom.equals(result.getString("nom"))){
                    nom = result.getString("nom");
                    System.out.println(nom + " " + result.getString("professeur.prenom") + " enseigne : ");
                }
                System.out.println("\t\t\t - " +  result.getString("matiere.nom"));
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}