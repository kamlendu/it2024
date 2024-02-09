/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DataBean implements DataBeanLocal {
    
    @PersistenceContext(unitName = "datapu")
    EntityManager em;
    
    
//    @PostConstruct()
//    void getManager()
//    {
//        EntityManagerFactory emf = Persistence
//                .createEntityManagerFactory("datapu");
//    
//        EntityManager myem = emf.createEntityManager();
//    }

    @Override
    public void addBook(String bname, String aname, String pname, String synopsis) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = new BookMaster();
    bm.setBookName(bname);
    bm.setAuthorName(aname);
    bm.setPublisherName(pname);
    bm.setSynopsis(synopsis);
    
    
   // em.getTransaction().begin();
    
    em.persist(bm);
    
   // em.getTransaction().commit();
    
    
    }

    @Override
    public void updateBook(Integer bid, String bname, String aname, String pname, String synopsis) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
      BookMaster bm = (BookMaster) em.find(BookMaster.class, bid);
                 bm.setBookName(bname);
                 bm.setAuthorName(aname);
                 bm.setPublisherName(pname);
                 bm.setSynopsis(synopsis);
                 
       em.merge(bm);
    
    }

    @Override
    public void removeBook(Integer bid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        BookMaster bm = (BookMaster) em.find(BookMaster.class, bid);
      
        em.remove(bm);
    }

    @Override
    public Collection<BookMaster> getAllBooks() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
    
    return books;
    }

    @Override
    public Collection<BookMaster> getBooksByAuthor(String aname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
     Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByAuthorName")
                                    .setParameter("authorName", aname)  
                                    .getResultList();
    
    return books;
    }

    @Override
    public Collection<BookMaster> getBooksByPublisher(String pname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByPublisherName")
                                    .setParameter("publisherName", pname)  
                                    .getResultList();
    
    return books;
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")




}
