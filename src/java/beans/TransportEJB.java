/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.City;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author dam
 */
@Stateless
public class TransportEJB {

   @PersistenceUnit EntityManagerFactory emf;
   
   public List<City> selectAllCiudades(){
      /* EntityManager em = emf.createEntityManager();
       List<City> resultado = em.createNamedQuery("City.findAll").getResultList();
       return resultado;*/
      return emf.createEntityManager().createNamedQuery("City.findAll").getResultList();
   }
   public void insertarCiudad(City c){
      if(comprobarCiudad(c)){ 
        EntityManager em = emf.createEntityManager();
        em.persist(c);
      // em.flush(); Sirve para forzar que se haga antes del close
       em.close(); //ya incluye un flush
      }
     }
   public boolean comprobarCiudad(City c){
       EntityManager em = emf.createEntityManager();
       City ciudad = em.find(City.class, c.getPostalcode());
       return ciudad != null;
   }
}
