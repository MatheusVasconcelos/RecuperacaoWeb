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
import Objetos.Lugares;
import Objetos.Usuario;
@WebServlet("/comprarPassagem.do")
public class comprarPassagem extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Lugares lugar = new Lugares();
		alteracoesLugares x = new alteracoesLugares();
		String num = request.getParameter("num");
		HttpSession user = request.getSession();
		Usuario usuario = (Usuario) user.getAttribute("user");
		lugar.setNum(num);
		lugar.setCpf(usuario.getCpf());
		lugar.setTipo(usuario.getOcupacao());
		try {
			x.comprarLugar(lugar);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("logado.jsp");
	}
}
