package ch05.ex6;

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void printPaySlip() {
        System.out.println("=== 급여 명세서 ===");
        System.out.println("직원명: " + name);
        System.out.println("기본급: " + baseSalary);
        System.out.println("총 급여: " + calculateSalary());
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }

    @Override
    public void printPaySlip() {
        super.printPaySlip();
        System.out.println("보너스: " + bonus);
        System.out.println("=================");
    }
}

class Developer extends Employee {
    private double overtimePay;
    private int overtimeHours;

    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
        this.overtimePay = 30000;
    }

    public void setOvertimeHours(int hours) {
        this.overtimeHours = hours;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + (overtimeHours * overtimePay);
    }

    @Override
    public void printPaySlip() {
        super.printPaySlip();
        System.out.println("야근 시간: " + overtimeHours + "시간");
        System.out.println("야근 수당: " + (overtimeHours * overtimePay));
        System.out.println("=================");
    }
}

// 테스트
public class MethodExtensionExample {
    public static void main(String[] args) {
        Employee emp = new Employee("김직원", 2500000);
        Manager mgr = new Manager("이과장", 3500000, 1000000);
        Developer dev = new Developer("박개발", 3000000);

        dev.setOvertimeHours(20);

        System.out.println("일반 직원:");
        emp.printPaySlip();
        System.out.println();

        System.out.println("관리자:");
        mgr.printPaySlip();
        System.out.println();

        System.out.println("개발자:");
        dev.printPaySlip();
    }
}
