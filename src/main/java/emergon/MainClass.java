package emergon;

import emergon.entity.Customer;
import emergon.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainClass {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        System.out.println("Starting JPA...");

        openEntityManagerFactory();

//        int ccode = 100102;//Alexiadis
//        getCustomerById(ccode);
//        printCustomers();
/*
        create product
        Product p = new Product("Chair", 35);
        createProduct(p);
         */
 /*
        Update customer
        Customer c = getCustomerById(100102);
        System.out.println("Customer before update: "+ c);
        c.setCname("Alexiou");//Update customer
        updateCustomer(c);
        System.out.println("Customer after update: "+c);
         */
        closeEmf();

    }

    private static void deleteProduct(Product p) {
        openEntityManager();
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        closeEntityManager();
    }

    private static void createProduct(Product p) {
        openEntityManager();
        em.getTransaction().begin();
        em.persist(p);//Add product
        em.getTransaction().commit();
        closeEntityManager();
    }

    private static Customer updateCustomer(Customer c) {
        openEntityManager();
        em.getTransaction().begin();
        c = em.merge(c);//like update
        em.getTransaction().commit();//Send the query to the Database
        closeEntityManager();
        return c;
    }

    private static void printCustomers() {
        openEntityManager();
        String sql = "SELECT c FROM Customer c";//JPQL: Java Persistence Query Language
        Query query = em.createQuery(sql, Customer.class);//We create Object TypedQuery from EntityManager
        List<Customer> list = query.getResultList();//Execute the query and get the result
        System.out.println("******************");
        for (Customer c : list) {
            System.out.println(c);
        }
        System.out.println("******************");
        closeEntityManager();
    }

    private static Customer getCustomerById(int ccode) {
        openEntityManager();
        Customer customer = em.find(Customer.class, ccode);
        System.out.println("*******************");
        System.out.println("customer:" + customer);
        System.out.println("*******************");
        closeEntityManager();
        return customer;
    }

    private static void openEntityManager() {
        em = emf.createEntityManager();
    }

    private static void closeEntityManager() {
        em.close();
    }

    private static void openEntityManagerFactory() {
        System.out.println("Opening EntityManagerFactory...");
        emf = Persistence.createEntityManagerFactory("mainPU");
    }

    private static void closeEmf() {
        emf.close();
        System.out.println("Closing EntityManagerFactory...");
    }

}
