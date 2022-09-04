package employeeSystem;

public class EmployeeSystem {
  public static void main(String[] args) {
    Manager songhan = new Manager("Songhan", 0, 10);
    Employee ricardo = new Employee("Ricardo", 888, 5);
    Employee newBie = new Employee("NewBie", 9999, 1);
  
    songhan.addReport(ricardo);
    songhan.addReport(newBie);
  
    songhan.printInfo();
    System.out.println();

    ricardo.printInfo();
    newBie.printInfo();
  
    ricardo.takePto(1);
  }

  static Employee LCA(Employee a, Employee b) {
    return null;
  }
}
