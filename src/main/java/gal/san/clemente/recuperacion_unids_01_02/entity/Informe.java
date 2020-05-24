package gal.san.clemente.recuperacion_unids_01_02.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Informe implements Serializable {
    
    @SerializedName("numero_de_arquivos_copiados")
    private int numeroDeArquivosCopiados;
    
    @SerializedName("tempo_utilizado_en_segundos")
    private double tempoUtilizadoEnSegundos;

    public Informe() {
    }

    public Informe(int numeroDeArquivosCopiados, double tempoUtilizadoEnSegundos) {
        this.numeroDeArquivosCopiados = numeroDeArquivosCopiados;
        this.tempoUtilizadoEnSegundos = tempoUtilizadoEnSegundos;
    }

    public int getNumeroDeArquivosCopiados() {
        return numeroDeArquivosCopiados;
    }

    public void setNumeroDeArquivosCopiados(int numeroDeArquivosCopiados) {
        this.numeroDeArquivosCopiados = numeroDeArquivosCopiados;
    }

    public double getTempoUtilizadoEnSegundos() {
        return tempoUtilizadoEnSegundos;
    }

    public void setTempoUtilizadoEnSegundos(double tempoUtilizadoEnSegundos) {
        this.tempoUtilizadoEnSegundos = tempoUtilizadoEnSegundos;
    }

    @Override
    public String toString() {
        return "Informe{" + "numeroDeArquivosCopiados=" + numeroDeArquivosCopiados + ", tempoUtilizadoEnSegundos=" + tempoUtilizadoEnSegundos + '}';
    }
    
}
