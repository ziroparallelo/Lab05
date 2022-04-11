package it.polito.tdp.anagrammi.DB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AnagrammiCorrettiDAO {
	
	public boolean isCorrect(String parola)
	{
		Set<String> hs = new HashSet<String>();
		final String sql = "select nome "
				+ "from parola";
		
		try {
			
			Connection conn = ConnectionDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String s = rs.getString("nome");
				hs.add(s);
			}
			
		conn.close();
		ps.close();
		rs.close();

		}
		catch (SQLException e)
		{
			throw new RuntimeException("Errore Db", e);
		}
		
		if(hs.contains(parola))
			return true;
		return false;
		
		
	}

}
