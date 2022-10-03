import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        //if exitflag was raised end the program
        if (welcome()) return;

        int language = language();
        //exitflag was raised
        if (language == 0) return;




    }

    static boolean welcome(){
        System.out.println("*Welcome to Herman Bank* \n\nPlease enter your 4 digit password:");
        Scanner sc = new Scanner(System.in);
        String input;
        String pin="1234";
        boolean exitflag = false;
        int inputint = 12; //Just a random number so that it compiles.

        for (int i=0;i<3;i++){
            input = sc.nextLine();

            //Just continue main funcion
            if (pin.equals(input)) break;

            //If pin is not correct the third time
            else if (i==2) {
                System.out.println("*Herman Bank*\n ALERT:\n“Invalid Access!”\n“Please contact the branch!”\n\nChoose your action by pressing the number \n0. EXIT");
                 try {
                     inputint = sc.nextInt();
                 } catch (Exception e) {
                     System.out.println("Bad input, but you will exit anyway:)");
                 }
            }
                if (inputint==0){
                    exitflag = true;
                    break;
                }
                else{
                    System.out.println("Bad input, but you will exit anyway:)");
                }
            System.out.println("You have entered the wrong pin, you have " +(2-i)+ " tries left");
            }
        return exitflag;
        }

        static int language(){
            Scanner sc = new Scanner(System.in);
            int inputint;
            System.out.println("*Herman Bank*\n*Language*\n\nChoose your action by pressing the number\n1. English\n2. Slovak\n0. EXIT");

            try {
                inputint = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Bad input you will exit.");
                return 0;

            }
        return inputint;
        }



    }




