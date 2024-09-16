package section5_adv_apis.part3_funct.fp_exercise;

import java.util.List;
import java.util.Objects;

public final class User {
    private final long id;
    private final String name;
    private final int numberOfLogins;
    private final Address address;

    public User(long id, String name, int numberOfLogins, Address address) {
        this.id = id;
        this.name = name;
        this.numberOfLogins = numberOfLogins;
        // Defensive copy to avoid mutable object exposure
        this.address = (address == null ? Address.DEFAULT_NO_ADDRESS : address);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLogins() {
        return numberOfLogins;
    }

    public Address getAddress() {
        // Return a defensive copy to avoid mutable object exposure
        return new Address(address.getStreet(), address.getNumber(), address.getNumberPostfix(), address.getZipCode());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfLogins=" + numberOfLogins +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void processAll(List<User> users) {
        users.stream()
                .forEach(x -> {
                    try {
                        System.out.println(x.getName() + ":" + x.getAddress());
                    } catch (NullPointerException ex) {
                        System.out.println(x.getName() + ": HOMELESS");
                    }
                });
    }
}
