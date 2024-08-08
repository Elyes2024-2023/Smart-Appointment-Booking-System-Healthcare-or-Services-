import java.util.*;
class Exercise_addition {
    public static void main(String[] args) {
        int sum=0;
        int timer=0;
        do {
            System.out.println("Enter a positive number");
            Scanner sc=new Scanner(System.in);
            int number=sc.nextInt();
            sum+=number;
            timer++;
            if (((sum <100) && (number>0))==false){
                System.out.println("the number of received numbers is");
                System.out.print(timer);
                break;
            }
        }while (true);
    }
}