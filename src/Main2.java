import java.sql.*;
 
public class Main2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ecole";
        String user = "root";
        String password = "gasql";

        try {
            // Get connection to the database
            Connection myConn = DriverManager.getConnection(url, user, password);

            // Get statement defined
            Statement state = myConn.createStatement();

            String query = "SELECT eleve.nom, eleve.prenom, classe.nom FROM eleve INNER JOIN classe ON eleve.classe_id = classe.idclasse";

            ResultSet result = state.executeQuery(query);
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.print(resultMeta.getColumnName(1).toUpperCase() + ", " + resultMeta.getColumnName(2).toUpperCase() + ", CLASSE");

            System.out.println("\n--------------------");

            while(result.next()){
               System.out.println(result.getString("eleve.prenom") + ", " + result.getString("eleve.nom") + ", " + result.getString("classe.nom"));
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}