package org.translation;

/**
 * This Class stores information about a country.
 * name, alpha2code, alhpa3code, numericCode
 */
public class Country {
    private String name = "";
    private final String alpha2code;
    private final String alpha3code;
    private final int numericCode;

    public Country(String name, String alpha2code, String alpha3code, int numericCode) {
        this.name = name;
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.numericCode = numericCode;
    }

    public Country(String alpha2code, String alpha3code, int numericCode) {
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.numericCode = numericCode;
    }

    public final String getName() {
        return name;
    }

    public final String getAlpha2code() {
        return alpha2code;
    }

    public final String getAlpha3code() {
        return alpha3code;
    }

    public final int getNumericCode() {
        return numericCode;
    }

    /**
     * ToString return the string: Country [name= ***, alpha2code=***, alhpa3code=***, numericCode=***].
     * @return Country [name= ***, alpha2code=***, alhpa3code=***, numericCode=***]
     */
    public final String toString() {
        return "Country [name=" + name + ", alpha2code=" + alpha2code
                + ", alpha3code=" + alpha3code + ", numericCode=" + numericCode + "]";
    }
}
