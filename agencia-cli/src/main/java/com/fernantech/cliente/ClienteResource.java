package com.fernantech.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/cliente-cli")
public class ClienteResource {
    
    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("newCliente")
    public Response newCliente() {
        Cliente cliente = Cliente.of(88, "TEste");
        Response response = clienteService.newCliente(cliente);
        return Response.status(Status.CREATED).entity(response).build();
    }

}
