package restaurant.TableManager;

public class TableManager {
    private int count;
    private Table[] tables;
    private int reservationCount;


    public TableManager(int count) {
        this.count = count;
        this.tables = new Table[count];
        reservationCount = 0;
        tableGenerator();
    }

    public void tableGenerator(){
        for(int i = 0; i < count; i++)  {
            tables[i] = new Table();
        }
    }

    public boolean addReservation(int tableNumber, int time){
        reservationCount++;
        return tables[tableNumber - 1].addReservation(time);
    }

    public boolean removeReservation(int tableNumber, int time){
        reservationCount--;
        return tables[tableNumber - 1].removeReservation(time);
    }

    public void listAvailableReservations(){
        for (int i = 0; i < count; i++){
            System.out.println("\nTable " + (i + 1));
            for (int j = 0; j < 4; j++){
                if (tables[i].checkTimeAvailability(j)){
                    System.out.println(timeTransformer(j) + " - " + (j + 1));
                }
            }
        }
    }

    public void listBookedReservations(){
        if (reservationCount == 0){
            return;
        }
        for (int i = 0; i < count; i++){
            System.out.println("Table " + (i + 1));
            for (int j = 0; j < 4; j++){
                if (!(tables[i].checkTimeAvailability(j))){
                    System.out.println(timeTransformer(j));
                }
            }
        }
    }

    public int getTableCount(){
        return this.count;
    }

    public String timeTransformer(int j){
        String time = "21:00";
        if (j == 0){
            time = "12:00";
        } else if (j == 1){
            time = "15:00";
        } else if (j == 2){
            time = "18:00";
        }
        return time;
    }
}
