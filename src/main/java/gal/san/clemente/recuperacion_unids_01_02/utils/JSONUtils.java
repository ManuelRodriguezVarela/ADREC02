package gal.san.clemente.recuperacion_unids_01_02.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gal.san.clemente.recuperacion_unids_01_02.exception.ProjectException;
import java.io.File;
import java.io.FileReader;

public class JSONUtils<E> {
    
    public static <E> E readJSONFromFile(Class<E> clase, File file) throws ProjectException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        E object =  null;
        try {
            object = gson.fromJson(new FileReader(file), clase);
        } catch(Exception e) {
            throw new ProjectException(e.getMessage(), e);
        }
        return object;
    }
    
    public static String writeJsonInFile(Object object) {
        //Pasamos a nosa clase a JSON utilizando a libreria GSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
