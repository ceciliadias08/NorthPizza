package ca.com.northpizza.north_pizza.pizza;

import jakarta.persistence.*;
import lombok.*;

//Lombok use
@Entity //Communicate to database what is an entity through JPA
@Table(name = "Pizza") //Table's name
@Data //Getter, Setter, toString, EqualstoHashCode only in once
@AllArgsConstructor //Creates the constructor with all arguments
@NoArgsConstructor //Constructor with no arguments
public class Pizza {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Creation register flow to database
    private long id;
    private String name;
    @Enumerated (EnumType.STRING) //Informing JPA about the enum existence
    private Flavour flavour;
    private double price;
    @Enumerated (EnumType.STRING)
    private Size size;
    private boolean availability;

    /*
    * package br.com.pizzaria.dao;

import br.com.pizzaria.model.Pizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class PizzaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzariaPU");

    public void salvar(Pizza pizza) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pizza);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Pizza buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Pizza.class, id);
        } finally {
            em.close();
        }
    }

    public List<Pizza> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Pizza", Pizza.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void atualizar(Pizza pizza) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pizza);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pizza pizza = em.find(Pizza.class, id);
            if (pizza != null) em.remove(pizza);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}*/
}
