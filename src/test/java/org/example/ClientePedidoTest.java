package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientePedidoTest {
    @Test
    public void testNotificacaoClientePedidoAceito() {
        Cliente cliente = new Cliente("Renzo");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);

        clientePedido.addObserver(cliente);

        pedido.aceitarPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Renzo, alteração de status do pedido para: Pedido aceito", cliente.getNotificacao());
    }

    @Test
    public void testNotificacaoClientePedidoEnviado() {
        Cliente cliente = new Cliente("Paulo");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);

        clientePedido.addObserver(cliente);

        pedido.enviarPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Paulo, alteração de status do pedido para: Pedido enviado", cliente.getNotificacao());
    }
}