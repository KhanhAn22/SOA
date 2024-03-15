package ctu.cit;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.Math;

@Path("calc")
public class RestCalcService {
	
	@GET
	@Path("/mu/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public long mu(@PathParam("a") double a, @PathParam("b") double b) {
		double result = Math.pow(a, b);
		String formattedResult = String.format("%.0f", result); // Convert to string with no decimal places
		return Long.parseLong(formattedResult);
	}
	
	@GET
	@Path("/giaithua/{n}")
	@Produces(MediaType.TEXT_PLAIN)
	public long giaithua(@PathParam("n") int n) {
		
//		return 5;
//		
		System.out.println("so n " + n);
		if(n == 0) {
			return 1;
		} else {
			return n * giaithua(n-1);
		}
		
		long giai_thua = 1;
        if (n == 0 || n == 1) {
            return giai_thua;
        } else {
            for (int i = 2; i <= n; i++) {
                giai_thua *= i;
            }
            return giai_thua;
        }
	}
	
}
