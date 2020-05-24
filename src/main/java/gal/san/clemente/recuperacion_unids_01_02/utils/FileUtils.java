package gal.san.clemente.recuperacion_unids_01_02.utils;

import gal.san.clemente.recuperacion_unids_01_02.exception.ProjectException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;

public class FileUtils {
    
    private int numeroArchivos = 0;
    private long tiempoInicio;
    private long tiempoFin;
    
    public void writeFile(String data, String url) throws ProjectException {
        //Vamos comezar declarando o ficheiro
        File arquivo = new File(url);
          
        try {

            //Creamos un fluxo de saida para o arquivo
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream fluxoDatos = new ObjectOutputStream(fileOut);
            
            fluxoDatos.writeObject(data);
         
            //Temos que cerrar sempre o ficheiro
            fluxoDatos.close();
            
        } catch (IOException e) {
            throw new ProjectException("Erro escrituroa ficheiro " + e.getMessage(), e);
        }  
    }
    
    public List<File> getFiles(List<File> files, Path dir) throws ProjectException {
        this.tiempoInicio = Instant.now().toEpochMilli();
        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            
            for (Path path : stream) {
                if(path.toFile().isDirectory()) {
                    getFiles(files, path);
                } else {
                    files.add(path.toFile());
                    numeroArchivos ++;
                }
            }
        } catch(IOException e) {
           throw new ProjectException("Erro lectura, método recursivo " + e.getMessage(), e);
        }
        
        return files;
    }
    
    public byte[] fileToArrayByte(File file) throws ProjectException {
        byte[] ArrayByteData = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(ArrayByteData);
            fileInputStream.close();
        } catch (IOException e) {
            throw new ProjectException("Erro crear array de bytes " + e.getMessage(), e);
        }
        return ArrayByteData;
    }
    
    public void arrayByteToFile(String dir, byte [] arrayByte) throws ProjectException {
        try{
            FileOutputStream fos = new FileOutputStream(dir); 
            fos.write(arrayByte);
            fos.close();
        }catch(IOException e){
            throw new ProjectException("Erro crear archivo " + e.getMessage(), e);
        }
    }
    
    public void writeFilesIsNotExist(List<File> files, String origen, String destino, String extension) throws ProjectException {
        for(File f : files) {
            String fileName = f.getPath();
            String fileUrl = fileName.replaceAll(origen, destino);
            byte[] bytes = fileToArrayByte(f);
            
            File dir = new File(fileUrl.replaceAll(f.getName(), ""));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            String ruta = fileUrl.concat(extension);
            File file = new File(ruta);
            if (!file.exists()){
                arrayByteToFile(ruta, bytes);
            }
        }
        this.tiempoFin = Instant.now().toEpochMilli();
    }
    
    public long getProcessTime() {
        return tiempoFin - tiempoInicio;
    }

    public int getNumeroArchivos() {
        return numeroArchivos;
    }
    
    public void writeSimpleFile(String json, String filename) throws ProjectException {
        //Vamos comezar declarando o ficheiro
        File arquivo = new File(filename);

        try {

            //Creamos o fluxo de saida
            FileWriter fluxoDatos;
            fluxoDatos = new FileWriter(arquivo);
            BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);
            buferSaida.write(json);
            //Cerramos o arquivo
            buferSaida.close();
            
        } catch (IOException e) {
             throw new ProjectException("Erro escritura archivo " + e.getMessage(), e);
        }  
    }

}
