package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    public void testarMudancaDoEstadoDoPedidoParaEfetuado() {
        try {
            Pedido pedido = new Pedido();
            assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaAceito() {
        try {
            Pedido pedido = new Pedido();
            assertTrue(pedido.aceitarPedido());
            assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaPreparo() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            assertTrue(pedido.prepararPedido());
            assertEquals("Pedido em preparo", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoDeParaEnviado() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertTrue(pedido.enviarPedido());
            assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaRecebido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            assertTrue(pedido.receberPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaCancelado() {
        try {
            Pedido pedido = new Pedido();
            assertTrue(pedido.cancelarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDoEstadoDoPedidoParaNegado() {
        try {
            Pedido pedido = new Pedido();
            assertTrue(pedido.negarPedido());
            assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDeEstadoDoPedidoParaCancelamentoNaoPermitidoAposEnvio() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            assertFalse(pedido.cancelarPedido());
            assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDeEstadoDoPedidoParaAceitacaoNaoPermitidaDepoisDeNegado() {
        try {
            Pedido pedido = new Pedido();
            pedido.negarPedido();
            assertFalse(pedido.aceitarPedido());
            assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDeEstadoDoPedidoParaRecebimentoSemEnvio() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertFalse(pedido.receberPedido());
            assertEquals("Pedido em preparo", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarMudancaDeEstadoDoPeididoParaDuplaAceitacao() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            assertFalse(pedido.aceitarPedido());
            assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarPrepararPedidoSemAceitar() {
        try {
            Pedido pedido = new Pedido();
            assertFalse(pedido.prepararPedido());
            assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEnviarPedidoSemPreparo() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            assertFalse(pedido.enviarPedido());
            assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarReceberPedidoSemEnvio() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertFalse(pedido.receberPedido());
            assertEquals("Pedido em preparo", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarNegarPedidoDepoisDeAceito() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido aceito", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCancelarPedidoDepoisDeRecebido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.cancelarPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarDuploPreparoDePedido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertFalse(pedido.prepararPedido());
            assertEquals("Pedido em preparo", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarDuploEnvioDePedido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            assertFalse(pedido.enviarPedido());
            assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarNegarPedidoDepoisDeCancelado() {
        try {
            Pedido pedido = new Pedido();
            pedido.cancelarPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarReceberPedidoDuasVezes() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.receberPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarNegarPedidoDepoisDePreparar() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido em preparo", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCancelarPedidoDepoisDePreparar() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            assertTrue(pedido.cancelarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarAceitarPedidoDepoisDeReceber() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.aceitarPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarReceberPedidoAposNegado() {
        try {
            Pedido pedido = new Pedido();
            pedido.negarPedido();
            assertFalse(pedido.receberPedido());
            assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCancelarPedidoDepoisDeAceitarEMandar() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            assertFalse(pedido.cancelarPedido());
            assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarFluxoCompletoComCancelamentoValido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            assertTrue(pedido.cancelarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarFluxoNegacaoImediata() {
        try {
            Pedido pedido = new Pedido();
            assertTrue(pedido.negarPedido());
            assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEstadosNaoNulosDuranteCiclo() {
        try {
            Pedido pedido = new Pedido();
            assertNotNull(pedido.getPedidoEstadoNome());
            pedido.aceitarPedido();
            assertNotNull(pedido.getPedidoEstadoNome());
            pedido.prepararPedido();
            assertNotNull(pedido.getPedidoEstadoNome());
            pedido.enviarPedido();
            assertNotNull(pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCriacaoDeNovoPedidoIndependente() {
        try {
            Pedido p1 = new Pedido();
            Pedido p2 = new Pedido();
            p1.aceitarPedido();
            p2.negarPedido();
            assertEquals("Pedido aceito", p1.getPedidoEstadoNome());
            assertEquals("Pedido negado", p2.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEstadoFinalNaoPermiteMudanca() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.cancelarPedido());
            assertFalse(pedido.aceitarPedido());
            assertFalse(pedido.prepararPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEnviarPedidoSemAceitar() {
        try {
            Pedido pedido = new Pedido();
            assertFalse(pedido.enviarPedido());
            assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarReceberPedidoSemAceitar() {
        try {
            Pedido pedido = new Pedido();
            assertFalse(pedido.receberPedido());
            assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarNegarPedidoAposEnviado() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido enviado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }
    @Test
    public void testarNegarPedidoAposRecebido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarAceitarPedidoAposCancelado() {
        try {
            Pedido pedido = new Pedido();
            pedido.cancelarPedido();
            assertFalse(pedido.aceitarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarAceitarPedidoAposRecebido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.aceitarPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCancelarPedidoSemAlterarEstado() {
        try {
            Pedido pedido = new Pedido();
            assertTrue(pedido.cancelarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarCancelarPedidoDuasVezes() {
        try {
            Pedido pedido = new Pedido();
            pedido.cancelarPedido();
            assertFalse(pedido.cancelarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarNegarPedidoDuasVezes() {
        try {
            Pedido pedido = new Pedido();
            pedido.negarPedido();
            assertFalse(pedido.negarPedido());
            assertEquals("Pedido negado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEstadoInicialDoPedido() {
        try {
            Pedido pedido = new Pedido();
            assertEquals("Pedido Efetuado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarPrepararPedidoAposRecebido() {
        try {
            Pedido pedido = new Pedido();
            pedido.aceitarPedido();
            pedido.prepararPedido();
            pedido.enviarPedido();
            pedido.receberPedido();
            assertFalse(pedido.prepararPedido());
            assertEquals("Pedido recebido", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testarEnviarPedidoAposCancelado() {
        try {
            Pedido pedido = new Pedido();
            pedido.cancelarPedido();
            assertFalse(pedido.enviarPedido());
            assertEquals("Pedido cancelado", pedido.getPedidoEstadoNome());
        } catch (Exception e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }

}
