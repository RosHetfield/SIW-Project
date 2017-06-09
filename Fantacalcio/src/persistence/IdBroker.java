package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdBroker {
	
	private static final String query = "SELECT nextval('giocatore_id_seq') AS id";
	
	public static Long getId(Connection connection) {
		Long id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			result.next();
			id = result.getLong("id");
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return id;
	}

}
