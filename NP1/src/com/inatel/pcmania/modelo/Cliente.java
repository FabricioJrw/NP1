package com.inatel.pcmania.modelo;

public class Cliente {

    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int quantidadeComputadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[2];
        this.quantidadeComputadores = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void addComputador(Computador computador) {
        if (quantidadeComputadores == computadores.length) {
            Computador[] novoArray = new Computador[computadores.length * 2];
            System.arraycopy(computadores, 0, novoArray, 0, computadores.length);
            computadores = novoArray;
        }
        computadores[quantidadeComputadores] = computador;
        quantidadeComputadores++;
    }

    public Computador[] getComputadores() {
        Computador[] copia = new Computador[quantidadeComputadores];
        System.arraycopy(computadores, 0, copia, 0, quantidadeComputadores);
        return copia;
    }

    public float calculaTotalCompra() {
        float total = 0f;
        for (int i = 0; i < quantidadeComputadores; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }
}