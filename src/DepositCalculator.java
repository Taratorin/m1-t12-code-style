import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateMoney();
    }

    double complexPercentCalculator(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay, 2);
    }

    double simplePercentCalculator(double amount, double yearRate, int period) {
        double pay = amount + amount * yearRate * period;
        return round(pay, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateMoney() {
        int period;
        int action;
        double yearRate;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        System.out.println("Введите годовую ставку: ");
        yearRate = scanner.nextDouble();
        double result = 0;
        if (action == 1) {
            result = simplePercentCalculator(amount, yearRate, period);
        } else if (action == 2) {
            result = complexPercentCalculator(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

}