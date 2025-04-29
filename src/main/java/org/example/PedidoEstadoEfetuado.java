package org.example;

public class PedidoEstadoEfetuado extends PedidoEstado{
    private PedidoEstadoEfetuado(){};
    private static PedidoEstadoEfetuado instance = new PedidoEstadoEfetuado();
    public static PedidoEstadoEfetuado getInstance(){
        return instance;
    }
    public String getEstadoPedido(){
        return "Pedido Efetuado";
    }
    public boolean aceitarPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstance());
        return true;
    }
    public boolean negarPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoNegado.getInstance());
        return true;
    }
    public boolean prepararPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoPreparando.getInstance());
        return true;
    }
    public boolean enviarPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoEnviado.getInstance());
        return true;
    }
    public boolean cancelarPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
    public boolean receberPedido(Pedido pedido){
        pedido.setPedidoEstado(PedidoEstadoRecebido.getInstance());
        return true;
    }
}
