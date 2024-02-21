package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SellerDao;
import Dto.SellerDto;

@WebServlet("/signup")
public class Signup extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("seller_id"));
		String name = req.getParameter("seller_name");
		long contact = Long.parseLong(req.getParameter("seller_contact"));
		String email = req.getParameter("seller_email");
		String password = req.getParameter("seller_password");
		
		SellerDto sdt = new SellerDto();
		sdt.setId(id);
		sdt.setName(name);
		sdt.setContact(contact);
		sdt.setEmail(email);
		sdt.setPassword(password);
		
		SellerDao sda = new SellerDao();
		
		
		try {
			int res = sda.addSeller(sdt);
			if(res==1)
			{
				req.setAttribute("message", "Signup success!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Signup failed!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		SellerDto seller = new SellerDto();
//		
//		int id = Integer.parseInt(req.getParameter("seller_id"));
//		String name = req.getParameter("seller_name");
//		long contact = Long.parseLong(req.getParameter("seller_contact"));
//		String email = req.getParameter("seller_email");
//		String password = req.getParameter("seller_password");
//		
//		seller.setId(id);
//		seller.setName(name);
//		seller.setContact(contact);
//		seller.setEmail(email);
//		seller.setPassword(password);
//		
//		SellerDao s = new SellerDao();
//		
//		
//		try {
//			 s.addSeller(seller);
//			 RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//			 dispatcher.include(req, resp);
//			if(res == 1)
//			{
//				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//				dispatcher.include(req, resp);
//			}
//			else
//			{
//				req.setAttribute("message", "Signup failed!");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//				dispatcher.include(req, resp);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
}
