package org.example;

public interface IPedido {
    boolean efetuarPedido();
    boolean aceitarPedido();
    boolean negarPedido();
    boolean prepararPedido();
    boolean enviarPedido();
    boolean receberPedido();
    boolean cancelarPedido();
    String getDescricao();
    void setDescricao(String descricao);
    String getPedidoEstadoNome();
}
