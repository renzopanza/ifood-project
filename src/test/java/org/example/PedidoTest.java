package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    @Test
    public void testarMudancaDoEstadoDoPedidoParaEfetuado(){
        Pedido pedido = new Pedido();

        assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaAceito(){
        Pedido pedido = new Pedido();

        pedido.aceitarPedido();
        assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
    }
}