package emergon.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", columnDefinition = "int")
    private Integer sid;
    @Column(name = "typos")
    private String typos;//Electronics, Toys
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Salesman> salesmen;

    public Store() {
    }

    public Store(String typos) {
        this.typos = typos;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTypos() {
        return typos;
    }

    public void setTypos(String typos) {
        this.typos = typos;
    }

    @Override
    public String toString() {
        return "Store{" + "sid=" + sid + ", typos=" + typos + '}';
    }
    
    
}
