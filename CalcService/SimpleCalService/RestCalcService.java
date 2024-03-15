package ctu.cit;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calc")
public class RestCalcService {
	
	@GET
	@Path("/cong/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
		return ( a + b ) + "";
	}
	
	@GET
	@Path("/nhan/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String nhan(@PathParam("a") double a, @PathParam("b") double b) {
		return ( a * b ) + "";
	}
	
}
