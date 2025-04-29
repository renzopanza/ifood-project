package org.example;

public class Pedido implements IPedido{
    private String descricao;
    private PedidoEstado pedidoEstado;

    public Pedido() {
        this.pedidoEstado = PedidoEstadoEfetuado.getInstance();
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado){
        this.pedidoEstado = pedidoEstado;
    }

    public boolean efetuarPedido() {
        return pedidoEstado.efetuarPedido(this);
    }

    public boolean aceitarPedido() {
        return pedidoEstado.aceitarPedido(this);
    }

    public boolean cancelarPedido() {
        return pedidoEstado.cancelarPedido(this);
    }

    public boolean receberPedido() {
        return pedidoEstado.receberPedido(this);
    }

    public boolean enviarPedido() {
        return pedidoEstado.enviarPedido(this);
    }

    public boolean prepararPedido() {
        return pedidoEstado.prepararPedido(this);
    }

    public boolean negarPedido() {
        return pedidoEstado.negarPedido(this);
    }

    public String getPedidoEstadoNome() {
        return pedidoEstado.getEstadoPedido();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public PedidoEstado getPedidoEstado() {
        return pedidoEstado;
    }
}
