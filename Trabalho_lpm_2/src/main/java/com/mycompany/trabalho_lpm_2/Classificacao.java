

/**
 * Classe que representa a classificação de um time em um campeonato.
 * Armazena informações como nome do time, número de vitórias, empates, derrotas,
 * gols marcados, gols sofridos e o percentual de aproveitamento.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

/**
 *
 * @author Vinicius
 */
public class Classificacao {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsMarcados;
    private int golsSofridos;

    public Classificacao(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public void atualizarEstatisticas(int golsMarcados, int golsSofridos) {
        this.golsMarcados += golsMarcados;
        this.golsSofridos += golsSofridos;
        if (golsMarcados > golsSofridos) {
            vitorias++;
        } else if (golsMarcados == golsSofridos) {
            empates++;
        } else {
            derrotas++;
        }
    }

    public double getPercentualAproveitamento() {
        int jogos = vitorias + empates + derrotas;
        if (jogos == 0) return 0;
        return (double) (vitorias * 3 + empates) / (jogos * 3) * 100;
    }

    @Override
    public String toString() {
        return String.format("Time: %s, Vitórias: %d, Empates: %d, Derrotas: %d, Gols Marcados: %d, Gols Sofridos: %d, Aproveitamento: %.2f%%",
            nome, vitorias, empates, derrotas, golsMarcados, golsSofridos, getPercentualAproveitamento());
    }
}
