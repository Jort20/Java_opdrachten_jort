package demos.advanced.designpatterns.null_object;

public record Address(String street, int number, String zipCode, String city) {
    public static final Address NULL_ADDRESS = new Address("UNDERTHEBRIDGE", 0, "0000AA", "NOWHERE");
}
