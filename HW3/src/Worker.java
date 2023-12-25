// работники с фиксированниой зарплатой
public class Worker extends Emploee{

    // фиксированная месячная оплата
    private double fixMonthSalary;

    public Worker(String name, String jobTitle, double fixMonthSalary) {
        super(name, jobTitle);
        this.fixMonthSalary = fixMonthSalary;
    }

    @Override
    double calcAverMonthSalary() {
        return fixMonthSalary;
    }
}

