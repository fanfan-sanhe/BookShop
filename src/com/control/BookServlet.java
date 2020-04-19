package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.BookBean;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookBean p=new BookBean();
		p.setName(request.getParameter("name"));
		p.setPrice(Double.valueOf(request.getParameter("price")));
		p.setPnum(Integer.valueOf(request.getParameter("pnum")));
		p.setCategory(request.getParameter("category"));
		p.setImgurl(request.getParameter("imgurl"));
		p.setDescription(request.getParameter("description"));
		BookService productsService=new BookServiceImpl();
		int b=productsService.add(p);
		if(b>0)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("add.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
