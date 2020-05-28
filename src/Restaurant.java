import java.util.ArrayList;

public class Restaurant {

    private String name, address;
    private final Menu menu = new Menu();

    private final Finance finance = new Finance(0);
    private final ArrayList<Employee> employees =new ArrayList<>();

    public Restaurant(String name, String address, double startingBudget) {
        this.name = name;
        this.address = address;
        finance.setBudget(startingBudget);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Menu getMenu() {
        return menu;
    }

    public Finance getFinance() {
        return finance;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(String name, String surname, String position, double salary){
        Employee addedEmployee = new Employee(name, surname, position, salary);
        employees.add(addedEmployee);
    }

    public void removeEmployee(String name, String surname){
        int size1 = employees.size();

        for (Employee employee : employees){
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)){
                System.out.printf("'%s %s' is removed from the system!", name, surname);
                employees.remove(employee);
                break;
            }
        }
    }

    public void showEmployees(){
        if (employees.size() == 0) System.out.println("There is no employee in the restaurant!");

        else {
            for (Employee employee : employees) {
                System.out.printf("Name: %s Surname: %s Position: %s Salary: %s", employee.getName(), employee.getSurname(),
                        employee.getPosition(), employee.getSalary());
                System.out.println();
            }
        }
    }
}
