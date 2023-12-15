package fr.sdvnte.m12324.entities;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column
    private String code;

    @Column
    private String label;

    @Enumerated
    private ProdType type;

    @Column
    private double price;

    @ManyToMany
    @JoinTable(name="Product_PetStore",
            joinColumns= @JoinColumn(name="ID_Product", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PetStore", referencedColumnName="ID")
    )
    private Set<PetStore> petStores;

    public Product(){}

    public Product(String code, String label, ProdType type, double price, Set<PetStore> petStores) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    public long getID() {
        return ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }


}
