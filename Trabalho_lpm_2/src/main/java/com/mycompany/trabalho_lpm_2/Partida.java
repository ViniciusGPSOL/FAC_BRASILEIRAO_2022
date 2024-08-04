/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

public class Partida {
    private String data;
    private Time timeCasa;
    private Time timeVisitante;
    private int golsTimeCasa;
    private int golsTimeVisitante;

    public Partida(String data, Time timeCasa, Time timeVisitante, int golsTimeCasa, int golsTimeVisitante) {
        this.data = data;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.golsTimeCasa = golsTimeCasa;
        this.golsTimeVisitante = golsTimeVisitante;
    }

    public String getData() {
        return data;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public int getGolsTimeCasa() {
        return golsTimeCasa;
    }

    public int getGolsTimeVisitante() {
        return golsTimeVisitante;
    }

    @Override
    public String toString() {
        return String.format("Data: %s, %s x %s, Gols Time Casa: %d, Gols Time Visitante: %d",
            data, timeCasa.getNome(), timeVisitante.getNome(), golsTimeCasa, golsTimeVisitante);
    }
}
