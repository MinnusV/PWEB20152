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
 * Servlet implementation class RemoveUsuarioServlet
 */
@WebServlet("/RemoveUsuarioServlet")
public class RemoveUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private DaoUsuario daoUsuario;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		daoUsuario = new DaoUsuarioImpl();
	}
    public RemoveUsuarioServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUsuarioStr = request.getParameter("id");
		Integer idUsuario = Integer.valueOf(idUsuarioStr);
		
		Usuario usl = new Usuario();
		usl.setId(idUsuario);
		try{
			daoUsuario.remove(usl);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		response.sendRedirect("Listar-usuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
