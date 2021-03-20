package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String addressLine1;
    private String city;
    private String state;
    private Integer zip;

    public Address() {}

    public Address(String addressLine1, String city, String state, Integer zip) {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @OneToMany(mappedBy = "address")
    private Collection<Publisher> publisher;

    public Collection<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(Collection<Publisher> publisher) {
        this.publisher = publisher;
    }
}
