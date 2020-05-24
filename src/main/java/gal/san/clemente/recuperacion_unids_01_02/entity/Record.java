package gal.san.clemente.recuperacion_unids_01_02.entity;

import java.io.Serializable;

public class Record implements Serializable {
    private String dateRep;
    private int day;
    private int month;
    private int year;
    private int cases;
    private int deaths;
    private String countriesAndTerritories;
    private String geoId;
    private String countryterritoryCode;
    private int popData2018;
    private String continentExp;

    public Record() {
    }

    public Record(String dateRep, int day, int month, int year, int cases, int deaths, String countriesAndTerritories, String geoId, String countryterritoryCode, int popData2018, String continentExp) {
        this.dateRep = dateRep;
        this.day = day;
        this.month = month;
        this.year = year;
        this.cases = cases;
        this.deaths = deaths;
        this.countriesAndTerritories = countriesAndTerritories;
        this.geoId = geoId;
        this.countryterritoryCode = countryterritoryCode;
        this.popData2018 = popData2018;
        this.continentExp = continentExp;
    }

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public void setCountriesAndTerritories(String countriesAndTerritories) {
        this.countriesAndTerritories = countriesAndTerritories;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public void setCountryterritoryCode(String countryterritoryCode) {
        this.countryterritoryCode = countryterritoryCode;
    }

    public int getPopData2018() {
        return popData2018;
    }

    public void setPopData2018(int opData2018) {
        this.popData2018 = opData2018;
    }

    public String getContinentExp() {
        return continentExp;
    }

    public void setContinentExp(String continentExp) {
        this.continentExp = continentExp;
    }

    @Override
    public String toString() {
        return "Record{" + "dateRep=" + dateRep + ", day=" + day + ", month=" + month + ", year=" + year + ", cases=" + cases + ", deaths=" + deaths + ", countriesAndTerritories=" + countriesAndTerritories + ", geoId=" + geoId + ", countryterritoryCode=" + countryterritoryCode + ", popData2018=" + popData2018 + ", continentExp=" + continentExp + '}';
    }
    
}
