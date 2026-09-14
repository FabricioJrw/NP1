package com.inatel.pcmania.modelo;

/**
 * Representa um computador vendido pela PC Mania.
 *
 * Relação de composição com HardwareBasico[] e SistemaOperacional:
 * um Computador é dono desses objetos e eles não fazem sentido fora dele.
 *
 * Relação de agregação (0..1) com MemoriaUSB: o Computador pode ou não
 * vir acompanhado de uma memória USB, adicionada após sua criação.
 */
public class Computador {

    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private SistemaOperacional so;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, HardwareBasico[] hardwares, SistemaOperacional so) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = hardwares;
        this.so = so;
        this.memoriaUSB = null;
    }

    public float getPreco() {
        return preco;
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.printf("Preco: R$ %.2f%n", preco);

        for (HardwareBasico hw : hardwares) {
            System.out.println("- " + hw.getNome() + ": " + hw.getCapacidade());
        }

        System.out.println("Sistema Operacional: " + so.getNome() + " (" + so.getTipo() + " bits)");

        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb");
        }
    }
}