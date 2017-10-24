package com.bridgeit.webApplication.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * Servlet Filter implementation class AuthenticateFilter
 */
public class AuthenticateFilter implements Filter {

	static Logger logger=Logger.getLogger(AuthenticateFilter.class);

    /**
     * Default constructor. 
     */
    public AuthenticateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		 logger.info("filter is destroy ");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter test");
		logger.info("inside filter");
		 logger.error("in the filter");
		 HttpServletResponse httpResponse=(HttpServletResponse) response;
		 httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		 httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		 httpResponse.setDateHeader("Expires", 0); // Proxies.
		 logger.error("browser cache is removed");

		 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 logger.info("filter intiated ");

	}

}
