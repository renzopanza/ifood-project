package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    public void testarMudancaDoEstadoDoPedidoParaEfetuado() {
        Pedido pedido = new Pedido();
        assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaAceito() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.aceitarPedido());
        assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaPreparo() {
        Pedido pedido = new Pedido();
        pedido.aceitarPedido();
        assertTrue(pedido.prepararPedido());
        assertEquals("Pedido sendo preparado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoDeParaEnviado() {
        Pedido pedido = new Pedido();
        pedido.aceitarPedido();
        pedido.prepararPedido();
        assertTrue(pedido.enviarPedido());
        assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaRecebido() {
        Pedido pedido = new Pedido();
        pedido.aceitarPedido();
        pedido.prepararPedido();
        pedido.enviarPedido();
        assertTrue(pedido.receberPedido());
        assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaCancelado() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.cancelarPedido());
        assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaNegado() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.negarPedido());
        assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDeEstadoDoPedidoParaAceitacaoNaoPermitidaDepoisDeNegado() {
        Pedido pedido = new Pedido();
        pedido.negarPedido();
        assertFalse(pedido.aceitarPedido());
        assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
    }

    @Test
    public void testarMudancaDeEstadoDoPeididoParaDuplaAceitacao() {
        Pedido pedido = new Pedido();
        pedido.aceitarPedido();
        assertFalse(pedido.aceitarPedido());
        assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
    }
}
