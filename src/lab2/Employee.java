package lab2;

abstract class Employee {
    private static int instanceCount = 0;
    private int salary;
    private final int minimalSalary = 19329;

    abstract public void work();
    abstract public void printInfo();

    Employee() {
        instanceCount++;
    }

    public void setSalary(int amount) {
        if (amount >= minimalSalary) {
            salary = amount;
        } else {
            System.out.println("нет");
        }
    }

    public int getSalary() {
        return salary;
    }

    public int getMinimalSalary() {
        return minimalSalary;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
