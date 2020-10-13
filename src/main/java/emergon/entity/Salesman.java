/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.util.List;
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
public class Salesman implements Serializable {
    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scode;
    private String sname;
    private String scity;
    private double scomm;
    @OneToMany(mappedBy = "salesman")//JPA look at the field salesman to find out how to map the tables.
    private List<Family> members;
    @OneToMany(mappedBy = "salesman")
    private List<Sales> sales;
    
    public Salesman() {
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public double getScomm() {
        return scomm;
    }

    public void setScomm(double scomm) {
        this.scomm = scomm;
    }

    public List<Family> getMembers() {
        return members;
    }

    public void setMembers(List<Family> members) {
        this.members = members;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
    
    @Override
    public String toString() {
        return "Salesman{" + "scode=" + scode + ", sname=" + sname + ", scity=" + scity + ", scomm=" + scomm + '}';
    }
}
