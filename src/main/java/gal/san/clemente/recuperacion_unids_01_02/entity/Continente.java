package gal.san.clemente.recuperacion_unids_01_02.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Continente implements Serializable {
    
    @SerializedName("nome")
    private String nome;
    
    @SerializedName("numero_casos")
    private int numeroCasos;
    
    @SerializedName("numero_falecementos")
    private int numeroFalecementos;

    public Continente(String nome, int numeroCasos, int numeroFalecementos) {
        this.nome = nome;
        this.numeroCasos = numeroCasos;
        this.numeroFalecementos = numeroFalecementos;
    }

    public Continente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCasos() {
        return numeroCasos;
    }

    public void setNumeroCasos(int numeroCasos) {
        this.numeroCasos = numeroCasos;
    }

    public int getNumeroFalecementos() {
        return numeroFalecementos;
    }

    public void setNumeroFalecementos(int numeroFalecementos) {
        this.numeroFalecementos = numeroFalecementos;
    }

    @Override
    public String toString() {
        return "Continente{" + "nome=" + nome + ", numeroCasos=" + numeroCasos + ", numeroFalecementos=" + numeroFalecementos + '}';
    }

}
