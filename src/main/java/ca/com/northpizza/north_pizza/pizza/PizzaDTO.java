package ca.com.northpizza.north_pizza.pizza;

public class PizzaDTO {
    private String name;
    private Flavour flavour;
    private double price;
    private Size sizes;
    private boolean availability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSizes() {
        return sizes;
    }

    public void setSizes(Size sizes) {
        this.sizes = sizes;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
