package pl.devfoundry.testing;

import java.util.Objects;

public class Meal {
    private int price;
    private int quantity;
    private String name;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() { return quantity; }

    public String getName() { return this.name; }

    public int getDiscountedPrice(int discount) {
        if(discount > this.price) {
            throw new IllegalArgumentException("Discount cannot be higher that the price!");
        }
        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Meal meal = (Meal) o;

        if(this.price != meal.price)
            return false;
        return Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
