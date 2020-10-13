package emergon;

import emergon.entity.Customer;
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

        closeEmf();

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
