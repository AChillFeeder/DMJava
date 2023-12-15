package fr.sdvnte.m12324.entities;

import fr.sdvnte.m12324.entities.Animal;
import jakarta.persistence.*;

@Entity
public class Cat extends Animal {
    private String chipId;

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
