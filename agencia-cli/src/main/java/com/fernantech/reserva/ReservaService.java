package com.fernantech.reserva;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.fernantech.cliente.Cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8182/reserva")
public interface ReservaService {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newReserva(Reserva reserva);

}
