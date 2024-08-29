package ss1.thuc_hanh;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        switch (month) {
            case 2:
                System.out.println("February has 28 days or 29 days (if leap year");
                break;
            case 4:
                case 6:
                    case 9:
                        case 11:
                            System.out.println("this month has 30 days");
                            break;
            case 1:
                case 3:
                    case 5:
                        case 7:
                            case 8:
                                case 10:
                                    case 12:
                                        System.out.println("this month"+month+" has 31 days");
                                        break;
            default:
                System.out.println("Invalid input !");
                break;
        }
    }
}
