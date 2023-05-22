package proyectowh;

import java.sql.*;

public class DbCon {

    private Connection conn;
    private Statement stmnt;
    //stablish connection with the database
    public DbCon() {
        String url = "jdbc:mysql://localhost/proyecto2";
        String usr = "root";
        String pas = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pas);
            stmnt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not charged");
        } catch (SQLException e) {
            System.out.println("Error in connection");
        }

    }

    public ResultSet getQueryRS(String query) {

        ResultSet rs = null;
        try {
            rs = stmnt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("query error");
        }

        return rs;
    }

    public void insertData(String update) {

        try {
            stmnt.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Error in update");
        }

    }

    public void closeConn() {

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in close");
        }

    }

}
