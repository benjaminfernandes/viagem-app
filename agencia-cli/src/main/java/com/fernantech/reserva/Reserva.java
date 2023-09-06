package com.fernantech.reserva;

public class Reserva {

    private long id;
    private long clienteId;

    public static Reserva of(long id, long clienteId) {
        return new Reserva(id, clienteId);
    }

    public Reserva() {
    }

    private Reserva(long id, long clienteId) {
        this.id = id;
        this.clienteId = clienteId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }



}
