package ss2.thuc_hanh;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        double interestRate,loanMoney,month,subMoney;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount you want to interest rate: ");
        interestRate = sc.nextDouble();
        System.out.println("Enter the amount you want to borrow money: ");
        loanMoney = sc.nextDouble();
        System.out.println("Enter the month you want to borrow: ");
        month = sc.nextDouble();
        subMoney=loanMoney;
        for (int i = 0; i < month; i++) {
            subMoney = subMoney+loanMoney*month*(interestRate/100)/12;
        }
        System.out.println("Total of interest : "+subMoney);
    }
}
