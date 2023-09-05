package com.fernantech.reserva;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fernantech.cliente.Cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/reserva-cli")
public class ReservaResource {
    
    @Inject
    @RestClient
    ReservaService reservaService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public String newReserva() {
        Cliente cliente = Cliente.of(2,"Maria");
        Reserva reserva = Reserva.of(cliente);
        return this.reservaService.newReserva(reserva);
    }

}
