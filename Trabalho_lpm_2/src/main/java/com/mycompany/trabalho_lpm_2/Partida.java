/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

/**
 *
 * @author Vinicius
 */
public class Partida {
    private String data;
    private String timeCasa;
    private String timeVisitante;
    private int golsTimeCasa;
    private int golsTimeVisitante;

    public Partida(String data, Time timeCasa, Time timeVisitante, int golsTimeCasa, int golsTimeVisitante) {
        this.data = data;
        this.timeCasa = timeCasa.getNome();
        this.timeVisitante = timeVisitante.getNome();
        this.golsTimeCasa = golsTimeCasa;
        this.golsTimeVisitante = golsTimeVisitante;
    }

    @Override
    public String toString() {
        return String.format("Data: %s, Time Casa: %s, Time Visitante: %s, Gols Time Casa: %d, Gols Time Visitante: %d",
            data, timeCasa, timeVisitante, golsTimeCasa, golsTimeVisitante);
    }
}
