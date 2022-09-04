package ood.employeeSystem;

import java.util.*;

public class Manager extends Employee {
  public List<Employee> reports;

  public Manager(String name, int id, int level) {
    super(name, id, level);
    reports = new ArrayList<>();
  }

  public void addReport(Employee employee) {
    reports.add(employee);
    employee.mgr = this;
  }

  @Override
  public void printInfo() {
    System.out.println("Manager Name: " + name + ", ID: " + id);
    for (Employee e : reports) {
      System.out.print("  " + name + "'s report: ");
      e.printInfo();
    }
  }

  public boolean approvePto(int day, Employee employee) {
    return true;
  }
}
