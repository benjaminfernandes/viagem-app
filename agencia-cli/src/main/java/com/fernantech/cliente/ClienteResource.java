package com.fernantech.cliente;

import java.time.temporal.ChronoUnit;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/cliente-cli")
public class ClienteResource {
    
    @Inject
    @RestClient
    ClienteService clienteService;


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)//Aguarda até 3s o retorno da chamada 
    @Fallback(fallbackMethod = "fallback")//chama o método ao dar timeout
    @CircuitBreaker(
        requestVolumeThreshold = 4,
        failureRatio = .5,
        delay = 6000,
        successThreshold = 1
    )
    public Cliente findById(@QueryParam("id") long id) {
        return clienteService.findById(id);
    }

    @GET
    @Path("newCliente")
    public String newCliente() {
        Cliente cliente = Cliente.of(88, "Remoto");
        return clienteService.newCliente(cliente);
    }

    private Cliente fallback(long id){
        return Cliente.of(0, "");
    }

}
