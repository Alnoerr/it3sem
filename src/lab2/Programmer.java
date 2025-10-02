package lab2;

public class Programmer extends Employee {
    public String name;
    public String department;
    public String specialization;

    public Programmer(String name, String department, int salary, String specialization) {
        setSalary(salary);
        this.name = name;
        this.department = department;
        this.specialization = specialization;
    }

    public Programmer() {
        setSalary(80000);
        this.name = "Неизвестно";
        this.department = "IT";
    }

    @Override
    public void work() {
        System.out.println("Программирует");
    }

    @Override
    public void printInfo() {
        System.out.printf(
                "Программист %s в департаменте %s с зарплатой %d\n",
                name, department, getSalary()
        );
    }

    public void createNewProject() {
        System.out.printf("%s создал новый проект\n", name);
    }

    public static void main(String[] args) {
        Programmer programmer1 = new Programmer();
        Programmer programmer2 = new Programmer(
                "Jora",
                "IT",
                120000,
                "Frontend"
        );
        programmer1.work();
        programmer2.createNewProject();
        programmer2.printInfo();
    }
}
