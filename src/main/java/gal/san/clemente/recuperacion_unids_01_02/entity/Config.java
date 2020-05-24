package gal.san.clemente.recuperacion_unids_01_02.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Config implements Serializable {
    @SerializedName("directorio_orixe")
    private String directorioOrixe;
    
    @SerializedName("directorio_backup")
    private String directorioBackup;

    public Config() {
    }

    public Config(String directorioOrixe, String directorioBackup) {
        this.directorioOrixe = directorioOrixe;
        this.directorioBackup = directorioBackup;
    }
    
    public String getDirectorioOrixe() {
        return directorioOrixe;
    }

    public void setDirectorioOrixe(String directorioOrixe) {
        this.directorioOrixe = directorioOrixe;
    }

    public String getDirectorioBackup() {
        return directorioBackup;
    }

    public void setDirectorioBackup(String directorioBackup) {
        this.directorioBackup = directorioBackup;
    }

    @Override
    public String toString() {
        return "Config{" + "directorioOrixe=" + directorioOrixe + ", directorioBackup=" + directorioBackup + '}';
    }
    
}
