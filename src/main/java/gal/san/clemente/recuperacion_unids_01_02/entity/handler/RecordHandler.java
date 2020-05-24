package gal.san.clemente.recuperacion_unids_01_02.entity.handler;

import gal.san.clemente.recuperacion_unids_01_02.entity.Record;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Manejador de SAX https://www.youtube.com/watch?v=CaF8w9RjVac
public class RecordHandler extends DefaultHandler {
    //permite leer el documento xml
    private List<Record> records = new ArrayList<>();
    private Record record;
    private StringBuilder buffer = new StringBuilder();

    public List<Record> getRecords() {
        return records;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "dateRep":
                record.setDateRep(buffer.toString());
                break;
            case "day":
                record.setDay(Integer.parseInt(buffer.toString()));
                break;
            case "month":
                record.setMonth(Integer.parseInt(buffer.toString()));
                break;
            case "year":
                record.setYear(Integer.parseInt(buffer.toString()));
                break;
            case "cases":
                record.setCases(Integer.parseInt(buffer.toString()));
                break;
            case "deaths":
                record.setDeaths(Integer.parseInt(buffer.toString()));
                break;
            case "countriesAndTerritories":
                record.setCountriesAndTerritories(buffer.toString());
                break;
            case "geoId":
                record.setGeoId(buffer.toString());
                break;
            case "countryterritoryCode":
                record.setCountryterritoryCode(buffer.toString());
                break;
            case "popData2018":
                int num = 0;
                
                if(!buffer.toString().isEmpty() || !buffer.toString().isBlank()) num = Integer.parseInt(buffer.toString());
                
                record.setPopData2018(num);
                break;
            case "continentExp":
                record.setContinentExp(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "record":
                record = new Record();
                records.add(record);
                break;
            //para no repetir el borrado de buffer se hace el default
            default:
                buffer.delete(0, buffer.length());
                break;
        }
    }
    
}
