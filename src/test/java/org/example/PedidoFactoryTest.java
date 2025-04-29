package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoFactoryTest {
    @Test
    public void testarCriacaoDoPedido() {
        PedidoFactory pedidoFactory = new PedidoFactory();
        Pedido pedido = pedidoFactory.criarPedido();

        assertNotNull(pedido);
        assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
    }
}