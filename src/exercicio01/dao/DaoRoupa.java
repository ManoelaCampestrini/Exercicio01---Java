package exercicio01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exercicio01.entidades.Roupa;
import exercicio01.interfaces.ICrud;
import jdbc.utilidades.Conexao;

public class DaoRoupa implements ICrud<Roupa> {

	@Override
	public boolean salvar(Roupa obj) {
		String sql = "insert into roupa (modelo, cor, tecido)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getModelo());
			stm.setString(2, obj.getCor());
			stm.setString(3, obj.getTecido());
			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public boolean alterar(Roupa obj) {
		String sql = "update roupa set modelo = ?, cor = ?, tecido = ? where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getModelo());
			stm.setString(2, obj.getCor());
			stm.setString(3, obj.getTecido());
			stm.setInt(4, obj.getId());
			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from roupa where id =" + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
	}

	@Override
	public Roupa consultar(int id) {
		Roupa rp = new Roupa();
		String sql = "select * from roupa where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rp.setId(rs.getInt("id"));
				rp.setModelo(rs.getString("modelo"));
				rp.setCor(rs.getString("cor"));
				rp.setTecido(rs.getString("tecido"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return rp;
	}

	@Override
	public List<Roupa> consultar() {
		List<Roupa> roupas = new ArrayList<>();
		String sql = "select * from roupa";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Roupa rp = new Roupa();
				rp.setId(rs.getInt("id"));
				rp.setModelo(rs.getString("modelo"));
				rp.setCor(rs.getString("cor"));
				rp.setTecido(rs.getString("tecido"));
				roupas.add(rp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return roupas;
	}	
}
