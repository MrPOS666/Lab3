package org.translation;

public class Country {
    private final String name;
    private final String alpha2code;
    private final String alpha3code;
    private final int numericCode;

    public Country(String name, String alpha2code, String alpha3code, int numericCode) {
        this.name = name;
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2code() {
        return alpha2code;
    }

    public String getAlpha3code() {
        return alpha3code;
    }

    public int getNumericCode() {
        return numericCode;
    }
    public String toString() {
        return "Country [name=" + name + ", alpha2code=" + alpha2code + ", alpha3code=" + alpha3code + ", numericCode=" + numericCode + "]";
    }
}
