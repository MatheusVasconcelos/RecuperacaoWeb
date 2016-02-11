package Conexoes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.alteracoesLugares;
@WebServlet("/totalApurado.do")
public class totalApurado extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		alteracoesLugares x = new alteracoesLugares();
		try {
			double total = x.totalApurado();
			PrintWriter out = response.getWriter();
			out.println(total);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
