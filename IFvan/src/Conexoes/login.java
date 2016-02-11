package Conexoes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.alteracoesLugares;
import DAO.cadastroUsuario;
import Objetos.Usuario;
@WebServlet("/Login.do")
public class login extends HttpServlet{
	  private static final long serialVersionUID = 7633293501883840556L;
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Usuario user = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		try{
				cadastroUsuario usuario = new cadastroUsuario();
				user = usuario.getUsuario(nome, senha);
		}catch(Exception e){
			
		}
		if(user.getNome().equals("Admin") && user.getSenha().equals("12345")){
			boolean[] lugares = new boolean[10];
			alteracoesLugares lugar = new alteracoesLugares();
			for(int i = 0; i<=9; i++){
				try{
					lugares[i] = lugar.listarLugares(i+1);	
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}	
			}
			session.setAttribute("lugares", lugares);
			session.setAttribute("user", user);
			request.getRequestDispatcher("logadoAdmin.jsp").forward(request, response);
		}else 
		if(user == null){
			session.invalidate();
			response.getWriter().print("<script>window.alert('Usuario e/ou senha estao incorretos!'); location.href='login.jsp'</script>");
		}else{
			boolean[] lugares = new boolean[10];
			alteracoesLugares lugar = new alteracoesLugares();
			for(int i = 0; i<=9; i++){
				try{
					lugares[i] = lugar.listarLugares(i+1);	
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}	
			}
			session.setAttribute("lugares", lugares);
			session.setAttribute("user", user);
			request.getRequestDispatcher("logado.jsp").forward(request, response);
		}	
	}
}
