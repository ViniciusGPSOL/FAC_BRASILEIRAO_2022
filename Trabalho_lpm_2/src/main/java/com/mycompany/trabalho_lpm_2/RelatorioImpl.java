/**
 * This class represents the implementation of the Relatorio interface.
 * It provides methods to print different types of reports related to the football league.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

import java.util.List;
import java.util.Map;

public class RelatorioImpl implements Relatorio {
    private TimeManager timeManager;

    public RelatorioImpl(TimeManager timeManager) {
        this.timeManager = timeManager;
    }

    @Override
    public void imprimirClassificacaoCompleta() {
        System.out.println("Classificação Completa:");
        timeManager.exibirClassificacao(); // Aproveitando o método existente
    }

    @Override
    public void imprimirListaTodasAsPartidas() {
        System.out.println("Lista de Todas as Partidas:");
        List<Partida> partidas = timeManager.getPartidas();
        for (Partida partida : partidas) {
            System.out.println(partida); // Customize conforme necessário
        }
    }

    @Override
    public void imprimirPartidasPorTime(String nomeTime) {
        System.out.println("Partidas do Time " + nomeTime + ":");
        List<Partida> partidas = timeManager.getPartidasPorTime(nomeTime);
        for (Partida partida : partidas) {
            System.out.println(partida); // Customize conforme necessário
        }
    }
}


