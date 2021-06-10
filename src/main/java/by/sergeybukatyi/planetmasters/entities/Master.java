package by.sergeybukatyi.planetmasters.entities;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "masters")
public class Master implements Serializable {

    private static final long serialVersionUID = 7470249155404281023L;

    @Id
    @Column(name = "master_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "master_name", nullable = false, unique = true)
    private String name;

    @Column(name = "master_age", nullable = false)
    private int age;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL)
    private List<Planet> planets;

    public Master() {
    }

    public Master(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @JsonBackReference
    public List<Planet> getPlanets() {
        return planets;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return age == master.age &&
                name.equals(master.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", planets=" + planets +
                '}';
    }
}
