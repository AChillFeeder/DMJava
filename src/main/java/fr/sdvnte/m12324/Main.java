package fr.sdvnte.m12324;

import fr.sdvnte.m12324.entities.*;
import jakarta.persistence.*;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstore");
        ){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

//            Créer 3 addresses
            // Créer 3 petstores

            Address address = null;
            PetStore petStore = null;
            for (int i = 0; i < 4; i++) {
                address = new Address();
                address.setNumber(Integer.toString(i));
                address.setStreet("rue");
                address.setCity("Ville");
                address.setZipCode("00000");

                entityManager.persist(address);

                petStore = new PetStore("nom_store"+Integer.toString(i)
                        , "nom_manager"+Integer.toString(i)
                        , new HashSet<Product>()
                        , address, new HashSet<Animal>());

                entityManager.persist(petStore);
            }

            // Création d'un animal à travers la classe mère
            // Créer 3 animaux
            Animal animal = new Animal(LocalDate.now(), "rouge", petStore);
            entityManager.persist(animal);

//            Création d'un chat
            Cat chat = new Cat();
            chat.setBirth(LocalDate.now());
            chat.setCouleur("noir");
            chat.setPetStore(petStore);
            chat.setChipId("chipID123");

            entityManager.persist(chat);

            // Création d'un poisson
            Fish poisson = new Fish();
            poisson.setBirth(LocalDate.now());
            poisson.setCouleur("bleu");
            poisson.setPetStore(petStore);
            poisson.setLivingEnv(FishLivEnv.FRESH_WATER);

            entityManager.persist(poisson);

            // Création d'un produit
            Set petStoresOfProduct001 = new HashSet<PetStore>();
            petStoresOfProduct001.add(petStore);
            Product product = null;
            for (int i = 0; i < 4; i++) {
                product = new Product("00"+Integer.toString(i), "Le produit "+Integer.toString(i), ProdType.FOOD, 1, petStoresOfProduct001);
                ;
                entityManager.persist(product);
            }

            // rechercher les animaux d'une animalerie
            String jpql = "SELECT a FROM Animal a WHERE a.petStore = :petStore";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("petStore", petStore);

            List<Animal> resultList = query.getResultList();
            System.out.println("Résultats: ");
            if (resultList.isEmpty()){
                System.out.println("Aucun enregistrement");
            } else {
                for(Animal animal1 : resultList){
                    System.out.println(animal1.toString());
                }
            }

            entityTransaction.commit();
        }


    }
}