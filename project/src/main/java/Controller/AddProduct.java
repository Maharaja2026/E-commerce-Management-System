package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import Dao.ProductDao;
import Dto.ProductDto;

@WebServlet("/addproduct")
@MultipartConfig(maxFileSize = 1024*1024*5)
public class AddProduct extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("product_id"));
		String name = req.getParameter("product_name");
		double price = Double.parseDouble(req.getParameter("product_price"));
		String brand = req.getParameter("product_name");
		double discount = Double.parseDouble(req.getParameter("product_discount"));
		Part image = req.getPart("product_image");
		
		ProductDto product = new ProductDto();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setBrand(brand);
		product.setDiscount(discount);
		product.setImage(image.getInputStream().readAllBytes());
		
		ProductDao p = new ProductDao();
		
		try {
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			if(email != null)
			{
				p.addProduct(product);
	            req.setAttribute("products", p.getAllProducts());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("login_msg", "Login Required");
				RequestDispatcher dispatcher = req.getRequestDispatcher("addproduct.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
 
}
