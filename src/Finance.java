import meals.Dessert;
import meals.Salad;
import meals.Meat;

import java.util.ArrayList;

public class Finance implements Transaction {

    private double budget;

    public Finance(double budget) {
        this.budget = budget;
    }

    @Override
    public void sell(String[] meats, String[] salads, String[] desserts,  Restaurant restaurant) {
        for (Meat soldMeat : restaurant.getMenu().getMeats()){

            for (String meatName : meats){

                if (soldMeat.getName().equals(meatName)){
                    budget += soldMeat.getPrice();
                }
            }
        }

        for (Salad soldSalad : restaurant.getMenu().getSalads()){

            for (String saladName : salads){

                if (soldSalad.getName().equals(saladName)){
                    budget += soldSalad.getPrice();
                }
            }
        }

        for (Dessert soldDessert : restaurant.getMenu().getDesserts()){

            for (String dessertName : desserts){

                if (soldDessert.getName().equals(dessertName)){
                    budget += soldDessert.getPrice();
                }
            }
        }
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
