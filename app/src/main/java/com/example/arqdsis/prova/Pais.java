package com.example.arqdsis.prova;

import java.io.Serializable;

/**
 * Created by arqdsis on 24/03/2017.
 * @author Rafael Morcelli 201507944
 */
public class Pais implements Serializable,Comparable<Pais> {
    private int id;
    private String nomepais;
    private String capital;
    private String area;
    private String populacao;
    private String moeda;

    public Pais(String pais, String capital, String area, String populacao, String moeda) {
        this.nomepais = pais;
        this.capital = capital;
        this.area = area;
        this.populacao = populacao;
        this.moeda = moeda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        if (id != pais.id) return false;
        if (nomepais != null ? !nomepais.equals(pais.nomepais) : pais.nomepais != null)
            return false;
        if (capital != null ? !capital.equals(pais.capital) : pais.capital != null) return false;
        if (area != null ? !area.equals(pais.area) : pais.area != null) return false;
        if (populacao != null ? !populacao.equals(pais.populacao) : pais.populacao != null)
            return false;
        return moeda != null ? moeda.equals(pais.moeda) : pais.moeda == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomepais != null ? nomepais.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (populacao != null ? populacao.hashCode() : 0);
        result = 31 * result + (moeda != null ? moeda.hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomepais() {
        return nomepais;
    }

    public void setNomepais(String nomepais) {
        this.nomepais = nomepais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getPopulacao() {
        return populacao;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nomepais='" + nomepais + '\'' +
                ", capital='" + capital + '\'' +
                ", area='" + area + '\'' +
                ", populacao='" + populacao + '\'' +
                ", moeda='" + moeda + '\'' +
                '}';
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }


    @Override
    public int compareTo(Pais pais) {
        return this.nomepais.compareTo(pais.getNomepais());
    }
}
