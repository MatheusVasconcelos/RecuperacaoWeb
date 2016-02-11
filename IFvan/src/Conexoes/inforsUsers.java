package Conexoes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.cadastroUsuario;
import Objetos.Usuario;
@WebServlet("/Cadastro.do")
public class inforsUsers extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			Usuario user = new Usuario();	
			user.setNome(request.getParameter("nome"));
			user.setCpf(request.getParameter("cpf"));
			user.setIdade(request.getParameter("idade"));
			user.setSexo(request.getParameter("sexo"));
			user.setOcupacao(request.getParameter("ocupacao"));
			user.setSenha(request.getParameter("senha"));
			cadastroUsuario usuario = new cadastroUsuario();
			usuario.cadastrar(user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
}
