


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			
		
		int amttransf=Integer.parseInt(request.getParameter("amttransf"));
		DAOModel dm=new DAOModel();
		HttpSession session=request.getSession();
		int accno=(int)session.getAttribute("accno");
		dm.setAccno(accno);
		boolean b=dm.transfer(amttransf);
		if(b==true)
		{
			response.sendRedirect("/BANKAP/transferSuccess.jsp");
			
		}
		else
		{
			response.sendRedirect("/BANKAP/transferFailure.jsp");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
				
	}
}
