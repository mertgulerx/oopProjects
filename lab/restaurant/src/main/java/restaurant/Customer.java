package restaurant;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final String surname;
    private final ArrayList<Reservation> reservations;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }


    @Override
    public String toString(){
        StringBuilder myReservations = new StringBuilder();
        for (Reservation reservation: reservations){
            myReservations.append(reservation).append("; ");
        }
        return "\nReservations of " + name + " " + surname + ": " + myReservations + "\n";
    }

}
