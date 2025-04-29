package org.example;

public class PedidoEstadoAceito extends PedidoEstado {
    private PedidoEstadoAceito(){}
    private static PedidoEstadoAceito instance = new PedidoEstadoAceito();
    public static PedidoEstadoAceito getInstance(){
        return instance;
    }

    public String getEstadoPedido() {
        return "Pedido aceito";
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
