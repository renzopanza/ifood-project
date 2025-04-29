package org.example;

import java.util.Observable;

public class ClientePedido extends Observable {
    public Cliente cliente;
    public Pedido pedido;

    public ClientePedido(Cliente cliente, Pedido pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void atualizarEstadoPedido(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "Estado do pedido: " + pedido.getPedidoEstadoNome();
    }

}
