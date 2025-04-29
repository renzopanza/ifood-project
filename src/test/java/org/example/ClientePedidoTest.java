package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientePedidoTest {

    @Test
    public void testNotificacaoClientePedidoEfetuado() {
        Cliente cliente = new Cliente("Gabriel");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        clientePedido.atualizarEstadoPedido();

        assertEquals("Gabriel, alteração de status do pedido para: Pedido Efetuado", cliente.getNotificacao());
    }

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
    public void testNotificacaoClientePedidoEmPreparo() {
        Cliente cliente = new Cliente("Carlos");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        pedido.aceitarPedido();
        pedido.prepararPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Carlos, alteração de status do pedido para: Pedido em preparo", cliente.getNotificacao());
    }

    @Test
    public void testNotificacaoClientePedidoEnviado() {
        Cliente cliente = new Cliente("Paulo");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        pedido.aceitarPedido();
        pedido.prepararPedido();
        pedido.enviarPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Paulo, alteração de status do pedido para: Pedido enviado", cliente.getNotificacao());
    }

    @Test
    public void testNotificacaoClientePedidoRecebido() {
        Cliente cliente = new Cliente("Bruna");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        pedido.aceitarPedido();
        pedido.prepararPedido();
        pedido.enviarPedido();
        pedido.receberPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Bruna, alteração de status do pedido para: Pedido recebido", cliente.getNotificacao());
    }

    @Test
    public void testNotificacaoClientePedidoCancelado() {
        Cliente cliente = new Cliente("Lucas");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        pedido.cancelarPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Lucas, alteração de status do pedido para: Pedido cancelado", cliente.getNotificacao());
    }

    @Test
    public void testNotificacaoClientePedidoNegado() {
        Cliente cliente = new Cliente("Fernanda");
        Pedido pedido = new Pedido();
        ClientePedido clientePedido = new ClientePedido(cliente, pedido);
        clientePedido.addObserver(cliente);

        pedido.negarPedido();
        clientePedido.atualizarEstadoPedido();

        assertEquals("Fernanda, alteração de status do pedido para: Pedido negado", cliente.getNotificacao());
    }
}
