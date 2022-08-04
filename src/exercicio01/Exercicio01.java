package exercicio01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exercicio01.dao.DaoRoupa;
import exercicio01.entidades.Roupa;
import jdbc.utilidades.Conexao;

public class Exercicio01 {

	public static void main(String[] args) {
		//DaoRoupa dr = new DaoRoupa();
		//testeConexao();
		//salvar();
		//consultar();
		//consultarId();
		//alterar();
		//excluir();
		
	}

	static void testeConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("Conectado com sucesso!");
		} else {
			System.out.println("Erro ao conectar!");
		}
	}

	static void salvar() {
		DaoRoupa dr = new DaoRoupa();
		Roupa r1 = new Roupa("Vestido", "Azul", "Seda");
		if (dr.salvar(r1)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}
		
		Roupa r2 = new Roupa("Blazer", "Preto", "Lã Mista");
		if (dr.salvar(r2)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}
		
		Roupa r3 = new Roupa("Camisa", "Branca", "Linho");
		if (dr.salvar(r3)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}


	}

	static void excluir() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(1);
		System.out.println(rp);
		dr.excluir(1);
		rp = dr.consultar(1);
		System.out.println(rp);
	}

	public static void consultar() {
		DaoRoupa dr = new DaoRoupa();
		System.out.println(dr.consultar());
	}

	public static void consultarId() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(2);
		System.out.println(rp);
	}
	
	static void alterar() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(2);
		System.out.println(rp);
		rp.setModelo("Jaqueta");
		rp.setCor("Marrom");
		rp.setTecido("Couro");
		if(dr.alterar(rp)) {
			System.out.println("Roupa alterada com sucesso!");
			System.out.println(rp);
	}
}}


