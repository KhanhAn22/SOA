
package ctu.cit;


import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;

import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

public class RestCalcServiceClient {

	
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		URI uri = UriBuilder.fromUri(
				"http://localhost:8080/ComplexCalService").build();
//				 http://localhost:8080/CalServiceRestProject
		
		WebTarget target = client.target(uri);
		

		String plainAnswerMu = 
				target.path("rest").path("calc")
				.path("mu").path("2").path("3")
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		String plainAnswerGiaiThua = 
				target.path("rest").path("calc")
				.path("giaithua").path("3")
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
	
		System.out.println("Mu: " + plainAnswerMu);
		System.out.println("Giai Thua: " + plainAnswerGiaiThua);
				
		
	}
}
