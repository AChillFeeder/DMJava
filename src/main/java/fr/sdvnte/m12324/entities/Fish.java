package fr.sdvnte.m12324.entities;

import fr.sdvnte.m12324.entities.Animal;
import jakarta.persistence.*;

@Entity
public class Fish extends Animal {
    private FishLivEnv livingEnv;
}