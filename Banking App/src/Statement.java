


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Statement
 */
public class Statement extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session=request.getSession();
			int accno=(int)session.getAttribute("accno");
			DAOModel dm=new DAOModel();
			ArrayList al=dm.statement(accno);
			session.setAttribute("al",al);
			if(al!=null)
			{
				response.sendRedirect("/BANKAP/successStatement.jsp");
			}
			else
			{
				response.sendRedirect("/BANKAP/failureStatement.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
