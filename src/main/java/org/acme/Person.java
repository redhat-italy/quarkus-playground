package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "people")
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    
    public String name;
    public String surname;
    public Date date_of_birth;

    public static Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Person> findAllPersons() {
        return findAll().list();
    }
}