/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho_lpm_2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trabalho_lpm_2 {

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Vinicius\\FAC_BRASILEIRAO_2022\\brasileirao_2022.csv"; // Caminho do arquivo CSV
        List<Partida> partidas = new ArrayList<>();
        List<Time> times = new ArrayList<>();

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

                        // Adiciona os times à lista se ainda não estiverem presentes
                        if (!times.contains(timeCasa)) {
                            times.add(timeCasa);
                        }
                        if (!times.contains(timeVisitante)) {
                            times.add(timeVisitante);
                        }

                        // Cria o objeto Partida com as informações necessárias
                        Partida partida = new Partida(
                            linha[1], // Data
                            timeCasa,
                            timeVisitante,
                            Integer.parseInt(linha[12]), // Gols Time da casa
                            Integer.parseInt(linha[13])  // Gols Time visitante
                        );
                        partidas.add(partida);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter número: " + e.getMessage());
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace(); // Imprime o stack trace para depuração
        }

        // Exibe as partidas
        for (Partida partida : partidas) {
            System.out.println(partida);
        }

        // Exibe os times
        System.out.println("\nTimes:");
        for (Time time : times) {
            System.out.println(time.getNome()); // Corrigido para obter apenas o nome do time
        }
    }
}



