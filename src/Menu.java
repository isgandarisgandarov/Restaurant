import meals.Dessert;
import meals.Meat;
import meals.Salad;

import java.util.ArrayList;

public class Menu {

    private final ArrayList<Dessert> desserts = new ArrayList<>();
    private final ArrayList<Meat> meats = new ArrayList<>();
    private final ArrayList<Salad> salads = new ArrayList<>();

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public ArrayList<Meat> getMeats() {
        return meats;
    }

    public ArrayList<Salad> getSalads() {
        return salads;
    }

    public void showDesserts() {
        if (desserts.size() == 0) System.out.println("No dessert available");
        else{
            System.out.println("Available desserts:");
            for(Dessert dessert : desserts){
                System.out.printf("Name: %s, Calories: %s, Price: %s  ", dessert.getName(), dessert.getCalories(), dessert.getPrice());
                System.out.println();
            }
            System.out.println();
        }
    }

    public void showMeats() {
        if (meats.size() == 0) System.out.println("No meat available");
        else{
            System.out.println("Available meats:");
            for(Meat meat : meats){
                System.out.printf("Name: %s, Calories: %s, Price: %s  ", meat.getName(), meat.getCalories(), meat.getPrice());
                System.out.println();
            }
            System.out.println();
        }
    }

    public void showSalads() {
        if (salads.size() == 0) System.out.println("No salad available");
        else{
            System.out.println("Available salads:");
            for(Salad salad : salads){
                System.out.printf("Name: %s, Calories: %s, Price: %s  ", salad.getName(), salad.getCalories(), salad.getPrice());
                System.out.println();
            }
            System.out.println();
        }
    }

    public void addDessert(Dessert addedDessert){
        desserts.add(addedDessert);
    }

    public void addMeat(Meat addedMeat){
        meats.add(addedMeat);
    }

    public void addSalads(Salad addedSalad){
        salads.add(addedSalad);
    }

    public void removeDessert(String removedDessertName){
        for (Dessert dessert : desserts){
            if (dessert.getName().equals(removedDessertName)){
                System.out.printf("'%s' is removed from the menu. \n", dessert.getName());
                desserts.remove(dessert);
            }
        }
    }

    public void removeMeat(String removedMeatName){
        for (Meat meat : meats){
            if (meat.getName().equals(removedMeatName)){
                System.out.printf("'%s' is removed from the menu. \n", meat.getName());
                meats.remove(meat);
            }
        }
    }

    public void removeSalad(String removedSaladName){
        for (Salad salad : salads){
            if (salad.getName().equals(removedSaladName)){
                System.out.printf("'%s' is removed from the menu. \n", salad.getName());
                salads.remove(salad);
            }
        }
    }
}
