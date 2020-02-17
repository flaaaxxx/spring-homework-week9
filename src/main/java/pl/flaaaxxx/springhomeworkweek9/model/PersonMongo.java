package pl.flaaaxxx.springhomeworkweek9.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class PersonMongo {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String id_address;

    public PersonMongo() {
    }

    public PersonMongo(String id, String first_name, String last_name, String email, String gender, String id_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.id_address = id_address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_address() {
        return id_address;
    }

    public void setId_address(String id_address) {
        this.id_address = id_address;
    }
}
