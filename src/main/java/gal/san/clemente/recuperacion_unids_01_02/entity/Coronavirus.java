package gal.san.clemente.recuperacion_unids_01_02.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Coronavirus {
    
    @SerializedName("continentes")
    private List<Continente> continentes = new ArrayList<>();

    public List<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(List<Continente> continentes) {
        this.continentes = continentes;
    }
   
}
