package com.fernantech.cliente;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public Cliente findById(@QueryParam("id") long id);

}
