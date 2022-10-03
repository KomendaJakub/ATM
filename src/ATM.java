import java.util.Scanner;

public class ATM {

    static Scanner sc = new Scanner(System.in);
    static int inputint;
    static int withdrawn;
    static int deposit;
    static int balance = 1000;
    static int language;
    static boolean withdrawing;
    static int counter;
    static int number;

    public static void main(String[] args) {
        welcome();
    }

    static void exit(int language) {
        System.out.println();
        if (language==1) System.out.printf("""
*Herman Bank*
*Exit*

Total Amount of withdraw is $%d
Total Amount of deposit is $%d
The new balance is $%d

“Good Bye”

“Thanks for choosing Herman Bank. See you soon.”
                """,withdrawn,deposit,balance);
        else System.out.printf("""
*Herman Bank*
*VÝCHOD*

Celková suma výberu je $%d
Celková výška vkladu je %d $
Nový zostatok je %d $

"Zbohom"

„Ďakujeme, že ste si vybrali Herman Bank. Do skorého videnia.”
                 """,withdrawn,deposit,balance);

        System.exit(0);
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
        if (language==1)
        System.out.println("""
                *Herman Bank*
                *Menu*

                Choose your action by pressing the number
                1. Withdraw
                2. Deposit
                3. Balance Inquiry
                0. EXIT""");
        else System.out.println("""
                 *Herman Bank*
                 *Ponuka*
                                
                 Vyberte svoju akciu stlačením čísla
                 1. Odstúpiť
                 2. Záloha
                 3. Vyšetrovanie zostatku
                 0. VÝSTUP
                """);

        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            if (language==1)
                System.out.println("Bad input try again");
            else
                System.out.println("Zlý vstup, skúste to znova");
            menu(language);
        }

        if (inputint < 0 || inputint > 3) {
            if (language==1)
                System.out.println("Bad input try again");
            else
                System.out.println("Zlý vstup, skúste to znova");
            menu(language);
        }

        switch (inputint) {
            case 0:
                exit(language);

            case 1:
                counter = withdraw(language);
                withdrawn+=counter;
                balance = balance - counter;
                menu(language);

            case 2:
                counter = deposit(language);
                deposit+=counter;
                balance = balance + counter;
                menu(language);

            case 3:
                inquiry(language);
                menu(language);
        }
    }

    static int withdraw(int language) {

        if (language==1)
        System.out.print("""
                *Herman Bank*
                *Withdraw*
                                
                Enter the amount you want to withdraw ($)
                $""");
        else
            System.out.print("""
                 *Herman Bank*
                 *Vybrať*
                                
                 Zadajte sumu, ktorú chcete vybrať ($)
                 $""");

        withdrawing=true;
        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            if (language==1)
            System.out.println("Bad input try again");
            else System.out.println("Zlý vstup, skúste to znova");

            return withdraw(language);
        }
        if (language==1)
        System.out.println("""
                Choose your action by pressing the number
                0. Exit
                """);
        else System.out.println("""
                 Vyberte svoju akciu stlačením čísla
                 0. Výstup
                 """);

        try {number= sc.nextInt();}
        catch (Exception e){
            if (language==1)
                System.out.println("Bad input, but you will exit anyway:)");
            else System.out.println("Zlý vstup, ale aj tak odídeš :)");
        }
        if ((number != 0)&&language==1){System.out.println("Bad entry but it will execute anyway :)");}
        else if (number!=0){
            System.out.println("Zlý vstup, ale aj tak sa to vykoná :)");
        }
        if (inputint<=balance&&inputint>=0)
            return inputint;
        else
            return invalidentry(language,withdrawing);
        }

    static int deposit(int language) {
        if (language==1)
        System.out.print("""
                *Herman Bank*
                *Deposit*
                                
                Enter the amount you want to deposit ($)
                $
                """);

        else System.out.println("""
                 *Herman Bank*
                 *Záloha*
                                
                 Zadajte sumu, ktorú chcete vložiť ($)
                 $
                 """);

        withdrawing =false;
        try {
            inputint = sc.nextInt();
        }
        catch (Exception e) {
            if (language==1)  System.out.println("Bad input try again");
            else System.out.println("Zlý vstup, skúste to znova");
            return deposit(language);
        }
        if (language==1) System.out.println("""
                Choose your action by pressing the number
                0. Exit
                """);
        else System.out.println("""
                 Vyberte svoju akciu stlačením čísla
                 0. Výstup
                 """);

        try {number=sc.nextInt();}
        catch (Exception e){
            if (language==1) System.out.println("Bad input, but you will exit anyway:)");
            else System.out.println("Zlý vstup, ale aj tak odídeš :)");
        }
        if (!(number==0))
            if (language==1) System.out.println("Bad input, but it will execute anyway :)");
            else System.out.println("Zlý vstup, ale aj tak sa to vykoná :)");
        if (!(inputint<=0))
            return inputint;
        else
            return invalidentry(language,withdrawing);

    }

        static int invalidentry(int language, boolean withdrawing){
            if (language==1) System.out.println("""
                                  *Herman Bank*
                                  
                                  ALERT:
                                  “Invalid Entry!”
                                  
                                  Choose your action by pressing the number
                                  0. Go Back
                                  """);

            else System.out.println("""
                                   *Herman Bank*
                                  
                                   UPOZORNENIE:
                                   “Neplatný záznam!”
                                  
                                   Vyberte svoju akciu stlačením čísla
                                   0. Vráťte sa späť
                                   """);

            try{
                inputint =sc.nextInt();
            }
            catch (Exception e) {
                if (language==1) System.out.println("Bad input try again");
                else System.out.println("Zlý vstup, skúste to znova");

                return invalidentry(language, withdrawing);
            }
            if (inputint ==0 && withdrawing) return withdraw(language);
            else if (inputint ==0) return deposit(language);
            else {
                if (language==1) System.out.println("Bad input try again");
                else System.out.println("Zlý vstup, skúste to znova");
                return invalidentry(language,withdrawing);
            }
            }



    static void inquiry(int language){
        if (language==1) System.out.printf("""
                *Herman Bank*
                *Balance Inquiry*

                The balance is $%d

                Choose your action by pressing the number
                0. Exit
                """,balance);
        else System.out.printf("""
                 *Herman Bank*
                 *Dopyt na zostatok*

                 Zostatok je %d $

                 Vyberte svoju akciu stlačením čísla
                 0. Výstup
                 """,balance);

        try {
            inputint = sc.nextInt();
        } catch (Exception e) {
            if (language==1) System.out.println("Bad input try again");
            else System.out.println("Zlý vstup, skúste to znova");
            inquiry(language);
        }
            if (inputint == 0) menu(language);

            else {
                if (language==1) System.out.println("Bad input try again");
                else System.out.println("Zlý vstup, skúste to znova");
                inquiry(language);
            }

    }
    }






