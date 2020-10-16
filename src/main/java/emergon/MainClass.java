package emergon;

import emergon.entity.Customer;
import emergon.entity.Family;
import emergon.entity.FamilyType;
import emergon.entity.Product;
import emergon.entity.Salesman;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
 
//        Salesman s = getSalesmanWithFamily("Dimou");
//        for(Family m: s.getMembers()){
//            System.out.println(m);
//        }

        //deleteSalesman();
        
        
        
        
        createSalesmanWithFamily();
        closeEmf();

        
    }
    
    private static Family getFamilyMemberWithSalesman(){
        openEntityManager();
        Family member = em.find(Family.class, 8);
        System.out.println(member);
        System.out.println(member.getSalesman());
        closeEntityManager();
        return member;
    }
    
    
    
    private static void deleteSalesman(){
        openEntityManager();
        Query query = em.createNativeQuery("Select * from salesman where sname = ?", Salesman.class);
        query.setParameter(1, "Vasileiou");
        Salesman politis = (Salesman)query.getSingleResult();
        em.getTransaction().begin();
        em.remove(politis);
        em.getTransaction().commit();
        closeEntityManager();
    }
    
    private static void createSalesmanWithFamily(){
        Salesman politis = new Salesman("Mary", "Thessaloniki", 0.15);
        Family member1 = new Family("Peter", FamilyType.FATHER, LocalDate.now());
        politis.addMember(member1);
        openEntityManager();
        em.getTransaction().begin();
        em.persist(politis);
        em.getTransaction().commit();
        closeEntityManager();
    }
    
    private static Salesman getSalesmanWithFamily(String name){
        openEntityManager();
        TypedQuery<Salesman> query = em.createNamedQuery("Salesman.findSalesmanByNameWithFamily", Salesman.class);
        query.setParameter("onoma", name);
        Salesman s;
        try{
            s = query.getSingleResult();
        }catch(NoResultException nre){
            System.out.println("*******NoResultException******");
            System.out.println(nre.getLocalizedMessage());
            s = null;
        } finally{
            closeEntityManager();
        }
        return s;
    }
    
    private static Salesman getSalesmanByName(String name){
        openEntityManager();
        TypedQuery<Salesman> query = em.createNamedQuery("Salesman.findByName", Salesman.class);
        query.setParameter("onoma", name);
        List<Salesman> list = query.getResultList();
        closeEntityManager();
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
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
