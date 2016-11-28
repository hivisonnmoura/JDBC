
package br.com.jovensprofissionais.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jovensprofissionais.jdbc.ConnectionFactory;
import br.com.jovensprofissionais.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos " +
					"(nome,email,endereco,dataNascimento)" +
					"values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() throws SQLException{
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
		ResultSet rs = stmt.executeQuery();
		
		List<Contato> contatos = new ArrayList<>();
		
		while (rs.next()){
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(data);
			
			contatos.add(contato);
		}
		
		rs.close();
		stmt.close();
		return contatos;
	}
	
	
	
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
