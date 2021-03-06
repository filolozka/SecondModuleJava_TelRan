package lessonsExamples.lesson1708.example;

import java.util.Objects;

public class Address {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", string='" + street + '\'' +
                '}';
    }
}
