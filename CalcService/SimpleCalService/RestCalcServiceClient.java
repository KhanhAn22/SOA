
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
				"http://localhost:8080/SimpleCalService").build();
//				 http://localhost:8080/CalServiceRestProject
		
		WebTarget target = client.target(uri);
		

		String plainAnswerCong = 
				target.path("rest").path("calc")
				.path("cong").path("7").path("5")
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		String plainAnswerNhan = 
				target.path("rest").path("calc")
				.path("nhan").path("7").path("5")
				.request().accept(MediaType.TEXT_PLAIN)
				.get(String.class);
	
		System.out.println("Cong: " + plainAnswerCong);
		System.out.println("Nhan: " + plainAnswerNhan);
				
		
	}
}
