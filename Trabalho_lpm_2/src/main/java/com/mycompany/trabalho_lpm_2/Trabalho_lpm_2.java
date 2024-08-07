

/**
 * Classe principal que contém o método main para executar o programa de gerenciamento de times e partidas.
 * O programa carrega dados de um arquivo CSV, permite a interação com o usuário através de um menu interativo e realiza operações como imprimir classificação completa, imprimir lista de todas as partidas, imprimir partidas por time, exibir todos os times, adicionar novo time, editar um time existente, remover um time, adicionar nova partida, remover uma partida e sair do programa.
 * Os dados são armazenados e gerenciados pelo objeto TimeManager, que mantém uma lista de times e partidas, além de atualizar a classificação com base nas partidas adicionadas ou removidas.
 * O programa utiliza a biblioteca OpenCSV para ler o arquivo CSV e tratar exceções relacionadas à leitura.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho_lpm_2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trabalho_lpm_2 {

    public static void main(String[] args) {
        TimeManager timeManager = new TimeManager();
        carregarDadosCSV(timeManager, "C:\\Users\\Vinicius\\FAC_BRASILEIRAO_2022\\brasileirao_2022.csv");

        // Criação do relatório
        Relatorio relatorio = new RelatorioImpl(timeManager);

        // Menu interativo
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Imprimir classificação completa");
            System.out.println("2. Imprimir lista de todas as partidas");
            System.out.println("3. Imprimir partidas por time");
            System.out.println("4. Exibir todos os times");
            System.out.println("5. Adicionar novo time");
            System.out.println("6. Editar um time existente");
            System.out.println("7. Remover um time");
            System.out.println("8. Adicionar nova partida");
            System.out.println("9. Remover uma partida");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    relatorio.imprimirClassificacaoCompleta();
                    break;
                case 2:
                    relatorio.imprimirListaTodasAsPartidas();
                    break;
                case 3:
                    System.out.print("Digite o nome do time: ");
                    String nomeTime = scanner.nextLine();
                    relatorio.imprimirPartidasPorTime(nomeTime);
                    break;
                case 4:
                    timeManager.exibirTimes();
                    break;
                case 5:
                    adicionarTime(scanner, timeManager);
                    break;
                case 6:
                    editarTime(scanner, timeManager);
                    break;
                case 7:
                    removerTime(scanner, timeManager);
                    break;
                case 8:
                    adicionarPartida(scanner, timeManager);
                    break;
                case 9:
                    removerPartida(scanner, timeManager);
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 10);

        scanner.close();
    }

    private static void carregarDadosCSV(TimeManager timeManager, String csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] linha;

            // Ignora o cabeçalho
            reader.readNext();

            while ((linha = reader.readNext()) != null) {
                if (linha.length >= 14) {
                    try {
                        // Cria os objetos Time
                        Time timeCasa = new Time(linha[7], "", ""); // Ignorando cidade e estado
                        Time timeVisitante = new Time(linha[8], "", ""); // Ignorando cidade e estado

                        // Adiciona os times ao TimeManager
                        timeManager.adicionarTime(timeCasa);
                        timeManager.adicionarTime(timeVisitante);

                        // Cria o objeto Partida com as informações necessárias
                        Partida partida = new Partida(
                            linha[1], // Data
                            timeCasa,
                            timeVisitante,
                            Integer.parseInt(linha[12]), // Gols Time da casa
                            Integer.parseInt(linha[13])  // Gols Time visitante
                        );

                        // Adiciona a partida ao TimeManager
                        timeManager.adicionarPartida(partida);

                        // Atualiza a classificação com base na partida
                        timeManager.atualizarClassificacao(partida);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter número: " + e.getMessage());
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace(); // Imprime o stack trace para depuração
        }
    }

    private static void adicionarTime(Scanner scanner, TimeManager timeManager) {
        System.out.print("Digite o nome do novo time: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a cidade do novo time: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o estado do novo time: ");
        String estado = scanner.nextLine();
        Time novoTime = new Time(nome, cidade, estado);
        timeManager.adicionarTime(novoTime);
    }

    private static void editarTime(Scanner scanner, TimeManager timeManager) {
        System.out.print("Digite o nome do time a ser editado: ");
        String nome = scanner.nextLine();
        Time time = timeManager.buscarTime(nome);
        if (time != null) {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite a nova cidade: ");
            String novaCidade = scanner.nextLine();
            System.out.print("Digite o novo estado: ");
            String novoEstado = scanner.nextLine();
            timeManager.editarTime(nome, novoNome, novaCidade, novoEstado);
        } else {
            System.out.println("Time não encontrado.");
        }
    }

    private static void removerTime(Scanner scanner, TimeManager timeManager) {
        System.out.print("Digite o nome do time a ser removido: ");
        String nome = scanner.nextLine();
        timeManager.removerTime(nome);
    }

    private static void adicionarPartida(Scanner scanner, TimeManager timeManager) {
        System.out.print("Digite a data da nova partida (formato: yyyy-MM-dd): ");
        String data = scanner.nextLine();
        System.out.print("Digite o nome do time da casa: ");
        String nomeTimeCasa = scanner.nextLine();
        System.out.print("Digite o nome do time visitante: ");
        String nomeTimeVisitante = scanner.nextLine();
        System.out.print("Digite o número de gols do time da casa: ");
        int golsCasa = scanner.nextInt();
        System.out.print("Digite o número de gols do time visitante: ");
        int golsVisitante = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        Time timeCasa = timeManager.buscarTime(nomeTimeCasa);
        Time timeVisitante = timeManager.buscarTime(nomeTimeVisitante);

        if (timeCasa != null && timeVisitante != null) {
            Partida novaPartida = new Partida(data, timeCasa, timeVisitante, golsCasa, golsVisitante);
            timeManager.adicionarPartida(novaPartida);
            timeManager.atualizarClassificacao(novaPartida);
            System.out.println("Partida adicionada com sucesso.");
        } else {
            System.out.println("Um ou ambos os times não foram encontrados.");
        }
    }

    private static void removerPartida(Scanner scanner, TimeManager timeManager) {
        System.out.print("Digite a data da partida a ser removida (formato: yyyy-MM-dd): ");
        String data = scanner.nextLine();
        List<Partida> partidas = timeManager.getPartidas();
        Partida partidaParaRemover = null;

        for (Partida partida : partidas) {
            if (partida.getData().equals(data)) {
                partidaParaRemover = partida;
                break;
            }
        }

        if (partidaParaRemover != null) {
            partidas.remove(partidaParaRemover);
            // Atualizar a classificação após a remoção da partida
            timeManager.atualizarClassificacao(partidaParaRemover); 
            System.out.println("Partida removida com sucesso.");
        } else {
            System.out.println("Partida não encontrada.");
        }
    }
}
