package hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.DoubleSummaryStatistics;

@Entity
@Table( name = "Test" )
public class Test {

    private Integer id;
    private String name;
    private Double number;

    public Test() {
        // this form used by Hibernate
    }

    public Test(String name, Double number) {
        // for application use, to create new events
        this.name = name;
        this.number = number;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
}
