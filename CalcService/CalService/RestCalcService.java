package ctu.cit;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

@Path("calc")
public class RestCalcService {

	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);

	@GET
	@Path("/cong/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String cong(@PathParam("a") double a, @PathParam("b") double b) {


		URI uri = UriBuilder.fromUri(
				"http://localhost:8080/SimpleCalService").build();
		
		WebTarget target = client.target(uri);
				
	    String aString = String.valueOf(a);
	    String bString = String.valueOf(b);
		return target.path("rest").path("calc")
				.path("cong").path(aString).path(bString)
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
	}

	@GET
	@Path("/nhan/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String nhan(@PathParam("a") double a, @PathParam("b") double b) {


		URI uri = UriBuilder.fromUri(
				"http://localhost:8080/SimpleCalService").build();
		
		WebTarget target = client.target(uri);
				
	    String aString = String.valueOf(a);
	    String bString = String.valueOf(b);
		return target.path("rest").path("calc")
				.path("nhan").path(aString).path(bString)
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
	}

	@GET
	@Path("/mu/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String mu(@PathParam("a") double a, @PathParam("b") double b) {


		URI uri = UriBuilder.fromUri(
				"http://localhost:8080/ComplexCalService").build();
		
		WebTarget target = client.target(uri);
				
	    String aString = String.valueOf(a);
	    String bString = String.valueOf(b);
		return target.path("rest").path("calc")
				.path("mu").path(aString).path(bString)
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);

	}

	@GET
	@Path("/giaithua/{n}")
	@Produces(MediaType.TEXT_PLAIN)
	public String giaithua(@PathParam("n") int n) {

		

		URI uri = UriBuilder.fromUri(
				"http://localhost:8080/ComplexCalService").build();
		
		WebTarget target = client.target(uri);
				
	    String nString = String.valueOf(n);
		return target.path("rest").path("calc")
				.path("giaithua").path(nString)
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);

	}
}
