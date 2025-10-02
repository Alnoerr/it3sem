package lab2;

public class Manager extends Employee {
    public String name;
    public String department;
    public boolean isRegional;

    public Manager(String name, String department, int salary, boolean isRegional) {
        setSalary(salary);
        this.name = name;
        this.department = department;
        this.isRegional = isRegional;
    }

    public Manager() {
        setSalary(90000);
        this.name = "Неизвестно";
        this.department = "Менеджмент";
        this.isRegional = false;
    }

    @Override
    public void work() {
        System.out.println("Планирует");
    }

    @Override
    public void printInfo() {
        System.out.printf(
                "Менеджер %s в департаменте %s с зарплатой %d\n",
                name, department, getSalary()
        );
    }

    public void createMeeting() {
        System.out.printf("%s организует совещание\n", name);
    }

    public static void main(String[] args) {
        Manager manager1 = new Manager();
        Manager manager2 = new Manager(
                "Ilya",
                "Management",
                400000,
                true
        );
        manager1.work();
        manager1.createMeeting();
        manager2.printInfo();
    }
}
