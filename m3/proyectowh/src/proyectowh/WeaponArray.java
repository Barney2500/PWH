package proyectowh;

import java.util.ArrayList;
import java.sql.*;


public class WeaponArray {
	private ArrayList<Weapon> weapons;
	
	//gets the weapons from the db and inserts into an array
	public WeaponArray(int i) {
		weapons =  new ArrayList<Weapon>();
		DbCon conn = new DbCon();

        ResultSet rs = conn.getQueryRS("SELECT * FROM weapons w, characters c, weap_ava wa where  (c.char_id = " + i +" and c.char_id = wa.char_id) and w.weapon_id = wa.weapon_id");
        try {
            // Iterate the result set for each row
            while (rs.next()) {

                // add an Instance of each weapon in the arrayList
                weapons.add(new Weapon(rs.getInt(1),rs.getString(3),rs.getString(2),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
            }

        } catch (SQLException e) {
            System.out.println("Error running ResultSet");
        } finally {
            conn.closeConn();
        }



	}


	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}





	
}
