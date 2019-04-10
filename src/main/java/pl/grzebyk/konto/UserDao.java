package pl.grzebyk.konto;

import pl.grzebyk.konto.Entity.User;

import java.util.*;

public class UserDao {

    User user = new User();
    Set<User> lista = new HashSet<User>();
    Map<String, String> users = new HashMap<String, String>();


    public double payment(double sum) {
        double konto = user.getAccount() + sum;
        user.setAccount(konto);
            return konto;
        }


    public double payOff(double sum) {
        double konto = user.getAccount() - sum;
        user.setAccount(konto);
        return konto;
    }


    public void dodajOsobe(User user) {
        if(users.containsKey(user.getUserName())){
            System.out.println("Konto z userName: " + user.getUserName() +" już istnieje!");
            System.out.println();
            System.out.println("--------- Spróbuj ponownie ----------");
        } else {
            users.put(user.getUserName(), user.getPassword());
            System.out.println("KONTO ZOSTAŁO UTWORZONE.");
        }
    }

}
