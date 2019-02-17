


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Home extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		
		
			int cusID=Integer.parseInt(request.getParameter("cusID"));
			String cusPwd=request.getParameter("cusPwd");
			
			DAOModel dm=new DAOModel();
			dm.setCusID(cusID);
			dm.setCusPwd(cusPwd);
			boolean b=dm.verify();
			int accno=dm.getAccno();
			HttpSession session=request.getSession(true);
			session.setAttribute("accno",accno);
			if(b==true)
			{
				response.sendRedirect("/BANKAP/success.jsp");
			}
			else
			{
				response.sendRedirect("/BANKAP/failure.jsp");
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

	private String getCustomerName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
	
