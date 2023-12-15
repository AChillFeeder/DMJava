package fr.sdvnte.m12324.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column
    private String name;

    @Column
    private String managerName;

    @ManyToMany(mappedBy = "petStores")
    private Set<Product> products;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;

    public PetStore(){
        animals = new HashSet<Animal>();
    }

    public PetStore(String name, String managerName, Set<Product> products, Address address, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.products = products;
        this.address = address;
        this.animals = animals;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
