package emergon.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Family implements Serializable{
    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key(auto increment)
    private int fid;
    private String fname;
    private String frelationship;
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "salesman")//owning side
    private Salesman salesman;
    
    public Family() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(String frelationship) {
        this.frelationship = frelationship;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Family{" + "fid=" + fid + ", fname=" + fname + ", frelationship=" + frelationship + ", dob=" + dob + '}';
    }
    
    
}
