/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author poramet
 */
public class StudentTable {

    public static void insertStudent(Vaccine stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stu);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static int updateStudent(Vaccine stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        try {
            Vaccine fromDb = em.find(Vaccine.class, stu.getId());
            if (fromDb == null) {
                return 0;
            }
//            fromDb.setName(stu.getName());
//            fromDb.setGpa(stu.getGpa());
            em.getTransaction().begin();
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return 1;
    }

    public static Vaccine findStudentById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        Vaccine emp = em.find(Vaccine.class, id);
        if (emp == null) {
            return null;
        }
        em.close();
        return emp;
    }

    public static List<Vaccine> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        List<Vaccine> stuList = (List<Vaccine>) em.createNamedQuery("Vaccine.findAll").getResultList();
        em.close();
        return stuList;
    }

    public static List<Vaccine> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Vaccine.findByName");
        query.setParameter("name", name);
        List<Vaccine> stuList = (List<Vaccine>) query.getResultList();
        em.close();
        return stuList;
    }

    public static int removeStudent(Vaccine stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaccineServletPU");
        EntityManager em = emf.createEntityManager();
        try {
            Vaccine fromDb = em.find(Vaccine.class, stu.getId());
            if (fromDb == null) {
                return 0;
            }
            em.getTransaction().begin();
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return 1;
    }
}
