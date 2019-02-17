


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TransferFilter
 */
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int amttransf=Integer.parseInt(request.getParameter("amttransf"));
		if(amttransf<=0)
		{
			((HttpServletResponse) response).sendRedirect("/BANKAP/errorTransfer.jsp");
		}
		else
		{

		chain.doFilter(request, response);
	}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
