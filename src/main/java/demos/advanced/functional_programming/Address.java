package demos.advanced.functional_programming;

public class Address {
    public static Address DEFAULT_NO_ADDRESS;
    private String street;
    private int number;
    private String numberPostfix;
    private String zipCode;

    static {
        DEFAULT_NO_ADDRESS = new Address();
        DEFAULT_NO_ADDRESS.street = "HOMELESS";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNumberPostfix() {
        return numberPostfix;
    }

    public void setNumberPostfix(String numberPostfix) {
        this.numberPostfix = numberPostfix;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
}
