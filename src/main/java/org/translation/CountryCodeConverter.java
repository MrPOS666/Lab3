package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the service of converting country codes to their names.
 */
public class CountryCodeConverter {

    public static final int PARTSLENGTH = 4;
    public static final int LASTDIGIT = 3;
    private List<Country> countries;

    /**
     * Default constructor which will load the country codes from "country-codes.txt"
     * in the resources folder.
     */
    public CountryCodeConverter() {
        this("country-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the country code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public CountryCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));
            countries = new ArrayList<>();
            for (String line : lines.subList(1, lines.size())) {
                String[] parts = line.split("\t");
                if (parts.length == PARTSLENGTH) {
                    String name = parts[0];
                    String alpha2Code = parts[1];
                    String alpha3Code = parts[2];
                    int numericCode = Integer.parseInt(parts[LASTDIGIT]);
                    Country country = new Country(name, alpha2Code, alpha3Code, numericCode);
                    countries.add(country);
                }
            }

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the country for the given country code.
     * @param code the 3-letter code of the country
     * @return the name of the country corresponding to the code
     */
    public String fromCountryCode(String code) {
        for (Country country : countries) {
            if (country.getAlpha3code().equalsIgnoreCase(code)) {
                return country.getName();
            }
        }
        return null;
    }

    /**
     * Returns the code of the country for the given country name.
     * @param country the name of the country
     * @return the 3-letter code of the country
     */
    public String fromCountry(String country) {
        for (Country country1 : countries) {
            if (country1.getName().equalsIgnoreCase(country)) {
                return country1.getAlpha3code().toLowerCase();
            }
        }
        return null;
    }

    /**
     * Returns how many countries are included in this code converter.
     * @return how many countries are included in this code converter.
     */
    public int getNumCountries() {
        return countries.size();
    }

    /**
     * Test constructor and from CountryCode.
     * @param args command line arguments passed to the program
     */
    public static void main(String[] args) {
        CountryCodeConverter countryCodeConverter = new CountryCodeConverter();
        System.out.println(countryCodeConverter.fromCountryCode("usa"));
    }
}
