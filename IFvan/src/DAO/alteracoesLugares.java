package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import Objetos.Lugares;
import Objetos.Usuario;

public class alteracoesLugares {
	public void comprarLugar(Lugares lugar) throws ClassNotFoundException{
		String sql = "UPDATE lugares SET ocupado='sim', cpf='"+lugar.getCpf()+"', tipo='"+lugar.getTipo()+"' WHERE num='"+lugar.getNum()+"';";
	
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement prepara = con.prepareStatement(sql);
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void cancelarLugar(String cpf)throws ClassNotFoundException{
		String sql = "UPDATE lugares SET ocupado='nao', cpf='', tipo='' WHERE cpf='"+cpf+"';";
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement prepara = con.prepareStatement(sql);
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public boolean listarLugares(int lugar) throws ClassNotFoundException{
		String sql = "SELECT ocupado FROM lugares WHERE num ='"+lugar+"';";
		String ocupado = null;
		boolean check = false;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ocupado = rs.getString("ocupado");	
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		if(ocupado.equals("sim")){
			check = true;
		}
		if(ocupado.equals("nao")){
			check = false;
		}
		return check;
	}
	
	public double totalApurado() throws SQLException, ClassNotFoundException{
		String sql = "SELECT usuario.ocupacao FROM lugares, usuario WHERE usuario.cpf = lugares.cpf and ocupado ='sim';";
		double count = 0;
		int x = 0;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String ocupacao = rs.getString("ocupacao");
				if(rs.getString("ocupacao").equals("estudante")){
					count = count + 12.5;
				}else if(rs.getString("ocupacao").equals("empregado")){
					count = count + 25;
				}else if(rs.getString("ocupacao").equals("aposentado")){
					x = x + 1;
					if(x<=2){
					count = count + 0;
					}else{
					count = count + 12.5;
					}
				}
			}
		}catch(Exception e){
			
		}
		return count;
	}
}
