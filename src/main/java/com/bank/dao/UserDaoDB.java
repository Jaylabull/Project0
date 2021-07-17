package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class UserDaoDB implements UserDao{
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM users";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			return userList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}//End getAllUsers Method
	
@Override
	public User getUserByUsername(String userName) {
		User user = new User();
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE users.username = '" + userName + "'";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setUserName(rs.getString(5));
				user.setPassword(rs.getString(6));
				
			}
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return user;
		
	}//End getUserByUsername Method
	
	//PREPARED STATEMENTS 
@Override
	public void createUser(User u) throws SQLException {
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO users(id, firstname, lastname, email, username, password) values"
					+ "(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getUserName());
			ps.setString(6, u.getPassword());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
	}//End createUser Method
	
	@Override
	public void updateUser(User u) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? "
					+ " WHERE users.id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getUserName());
			ps.setString(6, u.getPassword());
			ps.setInt(1, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}//End updateUser Class
	
	@Override
	public void deleteUser(User u) {
		try {	
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM users WHERE users.id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
	}
	
}//End UserDaoDB
