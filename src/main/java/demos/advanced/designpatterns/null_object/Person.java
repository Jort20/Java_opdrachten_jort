package demos.advanced.designpatterns.null_object;

public record Person(String firstName, String lastName, Address address){
    @Override
    public Address address() {
        if (address == null) return Address.NULL_ADDRESS;
        return address;
    }
}
