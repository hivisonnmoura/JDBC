package br.com.jovensprofissionais.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.jovensprofissionais.jdbc.dao.ContatoDao;
import br.com.jovensprofissionais.jdbc.modelo.Contato;

public class TestaLista {
	public static void main(String[] args)  {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos;
		try {
			contatos = dao.getLista();
			for (Contato contato : contatos){
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Endereço: " + contato.getEndereco());
				System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
