package gal.san.clemente.recuperacion_unids_01_02.controller;

import gal.san.clemente.recuperacion_unids_01_02.entity.Config;
import gal.san.clemente.recuperacion_unids_01_02.entity.Continente;
import gal.san.clemente.recuperacion_unids_01_02.entity.Coronavirus;
import gal.san.clemente.recuperacion_unids_01_02.entity.Informe;
import gal.san.clemente.recuperacion_unids_01_02.entity.Record;
import gal.san.clemente.recuperacion_unids_01_02.entity.handler.RecordHandler;
import gal.san.clemente.recuperacion_unids_01_02.exception.ProjectException;
import gal.san.clemente.recuperacion_unids_01_02.utils.FileUtils;
import gal.san.clemente.recuperacion_unids_01_02.utils.JSONUtils;
import gal.san.clemente.recuperacion_unids_01_02.utils.XMLUtils;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    
    private FileUtils fileUtils; 
    
    public Controller(){
        fileUtils = new FileUtils();
    }
    
    public void copiaSeguridad() throws ProjectException {
        File file = new File("config.json");
        
        Config config = new Config();
        config = JSONUtils.readJSONFromFile(Config.class, file);
        
        String orixe = config.getDirectorioOrixe();
        String destino = config.getDirectorioBackup();
        
        List<File> files = new ArrayList<>();
        Path dir = Paths.get(config.getDirectorioOrixe());
        
        files = fileUtils.getFiles(files, dir);
        fileUtils.writeFilesIsNotExist(files, orixe, destino, ".backup");   
        
        Informe informe = new Informe();
        informe.setNumeroDeArquivosCopiados(fileUtils.getNumeroArchivos());
        informe.setTempoUtilizadoEnSegundos((double)fileUtils.getProcessTime()/1000);
        
        fileUtils.writeSimpleFile(JSONUtils.writeJsonInFile(informe), "informe.json");
     
    }
    
    public List<Record> coronaVirus5MayoPorPais() throws ProjectException {
        File file = new File("./coronavirus.xml");
        RecordHandler handler = new RecordHandler();
       
        XMLUtils.readXML(file, handler);
        
        Map<String, List<Record>> records = handler.getRecords().stream()
                .collect(Collectors.groupingBy(Record::getCountriesAndTerritories,
                    Collectors.filtering(x -> x.getDay() == 5 && x.getMonth() == 5, Collectors.toList())));
        
        List<Record> paises = records.values().stream()
                .flatMap(List::stream)
                    .collect(Collectors.toList());
        
        return paises;
    }
    
    public void coronaVirus5MayoPorContinente() throws ProjectException {
        File file = new File("./coronavirus.xml");
        RecordHandler handler = new RecordHandler();
       
        XMLUtils.readXML(file, handler);
        
        Map<String, List<Record>> records = handler.getRecords().stream()
                .collect(Collectors.groupingBy(Record::getContinentExp,
                    Collectors.filtering(x -> x.getDay() == 5 && x.getMonth() == 5, Collectors.toList())));
        
        Map<String, Integer> deahtsByContinent = handler.getRecords().stream()
                .collect(Collectors.groupingBy(Record::getContinentExp, Collectors.summingInt(Record::getDeaths)));
        
        Map<String, Integer> casesByContinent = handler.getRecords().stream()
                .collect(Collectors.groupingBy(Record::getContinentExp, Collectors.summingInt(Record::getCases)));
        
        List<Continente> continentes = new ArrayList<>();
                
        for (Map.Entry<String, Integer> entry : deahtsByContinent.entrySet()) {
            Continente continente = new Continente();
            continente.setNome(entry.getKey());
            continente.setNumeroFalecementos(entry.getValue());
            continente.setNumeroCasos(casesByContinent.get(entry.getKey()));
            continentes.add(continente);
        }
        
        Coronavirus coronavirus = new Coronavirus();
        
        coronavirus.setContinentes(continentes);
        
        fileUtils.writeSimpleFile(JSONUtils.writeJsonInFile(coronavirus), "coronavirus.json");
    } 

}
