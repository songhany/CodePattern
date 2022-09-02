package employeeSystem;

public class Employee {
  public static final String company="Yu's company";
  public final String name;
  public final int id;
  private int salary;
  private int level;
  private int pto;  // days of holiday with salary
  public Manager mgr;

  Employee(String name, int id, int level) {
    this.name = name;
    this.id = id;
    this.level = level;
    this.pto = level * 10;
  }

  public void printInfo() {
    System.out.println("Name: " + name + ", ID: " + id);
  }

  public void takePto(int day) {
    if (pto >= day && mgr.approvePto(day, this)) {
      pto -= day;
    } else {
      throw new IllegalArgumentException("Xiang De Mei!");
    }
  }
  
}
