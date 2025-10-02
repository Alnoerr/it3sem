package lab2;

public class Administrator extends Employee {
    public String name;
    public String department;

    public Administrator(String name, String department, int salary) {
        setSalary(salary);
        this.name = name;
        this.department = department;
    }

    public Administrator() {
        setSalary(100000);
        this.name = "Неизвестно";
        this.department = "Административный";
    }

    @Override
    public void work() {
        System.out.println("Администрирует");
    }

    @Override
    public void printInfo() {
        System.out.printf(
                "Администратор %s в департаменте %s с зарплатой %d\n",
                name, department, getSalary()
        );
    }

    public void performSystemCheck() {
        System.out.printf("%s производит проверку системы\n", name);
    }

    public static void main(String[] args) {
        Administrator administrator1 = new Administrator();
        Administrator administrator2 = new Administrator(
                "Valery",
                "IT",
                1200000
        );
        administrator1.work();
        administrator2.printInfo();
        administrator2.performSystemCheck();
        System.out.println(Employee.getInstanceCount());
    }
}
