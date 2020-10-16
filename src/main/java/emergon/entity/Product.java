/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Product implements Serializable {

    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key(auto increment)
    @Column(name = "pcode" , columnDefinition = "int")
    private int pcode;
    private String pdescr;
    private double pprice;
    @OneToMany(mappedBy = "product")
    private List<Sales> sales;

    public Product() {
    }

    public Product(String pdescr, double pprice) {
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pdescr=" + pdescr + ", pprice=" + pprice + '}';
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

}
