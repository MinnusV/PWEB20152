package br.edu.nassau.pweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.nassau.pweb.model.Usuario;

public class DaoUsuarioImpl extends GenericDao implements DaoUsuario{

	public void save(Usuario usuario) throws SQLException{
		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?,?,?)";	
		PreparedStatement st = null;
		try {
			openConn();
			st = conn.prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(st != null)
				st.close();
			closeConn();
		}	
	}
	
	public void update(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuarios SET nome=?, login=?, senha=? WHERE id=?";
		PreparedStatement st =null;
		try {
			openConn();
			st = conn.prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.setInt(4, usuario.getId());
			st.execute();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			if(st != null)
				st.close();
			closeConn();
		}
	}
	
	public void remove(Usuario usuario) throws SQLException{
		remove(usuario.getId());
	}
	
	public void remove(Integer id) throws SQLException{
		String  sql = "DELETE from usuarios WHERE id = ?";
		PreparedStatement st = null;
		try {
			openConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			if(st != null)
				st.close();
			closeConn();
		}
	}
	
	public Usuario get(int id) throws SQLException{
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement st = null;
		try {
			openConn();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			
			if( resultSet.next() ){
				int idRs = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String senha = resultSet.getString("senha");
				
				Usuario usuario = new Usuario();
				usuario.setId(idRs);
				usuario.setNome(nome);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				return usuario;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(st != null)
				st.close();
			closeConn();
		}
		return null;
	}
	
	public List<Usuario> list() throws SQLException{
		String sql = "SELECT * FROM usuarios";
		PreparedStatement st = null;
		
		try {
			openConn();
			st = conn.prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			while( resultSet.next() ){
				
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String login = resultSet.getString("login");
				String senha = resultSet.getString("senha");
				
				Usuario u = new Usuario();
				u.setId(id);
				u.setNome(nome);
				u.setLogin(login);
				u.setSenha(senha);
				usuarios.add(u);
			}
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(st != null)
			st.close();
			conn.close();
		}
		return list();
	}
	
}
