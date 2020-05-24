package gal.san.clemente.recuperacion_unids_01_02;

import gal.san.clemente.recuperacion_unids_01_02.controller.Controller;
import gal.san.clemente.recuperacion_unids_01_02.exception.ProjectException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        //primer ejercico
        try {
            controller.copiaSeguridad();
        } catch (ProjectException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //segundo ejercicio
        try {
            System.out.println("Casos de coronavirus por país a fecha 05/05/2020");
            controller.coronaVirus5MayoPorPais().forEach(x -> System.out.println("Pais = " + x.getCountriesAndTerritories() + ", Casos = " + x.getCases()));
        } catch (ProjectException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //tercer ejercicio
        try {
            controller.coronaVirus5MayoPorContinente();
        } catch (ProjectException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
