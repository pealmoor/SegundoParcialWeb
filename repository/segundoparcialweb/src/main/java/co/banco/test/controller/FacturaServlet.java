package co.banco.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.banco.test.modelo.Bill;





/**
 * Servlet implementation class SendEmail
 */
@WebServlet({ "/SendEmail", "/EnviarEmail" })
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<table><tr><th>Encabezado 1</th><th>Encabezado 2</th></tr></table>")
		.append("<tr><td>"+request.getContextPath()+"</td><td>Algo</td></tr>")
		.append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String date = request.getParameter("date");;
		String user_id=request.getParameter("user_id");
		String value=request.getParameter("value");
		String type=request.getParameter("type");
		String observation=request.getParameter("observation");
		
		
		Bill b = new Bill();
		
		b.setDate(date);
		b.setUser_Id(user_id);
		b.setValue(value);
		b.setType(type);
		b.setObservation(observation);
		
		
		
		response.sendRedirect("list");

	}

}
