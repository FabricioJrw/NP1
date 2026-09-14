package com.inatel.pcmania.main;

import com.inatel.pcmania.modelo.Cliente;
import com.inatel.pcmania.modelo.Computador;
import com.inatel.pcmania.modelo.HardwareBasico;
import com.inatel.pcmania.modelo.MemoriaUSB;
import com.inatel.pcmania.modelo.SistemaOperacional;
import com.inatel.pcmania.util.ProcessarPedido;

import java.util.Scanner;

public class Main {

    private static final int MATRICULA = 869;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a PC Mania");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        int codigo = -1;
        while (codigo != 0) {
            System.out.println();
            System.out.println("Escolha a promocao do PC que deseja comprar (0 para finalizar):");
            System.out.println("1 - Promocao 1 (Apple)");
            System.out.println("2 - Promocao 2 (Samsung)");
            System.out.println("3 - Promocao 3 (Dell)");
            System.out.print("Codigo: ");

            codigo = lerInteiro(scanner);

            switch (codigo) {
                case 1:
                    cliente.addComputador(criarComputadorPromocao1());
                    System.out.println("PC da Promocao 1 adicionado a compra!");
                    break;
                case 2:
                    cliente.addComputador(criarComputadorPromocao2());
                    System.out.println("PC da Promocao 2 adicionado a compra!");
                    break;
                case 3:
                    cliente.addComputador(criarComputadorPromocao3());
                    System.out.println("PC da Promocao 3 adicionado a compra!");
                    break;
                case 0:
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Codigo invalido! Digite 0, 1, 2 ou 3.");
            }
        }

        Computador[] pcsComprados = cliente.getComputadores();

        System.out.println();
        System.out.println("=== Resumo da Compra ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        for (int i = 0; i < pcsComprados.length; i++) {
            System.out.println();
            System.out.println("PC " + (i + 1) + ":");
            pcsComprados[i].mostraPCConfigs();
        }

        System.out.println();
        System.out.printf("Total da compra: R$ %.2f%n", cliente.calculaTotalCompra());

        ProcessarPedido.enviarPedido(pcsComprados);

        scanner.close();
    }

    private static int lerInteiro(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Digite um numero (0, 1, 2 ou 3): ");
            }
        }
    }

    private static Computador criarComputadorPromocao1() {
        HardwareBasico[] hardwares = {
                new HardwareBasico("Processador Core i5", 2200),
                new HardwareBasico("Memoria RAM", 8),
                new HardwareBasico("HD", 500)
        };
        SistemaOperacional so = new SistemaOperacional("macOS Sequoia", 64);
        Computador computador = new Computador("Apple", MATRICULA, hardwares, so);
        computador.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
        return computador;
    }

    private static Computador criarComputadorPromocao2() {
        HardwareBasico[] hardwares = {
                new HardwareBasico("Processador Core i7", 3370),
                new HardwareBasico("Memoria RAM", 16),
                new HardwareBasico("HD", 1000)
        };
        SistemaOperacional so = new SistemaOperacional("Windows 8", 64);
        Computador computador = new Computador("Samsung", MATRICULA + 1, hardwares, so);
        computador.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
        return computador;
    }

    private static Computador criarComputadorPromocao3() {
        HardwareBasico[] hardwares = {
                new HardwareBasico("Processador Core i7", 4500),
                new HardwareBasico("Memoria RAM", 32),
                new HardwareBasico("HD", 2000)
        };
        SistemaOperacional so = new SistemaOperacional("Windows 10", 64);
        Computador computador = new Computador("Dell", MATRICULA + 2, hardwares, so);
        computador.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
        return computador;
    }
}