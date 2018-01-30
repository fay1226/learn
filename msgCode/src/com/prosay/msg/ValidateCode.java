package com.prosay.msg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCode
 */
@WebServlet("/ValidateCode")
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String codeInSession = request.getSession().getAttribute("code").toString();
		if(code.equals(codeInSession)){
			response.getWriter().print("true!successfully!");
		}else{
			response.getWriter().print("false!fail!");
		}
	}

}
