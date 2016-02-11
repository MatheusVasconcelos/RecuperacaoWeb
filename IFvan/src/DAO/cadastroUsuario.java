package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Objetos.Usuario;

public class cadastroUsuario {
	public void cadastrar(Usuario user){
		String sql = "INSERT INTO usuario(cpf, nome, idade, sexo, ocupacao, senha) VALUES(?,?,?,?,?,?)";

		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			PreparedStatement prepara = con.prepareStatement(sql);
			prepara.setString(1, user.getCpf());
			prepara.setString(2, user.getNome());
			prepara.setString(3, user.getIdade());
			prepara.setString(4, user.getSexo());
			prepara.setString(5, user.getOcupacao());
			prepara.setString(6, user.getSenha());
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

    
	public Usuario getUsuario(String nome, String senha) throws ClassNotFoundException, SQLException{
		ConnectionFactory.openConnection();
		Connection c = ConnectionFactory.getConnection(); 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = c.prepareStatement("SELECT nome, senha FROM usuario WHERE nome = ? and senha = ?;");
			ps.setString(1, nome);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			while(rs.next()){
				Usuario user = new Usuario();
				user.setNome(nome);
				user.setSenha(senha);
				return user;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
