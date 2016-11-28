package br.com.jovensprofissionais.jdbc.teste;

import java.util.Calendar;

import br.com.jovensprofissionais.jdbc.dao.ContatoDao;
import br.com.jovensprofissionais.jdbc.modelo.Contato;

public class TestaInsert {
	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Hivison");
		contato.setEmail("hnascimento@indracompany.com");
		contato.setEndereco("Rua Jasmim");
		contato.setDataNascimento(Calendar.getInstance());
		
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado !");
	}

}
