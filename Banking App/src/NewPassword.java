


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPassword
 */
public class NewPassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String npw=request.getParameter("npw");
			HttpSession session=request.getSession();
			String toEmail=(String)session.getAttribute("toEmail");
			DAOModel dm=new DAOModel();
			boolean b=dm.forgotPassword(npw,toEmail);
			if(b==true)
			{
				response.sendRedirect("/BANKAP/successPasswordChange.jsp");
			}
			else
			{
				response.sendRedirect("/BANKAP/failurePasswordChange.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
