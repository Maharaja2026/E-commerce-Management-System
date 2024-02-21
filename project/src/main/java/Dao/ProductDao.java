package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import Dto.ProductDto;
import Dto.SellerDto;

public class ProductDao
{
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	}
	
	public int addProduct(ProductDto pdt) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
		
		pst.setInt(1, pdt.getId());
		pst.setString(2, pdt.getName());
		pst.setDouble(3, pdt.getPrice());
		pst.setString(4, pdt.getBrand());
		pst.setDouble(5, pdt.getDiscount());
		Blob image = new SerialBlob(pdt.getImage());
		pst.setBlob(6, image);
	
		int res = pst.executeUpdate();
		conn.close();
		return res;
	}

	public int updateProduct(ProductDto pdt) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("update product set name=?,price=?,brand=?,discount=?,image=? where id=?");
		
		pst.setString(1, pdt.getName());
		pst.setDouble(2, pdt.getPrice());
		pst.setString(3, pdt.getBrand());
		pst.setDouble(4, pdt.getDiscount());
		Blob image = new SerialBlob(pdt.getImage());
		pst.setBlob(5, image);
		pst.setInt(6, pdt.getId());
	
		int res = pst.executeUpdate();
		conn.close();
		return res; 
	}
	
	public int deleteProduct(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("delete from product where id=?");
		pst.setInt(1, id);
		
		int res = pst.executeUpdate();
		conn.close();
		return res;
	}
	 
	public ProductDto getProductById(ProductDto pdt) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from product where id=?");
		pst.setInt(1, pdt.getId());
		
		ResultSet rs = pst.executeQuery();
		ProductDto product = new ProductDto();
		rs.next();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		product.setBrand(rs.getString(4));
		product.setDiscount(rs.getDouble(5));
		Blob blob = rs.getBlob(6);
		byte[] image=blob.getBytes(1,(int)blob.length());
		product.setImage(image);
		
		conn.close();
		return product;
	}
	
	public List<ProductDto> getAllProducts() throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from product");
		
		ResultSet rs = pst.executeQuery();
		List<ProductDto> products = new ArrayList<ProductDto>();
		
		while(rs.next())
		{
			ProductDto product = new ProductDto();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setBrand(rs.getString(4));
			product.setDiscount(rs.getDouble(5));
			Blob blob = rs.getBlob(6);  
			if(blob != null)
			{
				byte[] image = blob.getBytes(1, (int)blob.length());
				product.setImage(image);
			}
			else
			{
				product.setImage(null);		
			}
			products.add(product);	
		}
		
		conn.close();
		return products;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			
			ProductDao dao = new ProductDao();
			
			List<ProductDto> ps = dao.getAllProducts();
			for(ProductDto d : ps) {
				System.out.println(d);
			}
	}
}



	
		
	




