package db.dao.simple;

public class TestEntity {
    private int id;
    private String name;
    private double number;

    public TestEntity(int id, String name, double number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getNumber() {
		return number;
	}



	public void setNumber(double number) {
		this.number = number;
	}

	@Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
