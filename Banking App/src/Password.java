


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Password
 */
public class Password extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String opw=request.getParameter("opw");
			String npw=request.getParameter("npw");
			DAOModel dm=new DAOModel();
			dm.setCusPwd(opw);
			boolean b=dm.change(npw);
			if(b==true)
			{
				response.sendRedirect("/BANKAP/passwordSuccess.jsp");
				 
			}
			else
			{
				response.sendRedirect("/BANKAP/passwordFailure.jsp");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
					
					
		}
	}
		