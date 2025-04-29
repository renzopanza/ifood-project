package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String notificacao;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNotificacao(){
        return this.notificacao;
    }

    public void realizarPedido(ClientePedido clientePedido){
        clientePedido.addObserver(this);
    }

    @Override
    public void update(Observable clientePedido, Object estadoPedido) {
        this.notificacao = this.nome + ", alteração de status do pedido para: " + estadoPedido;
    }
}
