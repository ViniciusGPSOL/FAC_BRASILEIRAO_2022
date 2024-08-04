/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeManager {
    private List<Time> times;
    private Map<String, Classificacao> classificacoes;
    private List<Partida> partidas; // Adicionando a lista de partidas

    public TimeManager() {
        this.times = new ArrayList<>();
        this.classificacoes = new HashMap<>();
        this.partidas = new ArrayList<>(); // Inicializando a lista de partidas
    }

    public void adicionarTime(Time time) {
        if (!times.contains(time)) {
            times.add(time);
            classificacoes.put(time.getNome(), new Classificacao(time.getNome()));
            System.out.println("Time adicionado: " + time);
        } else {
            System.out.println("Time já está na lista: " + time);
        }
    }

    public void editarTime(String nome, String novoNome, String novaCidade, String novoEstado) {
        Time time = buscarTime(nome);
        if (time != null) {
            time.setNome(novoNome);
            time.setCidade(novaCidade);
            time.setEstado(novoEstado);
            classificacoes.remove(nome);
            classificacoes.put(novoNome, new Classificacao(novoNome));
            System.out.println("Time editado: " + time);
        } else {
            System.out.println("Time não encontrado: " + nome);
        }
    }

    public void removerTime(String nome) {
        Time time = buscarTime(nome);
        if (time != null) {
            times.remove(time);
            classificacoes.remove(nome);
            System.out.println("Time removido: " + time);
        } else {
            System.out.println("Time não encontrado: " + nome);
        }
    }

    public void atualizarClassificacao(Partida partida) {
        Classificacao classificacaoCasa = classificacoes.get(partida.getTimeCasa().getNome());
        Classificacao classificacaoVisitante = classificacoes.get(partida.getTimeVisitante().getNome());

        if (classificacaoCasa != null && classificacaoVisitante != null) {
            classificacaoCasa.atualizarEstatisticas(partida.getGolsTimeCasa(), partida.getGolsTimeVisitante());
            classificacaoVisitante.atualizarEstatisticas(partida.getGolsTimeVisitante(), partida.getGolsTimeCasa());
        }
    }

    public void exibirClassificacao() {
        System.out.println("Classificação Atual:");
        for (Classificacao classificacao : classificacoes.values()) {
            System.out.println(classificacao);
        }
    }

    public Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equals(nome)) {
                return time;
            }
        }
        return null;
    }

    public void exibirTimes() {
        System.out.println("Lista de Times:");
        for (Time time : times) {
            System.out.println(time);
        }
    }

    // Métodos adicionados para relatórios
    public List<Partida> getPartidas() {
        return partidas;
    }

    public void adicionarPartida(Partida partida) {
        partidas.add(partida);
    }

    public List<Partida> getPartidasPorTime(String nomeTime) {
        List<Partida> partidasPorTime = new ArrayList<>();
        for (Partida partida : partidas) {
            if (partida.getTimeCasa().getNome().equals(nomeTime) || partida.getTimeVisitante().getNome().equals(nomeTime)) {
                partidasPorTime.add(partida);
            }
        }
        return partidasPorTime;
    }
}

