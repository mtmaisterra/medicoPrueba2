package dao;


import entidad.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO<T>{ 
/*<T> los genericos nos permiten hacer un trabajo sin importar que tipo de dato
 que utilicemos*/
    
    protected EntityManagerFactory emf;
    /* los entity manager factory permite manejar las entidades*/
    protected EntityManager em;

   public DAO(){
       emf = Persistence.createEntityManagerFactory("PruebaPorLastimaPU");
       em = emf.createEntityManager();
   }
    
    protected void conect(){
        if(!em.isOpen()) em = emf.createEntityManager();
    }
    /* la conexión se debe abrir y cerrar por protección*/
    
    protected void disconect(){
        if(em.isOpen())em.close();
        
    }
    
    protected void create (T object){ /*Crear objeto*/
        conect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconect();        
    }
    
    protected void update (T object){ /*Actualizar un objeto*/
        conect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconect();        
    }
    protected void delete (T object){ /*Eliminar un objeto*/
        conect();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        disconect();        
    }

    
    
    
}
