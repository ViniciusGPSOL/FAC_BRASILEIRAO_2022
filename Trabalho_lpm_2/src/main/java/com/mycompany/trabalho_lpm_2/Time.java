

/**
 * Classe que representa um Time.
 * 
 * Essa classe contém informações sobre o nome, cidade e estado de um time.
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_lpm_2;

import java.util.Objects;

public class Time {
    private String nome;
    private String cidade;
    private String estado;

    public Time(String nome, String cidade, String estado) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return nome.equals(time.nome) &&
               cidade.equals(time.cidade) &&
               estado.equals(time.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cidade, estado);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Cidade: %s, Estado: %s", nome, cidade, estado);
    }
}
