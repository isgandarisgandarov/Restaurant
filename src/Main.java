
import meals.Dessert;
import meals.Salad;
import meals.Meat;



import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Restaurant restaurant = new Restaurant("Semicolon", "Baku, Ataturk str 127", 10000);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        while (true){
            try {
                while (true){
                    greetings();
                    System.out.println("[1] Restaurant management system");
                    System.out.println("[2] Customer service");
                    System.out.println("[3] Exit");
                    System.out.println("Choose:");
                    int choice1 = scanner.nextInt();
                    if (choice1 == 1){

                        while (true){
                            separate();
                            System.out.println("----Restaurant management system----");
                            System.out.println("[1] Employees");
                            System.out.println("[2] Menu");
                            System.out.println("[3] Go back");
                            System.out.println("Choose: ");
                            int choice2 = scanner.nextInt();
                            if (choice2 == 1){

                                while (true) {
                                    separate();
                                    System.out.println("[1] Show employees");
                                    System.out.println("[2] Add employee");
                                    System.out.println("[3] Remove employee");
                                    System.out.println("[4] Go back");
                                    System.out.println("Choose: ");
                                    int choice3 = scanner.nextInt();

                                    if (choice3 == 1) {
                                        restaurant.showEmployees();
                                    }
                                    if (choice3 == 2) {
                                        System.out.println("Enter the name: ");
                                        String name = scanner.next();
                                        System.out.println("Enter the surname: ");
                                        String surname = scanner.next();
                                        System.out.println("Enter the position: ");
                                        String position = scanner.next();
                                        System.out.println("Enter the salary: ");
                                        int salary = scanner.nextInt();
                                        restaurant.addEmployee(name, surname, position, salary);
                                        System.out.println("The employee added successfully");
                                    }
                                    if (choice3 == 3){
                                        int initialSize = restaurant.getEmployees().size();
                                        System.out.println("Enter the name: ");
                                        String name = scanner.next();
                                        System.out.println("Enter the surname: ");
                                        String surname = scanner.next();
                                        restaurant.removeEmployee(name, surname);
                                        if (initialSize == restaurant.getEmployees().size()){
                                            System.out.println("The employee is not found in the system!");
                                        }
                                    }
                                    if (choice3 == 4) break;
                                }
                            }
                            if (choice2 == 2){
                                while (true){
                                    separate();
                                    System.out.println("[1] Show menu");
                                    System.out.println("[2] Add a meal");
                                    System.out.println("[3] Remove a meal");
                                    System.out.println("[4] Go back");
                                    System.out.println("Choose: ");
                                    int choice4 = scanner.nextInt();
                                    if (choice4 == 1){
                                        restaurant.getMenu().showSalads();
                                        restaurant.getMenu().showDesserts();
                                        restaurant.getMenu().showMeats();
                                    }
                                    if (choice4 == 2) {
                                        System.out.println("Choose type of the meal: ");
                                        System.out.println("[1] Salad");
                                        System.out.println("[2] Dessert");
                                        System.out.println("[3] Meat");
                                        int mealChoice = scanner.nextInt();
                                        if (mealChoice == 1) {
                                            System.out.println("Enter the name: ");
                                            String name = scanner.next();
                                            System.out.println("Enter the calories: ");
                                            double calories = scanner.nextDouble();
                                            System.out.println("Enter the price: ");
                                            double price = scanner.nextDouble();
                                            Salad salad = new Salad(name, calories, price);
                                            restaurant.getMenu().addSalads(salad);
                                        }
                                        if (mealChoice == 2) {
                                            System.out.println("Enter the name: ");
                                            String name = scanner.next();
                                            System.out.println("Enter the calories: ");
                                            double calories = scanner.nextDouble();
                                            System.out.println("Enter the price: ");
                                            double price = scanner.nextDouble();
                                            Dessert dessert = new Dessert(name, calories, price);
                                            restaurant.getMenu().addDessert(dessert);
                                        }
                                        if (mealChoice == 3){
                                            System.out.println("Enter the name: ");
                                        String name = scanner.next();
                                        System.out.println("Enter the calories: ");
                                        double calories = scanner.nextDouble();
                                        System.out.println("Enter the price: ");
                                        double price = scanner.nextDouble();
                                        Meat meat = new Meat(name, calories, price);
                                        restaurant.getMenu().addMeat(meat);
                                        }
                                    }
                                    if (choice4 == 3) {
                                        try {
                                            System.out.println("Choose type of the meal: ");
                                            System.out.println("[1] Salad");
                                            System.out.println("[2] Dessert");
                                            System.out.println("[3] Meat");
                                            int mealChoice = scanner.nextInt();
                                            if (mealChoice == 1) {
                                                System.out.println("Enter the name of salad: ");
                                                String name = scanner.next();
                                                restaurant.getMenu().removeSalad(name);
                                            }
                                            if (mealChoice == 2) {
                                                System.out.println("Enter the name of dessert: ");
                                                String name = scanner.next();
                                                restaurant.getMenu().removeDessert(name);
                                            }
                                            if (mealChoice == 3) {
                                                System.out.println("Enter the name of meat: ");
                                                String name = scanner.next();
                                                restaurant.getMenu().removeMeat(name);
                                            }
                                        }catch (ConcurrentModificationException e){
                                            continue;
                                        }
                                    }
                                    if (choice4 == 4) break;

                                }
                            }
                            if (choice2 == 3) break;

                        }

                    }
                    if (choice1 == 2){
                        try {
                            restaurant.getMenu().showSalads();
                            System.out.println("Enter the names of salads that you want separated by space: ");
                            String salad = scanner.next();
                            String[] soldSalads = salad.split(" ");
                            restaurant.getMenu().showMeats();
                            System.out.println("Enter the names of meats that you want separated by space: ");
                            String meat = scanner.next();
                            String[] soldMeats = meat.split(" ");
                            restaurant.getMenu().showDesserts();
                            System.out.println("Enter the names of desserts that you want separated by space: ");
                            String dessert = scanner.next();
                            String[] soldDesserts = dessert.split(" ");

                            totalPrice(soldMeats, soldSalads, soldDesserts, restaurant);
                            restaurant.getFinance().sell(soldMeats,soldSalads,soldDesserts, restaurant);
                            System.out.println();
                        }catch (InputMismatchException e){
                            System.out.println("Wrong input!");
                            }
                    }


                    if (choice1 == 3){
                        System.exit(0);
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Wrong input!");

            }
        }

    }


    public static void totalPrice(String[] meats, String[] salads, String[] desserts,  Restaurant restaurant){
        double totalBill = 0;

        for (Meat soldMeat : restaurant.getMenu().getMeats()){
            for (String meatName : meats){
                if (soldMeat.getName().equals(meatName)){
                    totalBill += soldMeat.getPrice();
                }
            }
        }

        for (Salad soldSalad : restaurant.getMenu().getSalads()){
            for (String saladName : salads){
                if (soldSalad.getName().equals(saladName)){
                    totalBill += soldSalad.getPrice();
                }
            }
        }

        for (Dessert soldDessert : restaurant.getMenu().getDesserts()) {
            for (String dessertName : desserts) {
                if (soldDessert.getName().equals(dessertName)) {
                    totalBill += soldDessert.getPrice();
                }
            }
        }
        System.out.printf("Your bill is %s USD", totalBill);
    }


    public static void greetings(){
        System.out.println("Welcome to the \"Semicolon\" restaurant");
    }

    public static void separate(){
        System.out.println("-------------------------------------------------------------------------------------");
    }


}
