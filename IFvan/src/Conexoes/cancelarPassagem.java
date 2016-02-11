package Conexoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.alteracoesLugares;
import Objetos.Lugares;
import Objetos.Usuario;
@WebServlet("/cancelarPassagem.do")
public class cancelarPassagem extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Lugares lugar = new Lugares();
		alteracoesLugares x = new alteracoesLugares();
		HttpSession user = request.getSession();
		Usuario usuario = (Usuario) user.getAttribute("user");
		String cpf = usuario.getCpf();
		try {
			x.cancelarLugar(cpf);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("logado.jsp");

	}
}
