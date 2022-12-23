import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return doRound(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double yearRate, int depositPeriod) {
        return doRound(doubleAmount + doubleAmount * yearRate * depositPeriod, 2);
    }

    double doRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateResultByContribution() {
        double finalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        if (action == 1) {
            finalAmount = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            finalAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateResultByContribution();
    }
}
