package 体系结构.个人所得税计算;

import java.util.Scanner;

public class PersonalIncomeTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入年收入：");
        double income = scanner.nextDouble();

        double tax = calculateTax(income);
        System.out.println("应缴纳个人所得税：" + tax);
    }

    public static double calculateTax(double income) {
        double tax;

        if (income <= 36000) {
            tax = income * 0.03;
        } else if (income <= 144000) {
            tax = (income - 36000) * 0.1 + 1080;
        } else if (income <= 300000) {
            tax = (income - 144000) * 0.2 + 12480;
        } else if (income <= 420000) {
            tax = (income - 300000) * 0.25 + 34680;
        } else if (income <= 660000) {
            tax = (income - 420000) * 0.3 + 52920;
        } else if (income <= 960000) {
            tax = (income - 660000) * 0.35 + 85920;
        } else {
            tax = (income - 960000) * 0.45 + 181920;
        }

        return tax;
    }
}

