// работники с почасовой оплатой
public class Freelancer extends Emploee{
    // почасовая ставка
    private int hourlyPay;

    public Freelancer(String nane, String jobTitle, int hourlyPay) {
        super(nane, jobTitle);
        this.hourlyPay = hourlyPay;
    }
    @Override
    double calcAverMonthSalary() {
        return  20.8 * 8 * hourlyPay;

    }
}
