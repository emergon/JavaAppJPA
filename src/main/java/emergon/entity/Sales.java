/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Sales implements Serializable {
    
    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key(auto increment)
    @Column(name = "scode" , columnDefinition = "int")
    private int scode;
    private int quant;
    private double cost;
    private LocalDate sdate;
    @ManyToOne
    @JoinColumn(name = "smcode", columnDefinition = "int", foreignKey = @ForeignKey(name = "salesman_fk"))
    private Salesman salesman;
    @ManyToOne
    @JoinColumn(name = "ccode", columnDefinition = "int", foreignKey = @ForeignKey(name = "customer_fk"))
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "pcode", columnDefinition = "int", foreignKey = @ForeignKey(name = "customer_fk"))
    private Product product;
    
    public Sales() {
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getSdate() {
        return sdate;
    }

    public void setSdate(LocalDate sdate) {
        this.sdate = sdate;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
