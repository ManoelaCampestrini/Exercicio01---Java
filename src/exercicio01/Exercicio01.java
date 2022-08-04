package exercicio01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exercicio01.dao.DaoRoupa;
import exercicio01.entidades.Roupa;
import jdbc.utilidades.Conexao;

public class Exercicio01 {

	public static void main(String[] args) {
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
		Roupa r4 = new Roupa("Shorts", "Azul Claro", "Jeans");
		if (dr.salvar(r4)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}
		
		Roupa r5 = new Roupa("Blusa", "Rosa", "Algodão");
		if (dr.salvar(r5)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}
		
		Roupa r6 = new Roupa("Sobretudo", "Bege", "Lã Batida");
		if (dr.salvar(r6)) {
			System.out.println("Roupa cadastrada com sucesso!");
		}


	}

	static void excluir() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(4);
		System.out.println(rp);
		dr.excluir(4);
		rp = dr.consultar(4);
		System.out.println(rp);
	}

	public static void consultar() {
		DaoRoupa dr = new DaoRoupa();
		System.out.println(dr.consultar());
	}

	public static void consultarId() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(4);
		System.out.println(rp);
	}
	
	static void alterar() {
		DaoRoupa dr = new DaoRoupa();
		Roupa rp = dr.consultar(5);
		System.out.println(rp);
		rp.setModelo("Maiô");
		rp.setCor("Coral");
		rp.setTecido("Poliamida");
		if(dr.alterar(rp)) {
			System.out.println("Roupa alterada com sucesso!");
			System.out.println(rp);
	}
}}


