import java.util.Scanner;

public class ATM {

    static Scanner sc = new Scanner(System.in);
    static int inputint;
    static int withdrawn;
    static int deposit;
    static int balance = 1000;
    static int language;
    static boolean withdrawing;

    public static void main(String[] args) {
        welcome();
    }

    static void exit(int language) {
        System.out.println(withdrawn + deposit + (balance - withdrawn + deposit));
    }

    static void welcome() {
        System.out.println("*Welcome to Herman Bank* \n\nPlease enter your 4 digit password:");
        String input;
        String pin = "1234";

        for (int i = 0; i < 3; i++) {
            input = sc.nextLine();

            //Just continue to language function
            if (pin.equals(input)) language();

                //If pin is not correct the third time
            else if (i == 2) {
                System.out.println("*Herman Bank*\n ALERT:\n“Invalid Access!”\n“Please contact the branch!”\n\nChoose your action by pressing the number \n0. EXIT");
                try {
                    inputint = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Bad input, but you will exit anyway:)");
                }

                if (inputint == 0) break;

                else {
                    System.out.println("Bad input, but you will exit anyway:)");
                    break;
                }
            }
            System.out.println("You have entered the wrong pin, you have " + (2 - i) + " tries left");
        }
        //if we reach this it just terminates the program.
    }

    static void language() {
        System.out.println("*Herman Bank*\n*Language*\n\nChoose your action by pressing the number\n1. English\n2. Slovak\n0. EXIT");

        try {
            inputint = sc.nextInt();
            language = inputint;
           // System.out.println("toto je jazyk "+language);
        } catch (Exception e) {
            System.out.println("Bad input try again");
            language();
        }

        if (language < 0 || language > 3) {
            System.out.println("Bad input try again");
            language();}

        if (language == 0) {
            exit(1);
        }
            menu(language);
        }

    static void menu(int language) {
        System.out.println("""
                *Herman Bank*
                *Menu*

                Choose your action by pressing the number
                1. Withdraw
                2. Deposit
                3. Balance Inquiry
                0. EXIT"""); //fix this later

        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Bad input try again");
            menu(language);
        }

        if (inputint < 0 || inputint > 3) {
            System.out.println("Bad input try again");
            menu(language);
        }

        switch (inputint) {
            case 0:
                exit(language);

            case 1:
                balance = balance - withdraw(language);

            case 2:
                balance = balance + deposit(language);

            case 3:
                inquiry(language);
        }
    }

    static int withdraw(int language) {
        System.out.println("withdraw page");
        withdrawing=true;
        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Bad input try again");
            return withdraw(language);
        }
        if (!(inputint>balance))
            return inputint;
        else
            return invalidentry(language,withdrawing);
    }

    static int deposit(int language) {
        System.out.println("deposit page");
        withdrawing =false;
        try {
            inputint = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Bad input try again");
            return deposit(language);
        }
        if (!(inputint<=0))
            return inputint;//fix me pls
        else
            return invalidentry(language,withdrawing);
    }

        static int invalidentry(int language, boolean withdrawing){
            System.out.println("invalid Entry");
            try{
                inputint =sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Bad input try again");
                return invalidentry(language, withdrawing);
            }

            if (inputint ==0 && withdrawing) return withdraw(language);
            else if (inputint ==0) return deposit(language);
            else {
                System.out.println("Bad input, try again");
                return invalidentry(language,withdrawing);
            }
            }



    static void inquiry(int language){
        System.out.printf("""
                *Herman Bank*
                *Balance Inquiry*

                The balance is $%d

                Choose your action by pressing the number
                0. Exit
                """,balance);

        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Bad input try again");
            inquiry(language);
        }
            if (inputint == 0) menu(language);

            else {
                System.out.println("Bad input try again");
                inquiry(language);
            }

    }
    }






