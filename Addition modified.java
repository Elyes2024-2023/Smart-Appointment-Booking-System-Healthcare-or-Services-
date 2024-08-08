import java.util.*;
class Exercise_Addition_Before_Last_Number {
    public static void main(String[] args) {
        System.out.println("Please type a number:");
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        System.out.println("Please type a number:");
        int number2 = sc.nextInt();
        int sum = number1 + number2;
        do {
            System.out.println("Please type a number:");
            int number3 = sc.nextInt();
            sum += number3;
            if (number1 == number3) {
                System.out.println("Sum is " + sum);
                break;
            } else {
                number1 = number2;
                number2 = number3;
            }
        } while (true);
    }
}
/*Explanation of my solution: I started with the 2 first variables input and I fixed them then every entered(entered through "number3" variable) will be replaced and assigned by order to number1 and number2 in this way we can always compare number3(which is the input in while-do loop) with number1*/
//Done on 13/12/2023 by Elyes