package com.itclass.jpa;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;


@Entity 
@Table(name="cars")
// можно указывать названия столбцов
// @Table(name="cars", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Car {
	
	@Id
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

/*классу выше, соответствует класс*/ 
class Car_{
	public static volatile SingularAttribute<Car, Long> id;
}
