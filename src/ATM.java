import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {


    }

    static boolean passwordverification(String input){
        String pin="1234";
        return (pin.equals(input));

    }

    static boolean welcome(){
        System.out.println("*Welcome to Herman Bank* \n\nPlease enter your 4 digit password:");
        Scanner sc = new Scanner(System.in);

        for (int i=0;i<3;i++){
            String input = sc.nextLine();

            if (passwordverification(input)==true){
                int j=1;
                break;
            }

            //If pin is not correct the third time
            if (i==2) {
                System.out.println("*Herman Bank*\n ALERT:\n“Invalid Access!”\n“Please contact the branch!”\n\nChoose your action by pressing the number \n0. EXIT");

                if (sc.nextInt()==0);
            }
            System.out.println("ou have entered the wrong pin, you have " +(2-i)+ " tries left");
        }
    }



}
