package restaurant.TableManager;

public class Table {
    private final int maxReservations;
    private int currentReservations;
    private boolean available;
    private final int[] times;


    public Table(){
        maxReservations = 4;
        currentReservations = 0;
        available = true;
        times = new int[4];
    }

    public boolean addReservation(int time){
        if (checkAvailable() && times[time - 1] == 0){
            currentReservations++;
            times[time - 1] = 1;
            return true;
        }
        return false;
    }

    public boolean removeReservation(int time){
        if (currentReservations > 0 && times[time - 1] == 1){
            currentReservations--;
            times[time - 1] = 0;
            setAvailable();
            return true;
        }
        return false;
    }

    public boolean checkAvailable(){
        if (currentReservations < maxReservations){
            available = true;
        }
        else {
            available = false;
        }
        return available;
    }

    public void setAvailable(){
        available = true;
    }

    public boolean checkTimeAvailability(int timeIndex){
        if (times[timeIndex] == 0){
            return true;
        } else {
            return false;
        }

    }

}
