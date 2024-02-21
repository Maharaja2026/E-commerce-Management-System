package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Dto.SellerDto;

public class SellerDao
{
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	}
	public int addSeller(SellerDto seller) throws ClassNotFoundException, SQLException
	{ 
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("insert into seller values(?,?,?,?,?)");
		
		pst.setInt(1,seller.getId());
		pst.setString(2, seller.getName());
		pst.setLong(3, seller.getContact());
		pst.setString(4, seller.getEmail());
		pst.setString(5, seller.getPassword());
		
		int res = pst.executeUpdate();
		conn.close();
		return res;
	}
	
	public SellerDto getById(int id) throws SQLException, ClassNotFoundException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from seller where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		SellerDto seller = new SellerDto();
		rs.next();
		seller.setId(rs.getInt(1));
		seller.setName(rs.getString(2));
		seller.setContact(rs.getLong(3));
		seller.setEmail(rs.getString(4));
		
		conn.close();
		return seller;
	}
	
	public SellerDto getByEmail(String email) throws ClassNotFoundException, SQLException 
	{
            Connection conn = getConnection();
			
			PreparedStatement pst = conn.prepareStatement("select * from seller where email=?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next())
			{
				SellerDto seller = new SellerDto();
				seller.setId(rs.getInt(1));
				seller.setName(rs.getString(2));
				seller.setContact(rs.getLong(3));
				seller.setEmail(rs.getString(4));
				seller.setPassword(rs.getString(5));
				conn.close();
				return seller;
			}
			else
			{
				SellerDto seller = null;
				return seller;
			}
		
			
			
	}
	
	public List<SellerDto> getAllSellers() throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from seller");
		ResultSet rs = pst.executeQuery();
		
		List<SellerDto> rows = new LinkedList<>();		
		
		while(rs.next())
		{
			SellerDto seller = new SellerDto();
			seller.setId(rs.getInt(1));
			seller.setName(rs.getString(2));
			seller.setContact(rs.getLong(3));
			seller.setEmail(rs.getString(4));
			rows.add(seller);
		}
		
		conn.close();
		return rows;
	}
	
	public int updateSeller(SellerDto sdt) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("update seller set name=?,contact=?,email=?,password=? where id=?");
		pst.setString(1,sdt.getName());
		pst.setLong(2,sdt.getContact());
		pst.setString(3, sdt.getEmail());
		pst.setString(4, sdt.getPassword());
		pst.setInt(5, sdt.getId());
		
		return pst.executeUpdate();
	}
	
	public int deleteSeller(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("delete from seller where id=?");
		pst.setInt(1, id);
	    return pst.executeUpdate();
	}
}
