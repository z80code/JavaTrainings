package practice.payers;

public class LegalEntity implements Payer {
    private String name;
    private int rateOfSale;
    private int id;

    public LegalEntity(String name, int rateOfSale, int id) {
        this.name = name;
        this.rateOfSale = rateOfSale;
        this.id = id;
    }

    @Override
    public void pay(int count) {
        System.out.println("==============");
        System.out.println("Payer: "+name);
        System.out.println("Bye: "+ count);
        System.out.println("CostPerOne: "+ CostPerOne);

        int cost = (int)(CostPerOne*count*(100-rateOfSale)/100f);

        System.out.println("Cost: "+ cost);
        System.out.println("==============");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRateOfSale() {
        return rateOfSale;
    }

    public void setRateOfSale(int rateOfSale) {
        this.rateOfSale = rateOfSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
