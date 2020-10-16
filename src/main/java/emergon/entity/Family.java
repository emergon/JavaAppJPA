package emergon.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Family implements Serializable{
    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key(auto increment)
    @Column(name = "fid" , columnDefinition = "int")
    private int fid;
    private String fname;
    @Enumerated(EnumType.STRING)
    private FamilyType frelationship;
    private LocalDate dob;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salesman", foreignKey = @ForeignKey(name = "salesman_fk"))//owning side
    private Salesman salesman;
    
    public Family() {
    }

    public Family(String fname, FamilyType frelationship, LocalDate dob) {
        this.fname = fname;
        this.frelationship = frelationship;
        this.dob = dob;
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

    public FamilyType getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(FamilyType frelationship) {
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
