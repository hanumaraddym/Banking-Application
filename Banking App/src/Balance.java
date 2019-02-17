


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session=request.getSession();
		    int accno=(int)session.getAttribute("accno");
		    DAOModel dm=new DAOModel();
		    dm.setAccno(accno);
		    boolean b=dm.balance();
		    int balance=dm.getBalance();
		    session.setAttribute("balance",balance);
		    if(b==true)
		    {
		    	response.sendRedirect("/BANKAP/balanceSuccess.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("/BANKAP/balanceFailure.jsp");
		    }
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}

