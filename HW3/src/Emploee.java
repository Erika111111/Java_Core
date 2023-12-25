/*
Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
 */
public abstract class Emploee {
    protected String name;
    protected String jobTitle;

    /**
     *
     * @param name поле имя работника
     * @param jobTitle поле должность работника
     */
    public Emploee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }
    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setNane(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * абстрактный метод для расчёта среднемесячной заработной платы
     */
    abstract double calcAverMonthSalary();

    @Override
    public String toString() {
        return "Emploee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
