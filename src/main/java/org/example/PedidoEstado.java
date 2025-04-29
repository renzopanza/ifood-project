package org.example;

public abstract class PedidoEstado {
    public abstract String getEstadoPedido();

    public boolean efetuarPedido(Pedido pedido){
        return false;
    }
    public boolean aceitarPedido(Pedido pedido){
        return false;
    }
    public boolean negarPedido(Pedido pedido){
        return false;
    }
    public boolean prepararPedido(Pedido pedido){
        return false;
    }
    public boolean enviarPedido(Pedido pedido){
        return false;
    }
    public boolean receberPedido(Pedido pedido){
        return false;
    }
    public boolean cancelarPedido(Pedido pedido){
        return false;
    }
}
