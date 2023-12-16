package fr.sdvnte.m12324.entities;

import fr.sdvnte.m12324.entities.Animal;
import jakarta.persistence.*;

@Entity
public class Fish extends Animal {
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    private FishLivEnv livingEnv;


}