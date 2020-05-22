package meals;

public class Meal {
    private final String name;
    private final double calories, price;

    public Meal(String name, double calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }
}
