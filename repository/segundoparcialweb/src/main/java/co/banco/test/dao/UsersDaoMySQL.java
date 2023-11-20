package co.banco.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.banco.test.modelo.Users;
import co.banco.test.util.ConexionMySQL;
import co.empresa.test.modelo.Usuario;


public class UsersDaoMySQL implements UsersDao {
	
private ConexionMySQL conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario(nombre, email, pais) VALUES (?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?,email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";
	
	
	public void UsuarioDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert(Users usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(2, usuario.getUsername());
			preparedStatement.setInt(3, usuario.getPassword());
			preparedStatement.setString(4, usuario.getEmail());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e){
		
		}
	}
	
	public void update(Users usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(2, usuario.getUsername());
			preparedStatement.setInt(3, usuario.getPassword());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(1, usuario.getId());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public List<Users> selectAll(){
		List <Users> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				usuarios.add(new Users(password, username, id, email));
			}
			
		}catch(SQLException e) {
			
		}
		
		return usuarios;
 	}

	
	
	

}
