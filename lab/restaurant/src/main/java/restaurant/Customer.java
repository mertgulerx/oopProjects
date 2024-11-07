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

    public void removeReservation(int number){
        reservations.remove(number - 1);
    }

    public Reservation getReservation(int number){
        return reservations.get(number - 1);
    }

    public int getReservationCount(){
        return reservations.size();
    }

    public StringBuilder listReservations(){
            StringBuilder myReservations = new StringBuilder();
            for (Reservation reservation: reservations){
                myReservations.append(reservation).append("; ");
            }
        return myReservations;
    }


    @Override
    public String toString(){

        return "\nReservations of " + name + " " + surname + ": " + listReservations() + "\n";
    }

}
