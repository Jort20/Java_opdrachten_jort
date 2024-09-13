package demos.advanced.oop_basics.javabasics;

/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class Address {
    private String street;
    private int number;
    //    private String zipCode;
    private String zipCodeLocal;
    private int zipCodeArea;

    /**
     * Constructing without street or number is pointless.
     *
     * @param street the street name
     * @param number the house numbere
     */
    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipCode() {
        return this.zipCodeArea + " " + zipCodeLocal;
    }

    public void setZipCode(String zipCode) {
        if (isCorrectZipCode(zipCode)) {
            parseZipCode(zipCode);
        } else {
            throw new IllegalArgumentException("Given zipcode " + zipCode + " is not correct");
        }
    }

    private boolean isCorrectZipCode(String zipCode) {
        if (null == zipCode || zipCode.length() == 0) {
            return false;
        }
        return zipCode.trim().matches("\\d{4} ?[A-Za-z]{2}");
    }

    private void parseZipCode(String zipCode) {
        zipCode = zipCode.trim();
        int offset = 0;
        if (zipCode.contains(" ")) {
            offset = 1;
        }
        this.zipCodeArea = Integer.parseInt(zipCode.substring(0, 4));
        this.zipCodeLocal = zipCode.substring(4 + offset);
    }
}
