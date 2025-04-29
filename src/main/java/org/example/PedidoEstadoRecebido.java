package org.example;

public class PedidoEstadoRecebido extends PedidoEstado{
    private PedidoEstadoRecebido(){}
    private static PedidoEstadoRecebido instance = new PedidoEstadoRecebido();
    public static PedidoEstadoRecebido getInstance(){
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido recebido";
    }
}
