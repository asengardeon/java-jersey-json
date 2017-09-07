import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.handit.diagramator.db.DiagramConnection;

public class TestConnection {


public static void main(String[] args) {
	DiagramConnection c = new DiagramConnection();
	Connection conn = c.getInstance();
	List<String> list = new ArrayList() ;

	final String sql = "select * from CUBE_T";

	
	Statement stmt;
	try {
		stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		while(result.next()) {
			list.add(result.getString("DESCRIPTION"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	

}
