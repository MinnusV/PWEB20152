package br.edu.nassau.pweb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.nassau.pweb.dao.DaoUsuario;
import br.edu.nassau.pweb.dao.DaoUsuarioImpl;
import br.edu.nassau.pweb.model.Usuario;

/**
 * Servlet implementation class CadastraUsuarioServlet
 */
@WebServlet("/CadastraUsuarioServlet")
public class CadastraUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoUsuario daoUsuario;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = new DaoUsuarioImpl();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraUsuarioServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("attr_login");
		String nome = request.getParameter("attr_nome");
		String senha = request.getParameter("attr_senha");
		
		
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setNome(nome);
		u.setSenha(senha);
		try {
			daoUsuario.save(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
		
	}

}
