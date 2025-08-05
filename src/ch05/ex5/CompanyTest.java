package ch05.ex5;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * 종합적인 직원 관리 시스템
 */
abstract class Employee {
    protected String id;
    protected String name;
    protected String department;
    protected LocalDate hireDate;

    public Employee(String id, String name, String department) {
        // TODO 70: 필드 초기화하기
        this.id = id;
        this.name = name;
        this.department = department;
        this.hireDate = LocalDate.now();
    }

    // 추상 메서드
    public abstract double calculateMonthlySalary();
    public abstract String getPosition();

    // 공통 메서드
    public int getYearsOfService() {
        // TODO 71: 근속 연수 계산하기
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        // TODO 72: 직원 정보 문자열 반환하기
        return name + " (" + id + ") - " + getPosition() + ", " + department + "부서, 연차: " + getYearsOfService() + "년";
    }
}

// 정규직 직원
class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double bonus;

    public FullTimeEmployee(String id, String name, String department, double baseSalary) {
        // TODO 73: 부모 생성자 호출하고 필드 초기화하기
        super(id, name, department);
        this.baseSalary = baseSalary;
        this.bonus = 0;
    }

    @Override
    public double calculateMonthlySalary() {
        // TODO 74: 월급 계산하기
        return baseSalary + bonus;
    }

    @Override
    public String getPosition() {
        // TODO 75: "정규직" 반환하기
        return "정규직";
    }

    public void setBonus(double bonus) {
        // TODO 76: 보너스 설정하기
        this.bonus = bonus;
    }
}

// 계약직 직원
class ContractEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String id, String name, String department, double hourlyRate) {
        // TODO 77: 부모 생성자 호출하고 필드 초기화하기
        super(id, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    @Override
    public double calculateMonthlySalary() {
        // TODO 78: 월급 계산하기
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getPosition() {
        // TODO 79: "계약직" 반환하기
        return "계약직";
    }

    public void setHoursWorked(int hours) {
        // TODO 80: 근무 시간 설정하기
        this.hoursWorked = hours;
    }
}

// 직원 관리 시스템
class EmployeeManagementSystem {
    private Map<String, Employee> employees;

    public EmployeeManagementSystem() {
        // TODO 81: employees를 새 HashMap으로 초기화하기
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        // TODO 82: 직원 추가하기
        employees.put(employee.id, employee);
        System.out.println("직원 추가: " + employee.toString());
    }

    public double calculateTotalMonthlySalary() {
        // TODO 83: 전체 월급 총액 계산하기
        double total = 0;
        for (Employee employee : employees.values()) {
            total += employee.calculateMonthlySalary();
        }
        return total;
    }

    public void displaySalaryReport() {
        // TODO 84: 급여 보고서 출력하기
        System.out.println("=== 급여 보고서 ===");
        for (Employee employee : employees.values()) {
            System.out.println(employee.name + " (" + employee.getPosition() + "): " +
                    (int)employee.calculateMonthlySalary() + "원");
        }
        System.out.println("전체 월 급여 총액: " + (int)calculateTotalMonthlySalary() + "원");
    }
}

// 테스트
public class CompanyTest {
    public static void main(String[] args) {
        // TODO 85: 직원 관리 시스템 생성하기
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // TODO 86: 다양한 직원 추가하기
        FullTimeEmployee fullTime = new FullTimeEmployee("E001", "김철수", "개발부", 3000000);
        ContractEmployee contract = new ContractEmployee("E002", "이영희", "디자인부", 50000);

        ems.addEmployee(fullTime);
        ems.addEmployee(contract);

        // TODO 87: 보너스와 근무시간 설정하기
        fullTime.setBonus(500000);
        contract.setHoursWorked(160);

        System.out.println();

        // TODO 88: 급여 보고서 출력하기
        ems.displaySalaryReport();
    }
}