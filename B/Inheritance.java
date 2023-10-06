
class Employee {
    String Name, Address, PhoneNumber;
    int Age, Salary;

    public Employee(String Name, int Age, String PhoneNumber, String Address, int Salary) {
        this.Name = Name;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Salary = Salary;
    }

    public void printSalary() {
        System.out.println("The salary is " + this.Salary);
    }
}

class Officer extends Employee {
    String specialization, department;

    public Officer(String Name, int Age, String PhoneNumber, String Address, int Salary, String specialization, String department) {
        super(Name, Age, PhoneNumber, Address, Salary);
        this.specialization = specialization;
        this.department = department;
    }
}

class Manager extends Employee {
    String specialization, department;
    public Manager(String Name, int Age, String PhoneNumber, String Address, int Salary, String specialization, String department) {
        super(Name, Age, PhoneNumber, Address, Salary);
        this.specialization = specialization;
        this.department = department;
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Officer officer1 = new Officer("Ham", 30, "388399283", "Home", 83729, "Lead", "HR");
        Manager manager1 = new Manager("Jam", 32, "324324324", "Work", 49399, "Team lead", "Market");

        officer1.printSalary();
        manager1.printSalary();
    }
}
