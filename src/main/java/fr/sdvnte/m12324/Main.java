package fr.sdvnte.m12324;

import fr.sdvnte.m12324.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try(
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstore");
        ){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

//            Créer une addresse
            Address address = new Address();
            address.setNumber("1");
            address.setStreet("rue");
            address.setCity("Ville");
            address.setZipCode("00000");

//            Créer un petStore
            PetStore petStore = new PetStore("nom_store1", "nom_manager1", new HashSet<Product>(), address, new HashSet<Animal>());

//            Création d'un animal à travers la classe mère
            Animal animal = new Animal(LocalDate.now(), "rouge", petStore);

//            Création d'un chat
            Cat chat = new Cat();
            chat.setBirth(LocalDate.now());
            chat.setCouleur("noir");
            chat.setPetStore(petStore);
            chat.setChipId("chipID123");

//            Création d'un produit
            Set petStoresOfProduct001 = new HashSet<PetStore>();
            petStoresOfProduct001.add(petStore);
            Product product = new Product("001", "Le produit 1", ProdType.FOOD, 1, petStoresOfProduct001);

            entityManager.persist(address);
            entityManager.persist(petStore);
            entityManager.persist(animal);
            entityManager.persist(chat);
            entityManager.persist(product);

            entityTransaction.commit();
        }


    }
}