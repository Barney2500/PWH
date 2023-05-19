package proyectowh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Rankingshow {
	private ArrayList<Ranking> ranks;
	
	
	public Rankingshow() {
		ranks =  new ArrayList<Ranking>();
		DbCon conn = new DbCon();

        ResultSet rs = conn.getQueryRS("SELECT * FROM battle_results b , players p where b.player_id = p.player_id ORDER BY battle_points DESC LIMIT 10");
        try {

            // Iterate the result set for each row
            while (rs.next()) {
                // add an Instance of each weapon in the arrayList
            	ranks.add(new Ranking(rs.getString(4), rs.getString(6) ,rs.getString(7) , rs.getString(8), rs.getInt(1), rs.getString(13), rs.getInt(9), rs.getInt(10),rs.getInt(11)));
            }

        } catch (SQLException e) {
            System.out.println("Error running ResultSet");
        } finally {
            conn.closeConn();
        }
    }

	public ArrayList<Ranking> getRanking() {
		return ranks;
	}
}
