package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Dao.SellerDao;
import Dto.SellerDto;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("s_email");
		String password = req.getParameter("s_password");
		
		SellerDao sdao = new SellerDao();
		ProductDao pdao = new ProductDao();
		try {
			SellerDto seller = sdao.getByEmail(email);
			
			if(seller != null)
			{
				if(seller.getPassword().equals(password))
				{
					HttpSession session = req.getSession();
					session.setAttribute("email", email);
					req.setAttribute("products", pdao.getAllProducts());
					RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Wrong password!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("warning", "Wrong email!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(!email.contains("@gmail.com"))
//		{
//			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//			dispatcher.forward(req, resp);
//			PrintWriter pw = resp.getWriter();
//			pw.println("Invalid email!");
//		}
//		if(password == null || password.isEmpty())
//		{
//			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//			dispatcher.forward(req, resp);
//			PrintWriter pw = resp.getWriter();
//			pw.println("Wrong password!");
//		}
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
//			
//			PreparedStatement pst = conn.prepareStatement("select * from seller");
//			
//			ResultSet rs = pst.executeQuery();
//		
//			boolean isValidSeller = false;
//			
//			while(rs.next())
//			{
//				if(rs.getString(4).equals(email) && rs.getString(5).equals(password))
//				{
//					isValidSeller = true;
//					RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
//					dispatcher.forward(req, resp); 
//				}	
//			}
//			
//			if(!isValidSeller)
//			{
//				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//				dispatcher.forward(req, resp);
//			}
//			
//			
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		
	}
}
