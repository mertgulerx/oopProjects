package RestaurantReservation;

public class Reservation {
    private Customer customer;
    private final int table;
    private final int time;
    private final int people;

    public Reservation(Customer customer, int table, int time,int people) {
        this.customer = customer;
        this.table = table;
        this.time = time;
        this.people = people;
    }

    public int getTable(){
        return this.table;
    }

    public int getTime(){
        return this.time;
    }


    public String timeTransformer(int j){
        String time = "21:00";
        if (j - 1 == 0){
            time = "12:00";
        } else if (j - 1 == 1){
            time = "15:00";
        } else if (j - 1 == 2){
            time = "18:00";
        }
        return time;
    }

    @Override
    public String toString(){
        return "Table " + table + ", Time " + timeTransformer(time) + " for " + people + " persons";
    }
}
