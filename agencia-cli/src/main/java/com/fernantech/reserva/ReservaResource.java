package com.fernantech.reserva;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fernantech.cliente.ClienteService;

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

    @Inject
    @RestClient
    ClienteService clienteService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public String newReserva() {
        Reserva reserva = Reserva.of(0, 2);
        return this.reservaService.newReserva(reserva);
    }

}
