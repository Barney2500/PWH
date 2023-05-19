package proyectowh;

import java.util.ArrayList;
import java.sql.*;


public class CharArray {
	private ArrayList<Chara> chars;
	
	
	public CharArray() {
		chars =  new ArrayList<Chara>();
		DbCon conn = new DbCon();

        ResultSet rs = conn.getQueryRS("SELECT * FROM characters");
        try {

            // Iterate the result set for each row
            while (rs.next()) {
                // add an Instance of each weapon in the arrayList
            	chars.add(new Chara(rs.getInt(1),rs.getString(2),rs.getString(9),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getInt(11)));
            }

        } catch (SQLException e) {
            System.out.println("Error running ResultSet");
        } finally {
            conn.closeConn();
        }
    }

	public ArrayList<Chara> getCharas() {
		return chars;
	}



}
