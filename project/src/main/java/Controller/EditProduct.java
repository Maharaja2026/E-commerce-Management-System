package Controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import Dao.ProductDao;
import Dto.ProductDto;

@WebServlet("/editproduct")
@MultipartConfig(maxFileSize = 1024*1024*5)
public class EditProduct extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String brand = req.getParameter("brand");
		double discount = Double.parseDouble(req.getParameter("discount"));
	    Part image = req.getPart("image");
		
		ProductDto product = new ProductDto();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setBrand(brand);
		product.setDiscount(discount);
		product.setImage(image.getInputStream().readAllBytes());
		
		ProductDao pdao = new ProductDao();
		
		try {
			if(image.getSize()>1)
			{
				pdao.updateProduct(product);
				req.setAttribute("products", pdao.getAllProducts());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				ProductDto oldProduct = pdao.getProductById(product);
				byte[] img = oldProduct.getImage();
				product.setImage(img);
				
				pdao.updateProduct(product);
				req.setAttribute("products", pdao.getAllProducts());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
