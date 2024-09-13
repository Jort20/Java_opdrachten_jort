package demos.advanced.functional_programming;

import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private int numberOfLogins;
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLogins() {
        return numberOfLogins;
    }

    public void setNumberOfLogins(int numberOfLogins) {
        this.numberOfLogins = numberOfLogins;
    }

    public Address getAddress() {
        return (address == null ? Address.DEFAULT_NO_ADDRESS : address);
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    void processAll(List<User> users) {
        users
                .stream()
                .forEach(x -> {
                    try {
                        System.out.println(x.getName() + ":" + x.getAddress());
                    } catch (NullPointerException ex) {
                        System.out.println(x.getName() + ": HOMELESS");
                    }
                });
    }




}
