package section5_adv_apis.part3_funct.fp_exercise;

import java.util.Objects;

public final class Address {
    private final String street;
    private final int number;
    private final String numberPostfix;
    private final String zipCode;

    // Static final field for default address
    public static final Address DEFAULT_NO_ADDRESS = new Address("HOMELESS", 0, "", "");

    // Private constructor to prevent instantiation from outside
    public  Address(String street, int number, String numberPostfix, String zipCode) {
        this.street = street;
        this.number = number;
        this.numberPostfix = numberPostfix;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getNumberPostfix() {
        return numberPostfix;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", numberPostfix='" + numberPostfix + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number &&
                street.equals(address.street) &&
                numberPostfix.equals(address.numberPostfix) &&
                zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, numberPostfix, zipCode);
    }

    // Factory method to create a new Address
    public static Address of(String street, int number, String numberPostfix, String zipCode) {
        return new Address(street, number, numberPostfix, zipCode);
    }
}
