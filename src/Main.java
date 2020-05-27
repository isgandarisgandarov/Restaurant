
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
                    separate();
                    greetings();

                    System.out.println("[1] Restaurant management system");
                    System.out.println("[2] Customer service");
                    System.out.println("[3] Exit");

                    choose();

                    int choice1 = scanner.nextInt();

                    switch (choice1){
                        case 1:
                            while (true){
                                separate();

                                System.out.println("----Restaurant management system----");
                                System.out.println("[1] Employees");
                                System.out.println("[2] Menu");
                                System.out.println("[3] Go back");

                                choose();

                                int choice2 = scanner.nextInt();

                                switch (choice2){
                                    case 1:
                                        while (true) {
                                            separate();
                                            showEmployees();

                                            addEmployee();
                                            removeEmployee();

                                            goBack();
                                            choose();

                                            int choice3 = scanner.nextInt();

                                            switch (choice3){
                                                case 1:
                                                    restaurant.showEmployees();
                                                    break;

                                                case 2:
                                                    System.out.println("Enter the name: ");
                                                    String name = scanner.next();

                                                    System.out.println("Enter the surname: ");
                                                    String surname = scanner.next();

                                                    System.out.println("Enter the position: ");
                                                    String position = scanner.next();

                                                    System.out.println("Enter the salary: ");
                                                    double salary = scanner.nextDouble();

                                                    restaurant.addEmployee(name, surname, position, salary);
                                                    System.out.println("The employee added successfully");

                                                    break;

                                                case 3:
                                                    int initialSize = restaurant.getEmployees().size();

                                                    System.out.println("Enter the name: ");
                                                    String nameOfEmployee = scanner.next();

                                                    System.out.println("Enter the surname: ");
                                                    String surnameOfEmployee = scanner.next();

                                                    restaurant.removeEmployee(nameOfEmployee, surnameOfEmployee);

                                                    if (initialSize == restaurant.getEmployees().size()) System.out.println("The" +
                                                            " employee is not found in the system!");
                                                    break;
                                            }

                                            if (choice3 == 4) break;

                                        }
                                        break;
                                    case 2:
                                        while (true){
                                            separate();
                                            showMenu();

                                            addMeal();
                                            removeMeal();

                                            goBack();
                                            choose();

                                            int choice4 = scanner.nextInt();

                                            switch (choice4){
                                                case 1:
                                                    restaurant.getMenu().showSalads();
                                                    restaurant.getMenu().showDesserts();
                                                    restaurant.getMenu().showMeats();
                                                    break;

                                                case 2:
                                                    choose();

                                                    salad();
                                                    dessert();
                                                    meat();

                                                    int mealChoice = scanner.nextInt();

                                                    switch (mealChoice){
                                                        case 1:
                                                            System.out.println("Enter the name: ");
                                                            String nameOfSalad = scanner.next();

                                                            System.out.println("Enter the calories: ");
                                                            double caloriesOfSalad = scanner.nextDouble();

                                                            System.out.println("Enter the price: ");
                                                            double priceOfSalad = scanner.nextDouble();

                                                            Salad salad = new Salad(nameOfSalad, caloriesOfSalad, priceOfSalad);
                                                            restaurant.getMenu().addSalads(salad);

                                                            break;

                                                        case 2:
                                                            System.out.println("Enter the name: ");
                                                            String nameOfDessert = scanner.next();

                                                            System.out.println("Enter the calories: ");
                                                            double caloriesOfDessert = scanner.nextDouble();

                                                            System.out.println("Enter the price: ");
                                                            double priceOfDessert = scanner.nextDouble();

                                                            Dessert dessert = new Dessert(nameOfDessert, caloriesOfDessert, priceOfDessert);
                                                            restaurant.getMenu().addDessert(dessert);

                                                            break;

                                                        case 3:
                                                            System.out.println("Enter the name: ");
                                                            String nameOfMeat = scanner.next();

                                                            System.out.println("Enter the calories: ");
                                                            double caloriesOfMeat = scanner.nextDouble();

                                                            System.out.println("Enter the price: ");
                                                            double priceOfMeat = scanner.nextDouble();

                                                            Meat meat = new Meat(nameOfMeat, caloriesOfMeat, priceOfMeat);
                                                            restaurant.getMenu().addMeat(meat);
                                                            break;
                                                    }
                                                    break;

                                                case 3:
                                                    try {

                                                        choose();

                                                        salad();
                                                        dessert();
                                                        meat();

                                                        int mealChoice2 = scanner.nextInt();

                                                        switch (mealChoice2){
                                                            case 1:
                                                                System.out.println("Enter the name of salad: ");
                                                                String nameOfSalad = scanner.next();
                                                                restaurant.getMenu().removeSalad(nameOfSalad);
                                                                break;

                                                            case 2:
                                                                System.out.println("Enter the name of dessert: ");
                                                                String nameOfDessert = scanner.next();
                                                                restaurant.getMenu().removeDessert(nameOfDessert);
                                                                break;

                                                            case 3:
                                                                System.out.println("Enter the name of meat: ");
                                                                String nameOfMeat = scanner.next();
                                                                restaurant.getMenu().removeMeat(nameOfMeat);
                                                                break;
                                                        }

                                                    }catch (ConcurrentModificationException e){
                                                        continue;
                                                    }
                                                    break;
                                            }

                                            if (choice4 == 4) break;
                                        }
                                        break;
                                }
                                if (choice2 == 3) break;
                            }
                            break;

                        case 2:
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
                            break;

                        case 3:
                            System.exit(0);
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Wrong input!");
                scanner.nextLine(); // in order not to have an endless loop
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

    public static void showEmployees(){
        System.out.println("[1] Show employees");
    }

    public static void addEmployee(){
        System.out.println("[2] Add employee");
    }

    public static void removeEmployee(){
        System.out.println("[3] Remove employee");
    }

    public static void goBack(){
        System.out.println("[4] Go back");
    }

    public static void choose(){
        System.out.println("Choose: ");
    }

    public static void showMenu(){
        System.out.println("[1] Show menu");
    }

    public static void addMeal(){
        System.out.println("[2] Add a meal");
    }

    public static void removeMeal(){
        System.out.println("[3] Remove a meal");
    }

    public static void salad(){
        System.out.println("[1] Salad");
    }

    public static void dessert(){
        System.out.println("[2] Dessert");
    }

    public static void meat(){
        System.out.println("[3] Meat");
    }

}
