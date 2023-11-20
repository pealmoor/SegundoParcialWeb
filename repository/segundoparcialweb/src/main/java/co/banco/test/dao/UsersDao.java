package co.banco.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.banco.test.modelo.Users;
import co.empresa.test.modelo.Usuario;

public interface UsersDao {
	public void insert(Users usuario) throws SQLException;
	public Usuario select(int id);
	public List <Users> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Users usuario) throws SQLException;
}
