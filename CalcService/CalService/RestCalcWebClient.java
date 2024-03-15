package ctu.cit;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class RestCalcWebClient
 */
@WebServlet("/CalcWebClient")
public class RestCalcWebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final URI uri = UriBuilder.fromUri("http://localhost:8080/CalService").build();
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);

	WebTarget target = client.target(uri);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestCalcWebClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			out.println("<html><head><title>Input Numbers</title></head><body>");
			out.println("<h1>Restful Calculator Service:</h2>");
			out.println("<form method='post'>");
			out.println("Nhap so A: <input type='text' name='numA'><br>");
			out.println("Nhap so B: <input type='text' name='numB'><br>");

			out.println("<select name='pheptinh' id='pheptinh'>");
			out.println("<option value='cong'>a+b</option>");
			out.println("<option value='nhan'>a*b</option>");
			out.println("<option value='mu'>a^b</option>");
			out.println("<option value='giaithua'>a!</option>");


			out.println("</select><br>");

			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			String a = "0", b = "0";
			String plainAnswer = "";
			
			String test = "no";
			try {
				if (request.getParameter("numA") != null && request.getParameter("numB") != "") {
					a = request.getParameter("numA");
					b = request.getParameter("numB");
				}
				
				if (request.getParameter("pheptinh").compareTo("cong") == 0) {
					
					plainAnswer = target.path("rest").path("calc")
							.path("cong").path(a).path(b)
							.request().accept(MediaType.TEXT_PLAIN)
							.get(String.class);
					out.print("<h3> " + a + " + " + b + " = " + plainAnswer + "</h3>");

				} else if (request.getParameter("pheptinh").compareTo("nhan") == 0) {

					plainAnswer = target.path("rest").path("calc")
							.path("nhan").path(a).path(b)
							.request().accept(MediaType.TEXT_PLAIN)
							.get(String.class);
					out.print("<h3> " + a + " * " + b + " = " + plainAnswer + "</h3>");

				} else if (request.getParameter("pheptinh").compareTo("mu") == 0) {

					plainAnswer = target.path("rest").path("calc")
							.path("mu").path(a).path(b)
							.request().accept(MediaType.TEXT_PLAIN)
							.get(String.class);
					out.print("<h3> " + a + " ^ " + b + " = " + plainAnswer + "</h3>");

				} else if (request.getParameter("pheptinh").compareTo("giaithua") == 0) {

					plainAnswer = target.path("rest").path("calc")
							.path("giaithua").path(a)
							.request().accept(MediaType.TEXT_PLAIN)
							.get(String.class);
					out.print("<h3> " + a + " !  = " + plainAnswer + "</h3>");

				}
				
				
			} catch (Exception e) {
				out.print("nhap so khong hop le");
			}
			
			
			

			if(test.compareTo("yes") == 0) {
				out.print("Nhap so khong hop le");
			}
			out.println("</body></html>");
		} finally {
			out.close();
		}
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		doGet(request, response);
	}

}