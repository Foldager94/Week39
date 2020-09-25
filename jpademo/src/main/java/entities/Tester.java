/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author Christoffer
 */
public class Tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("Kasper", 1976);
        Person p2 = new Person("Jens", 1988);
        
        Address a1 = new Address("Hindbærvangen 1", "Town", 1523);
        Address a2 = new Address("Jordbærvangen 8", "NewTown", 1672);
        
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        
        p1.addFees(f1);
        p2.addFees(f2);
        
        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("ButterFly");
        SwimStyle s3 = new SwimStyle("Breast Stroke");
        
        p1.addSwimStyle(s1);
        p1.addSwimStyle(s2);
        p2.addSwimStyle(s2);
        
        em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
        em.getTransaction().commit();
        em.getTransaction().begin();
            p1.removeSwimStyle(s2);
        em.getTransaction().commit();

        
        System.out.println("p1: " + p1.getP_id());
        System.out.println("p2: " + p2.getP_id());
        
        
        
        System.out.println("Lad os es om to vejs virker: " + a1.getPerson().getName());
        
    }
}
