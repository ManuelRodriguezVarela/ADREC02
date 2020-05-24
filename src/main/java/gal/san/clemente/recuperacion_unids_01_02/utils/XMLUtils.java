package gal.san.clemente.recuperacion_unids_01_02.utils;

import gal.san.clemente.recuperacion_unids_01_02.exception.ProjectException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLUtils {
    public static void readXML (File file, DefaultHandler handler) throws ProjectException {
        try {   
            //Factoria que permite instanciar el método saxparser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //Pasamos fichero y manajedor
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ProjectException("Erro parseado XML " + e.getMessage(), e);
        }
    }
}
