package ch05.ex1;

/**
 * 직원 정보 클래스
 */
class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getter/Setter
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }

    public void printInfo() {
        System.out.printf("%s (%s부서): %.0f원\n", name, department, salary);
    }
}

/**
 * 급여 관리 시스템
 */
public class SalaryManagement {
    // 급여 인상 (객체의 내부 데이터 변경)
    public static void raiseSalary(Employee emp, double percentage) {
        double currentSalary = emp.getSalary();
        double newSalary = currentSalary * (1 + percentage / 100);
        emp.setSalary(newSalary);
        System.out.printf("%s님의 급여가 %.1f%% 인상되었습니다.\n",
                emp.getName(), percentage);
    }

    // 부서 이동 (객체의 내부 데이터 변경)
    public static void transferDepartment(Employee emp, String newDept) {
        String oldDept = emp.getDepartment();
        emp.setDepartment(newDept);
        System.out.printf("%s님이 %s에서 %s(으)로 이동했습니다.\n",
                emp.getName(), oldDept, newDept);
    }

    // 두 직원의 급여 비교
    public static void compareSalaries(Employee emp1, Employee emp2) {
        double diff = Math.abs(emp1.getSalary() - emp2.getSalary());

        if (emp1.getSalary() > emp2.getSalary()) {
            System.out.printf("%s님이 %s님보다 %.0f원 더 많습니다.\n",
                    emp1.getName(), emp2.getName(), diff);
        } else if (emp2.getSalary() > emp1.getSalary()) {
            System.out.printf("%s님이 %s님보다 %.0f원 더 많습니다.\n",
                    emp2.getName(), emp1.getName(), diff);
        } else {
            System.out.println("두 직원의 급여가 같습니다.");
        }
    }

    // 팀 전체 급여 인상
    public static void raiseTeamSalary(Employee[] team, double percentage) {
        System.out.println("\n=== 팀 전체 급여 인상 ===");
        for (Employee emp : team) {
            if (emp != null) {
                raiseSalary(emp, percentage);
            }
        }
    }

    public static void main(String[] args) {
        // 직원 생성
        Employee emp1 = new Employee("김철수", 3000000, "개발");
        Employee emp2 = new Employee("이영희", 3500000, "마케팅");
        Employee emp3 = new Employee("박민수", 2800000, "인사");

        System.out.println("=== 초기 상태 ===");
        emp1.printInfo();
        emp2.printInfo();
        emp3.printInfo();

        // 개별 급여 인상
        raiseSalary(emp1, 10);

        // 부서 이동
        transferDepartment(emp2, "기획");

        // 급여 비교
        System.out.println("\n=== 급여 비교 ===");
        compareSalaries(emp1, emp2);

        // 팀 구성
        Employee[] devTeam = {emp1, emp3, null, null};
        devTeam[2] = new Employee("정수진", 2500000, "개발");
        devTeam[3] = new Employee("최민호", 2600000, "개발");

        // 팀 전체 급여 인상
        raiseTeamSalary(devTeam, 5);

        System.out.println("\n=== 최종 상태 ===");
        for (Employee emp : devTeam) {
            if (emp != null) {
                emp.printInfo();
            }
        }
    }
}