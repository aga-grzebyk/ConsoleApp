package pl.grzebyk.konto;

import pl.grzebyk.konto.Entity.User;

import java.util.Scanner;

public class KontoBankowe {

        static Scanner sc = new Scanner(System.in);
        public static String getUserInput(){
            return sc.nextLine();
        }

        static UserDao dao = new UserDao();

    public static void main(String[] args) {

        String youChose;

        do {
            System.out.println("Witaj na stronie naszego Banku!");
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println("[1]  -->  LOGOWANIE");
            System.out.println("[2]  -->  ZAREJESTRUJ");
            System.out.println("[X]  -->  ZAKONCZ");

            youChose = getUserInput();

            if (youChose.equals("1")) {
                logIn();

            }
            if (youChose.equals("2")) {
                register();

            }
        } while(!youChose.equalsIgnoreCase("x"));
    }

    private static void logIn(){

        User user = new User();

        System.out.println("LOGOWANIE");
        System.out.println("////////////////////////////////////////");
        System.out.println();
        System.out.println("username: ");
        user.setUserName(sc.nextLine());

        System.out.println("password: ");
        user.setPassword(sc.nextLine());

        System.out.println();
        System.out.println("Witaj " + user.getUserName());
        System.out.println("///////////////////////////////////////");
        wybor();
    }

    private static void wybor(){
        String number;
        do {
            System.out.println("/// TWOJE KONTO ///");
            System.out.println("Saldo: " + dao.user.getAccount() + " zł.");
            System.out.println();

            System.out.println("     [1]  -->  WPŁATA ");
            System.out.println("     [2]  -->  WYPŁATA");
            System.out.println("     [3]  -->  SALDO");
            System.out.println("     [X]  -->  ZAKONCZ");
            number = getUserInput();

            if (number.equals("1")) {

                System.out.println("Podaj sumę, którą chcesz wpłacić");
                double amount = Double.valueOf(getUserInput());
                System.out.println("Saldo na twoim koncie wynosi teraz: " + dao.payment(amount));
                System.out.println();

            } else if (number.equals("2")) {

                System.out.println("Podaj sumę, którą chcesz wypłacić");
                double amount = Double.valueOf(getUserInput());

                if (amount <= dao.user.getAccount()) {
                    dao.payOff(amount);
                } else {
                    System.out.println("Suma, którą chcesz wypłacić, przekracza saldo Twojego konta!");
                }

            } else if (number.equals("3")) {
                System.out.println("Saldo na twoim koncie wynosi: " + dao.user.getAccount());
            }
        } while(!number.equalsIgnoreCase("x"));
    }


    private static void register(){

        User user = new User();

        System.out.println("REJESTRACJA");
        System.out.println("////////////////////////////////////////");
        System.out.println();
        System.out.println("Wybierz swój userName: ");
        user.setUserName(getUserInput());

        System.out.println("Wybierz swoje hasło: ");
        user.setPassword(getUserInput());

        System.out.println();
        dao.dodajOsobe(user);
        System.out.println("/////////////////////////////////////");
        System.out.println();
    }
}
