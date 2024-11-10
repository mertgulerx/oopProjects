package RestaurantReservation;

import RestaurantReservation.TableManager.TableManager;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private Customer customer;
    private final TableManager manager;
    private int table;
    private int time;

    public UserInterface(Scanner scanner, TableManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {
        welcome();
        register();
        commandManager();
    }

    public void welcome() {
        System.out.println("Welcome to our restaurant.");
        System.out.println("Continuing with registration...");
    }

    public void register() {
        while (true) {
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            System.out.println("Please enter your surname: ");
            String surname = scanner.nextLine();
            if (surname.isEmpty()) {
                System.out.println("Surname cannot be empty.");
                continue;
            }
            this.customer = new Customer(name, surname);
            break;
        }
    }

    public void commandManager() {
        loop: while (true) {
            System.out.println("Please enter your command.");
            System.out.println("Available commands: add,remove,list,my,end");

            String cmd = scanner.nextLine();
            switch (cmd) {
                case "my":
                    listCustomerReservations();
                    break;
                case "list":
                    list();
                    break;
                case "remove":
                    remove();
                    break;
                case "add":
                    add();
                    break;
                case "end":
                    System.out.println("\n Goodbye!");
                    break loop;
                default:
                    System.out.println("This command is unknown\n");
            }
        }
    }

    public void add() {
        timeTableNumberManager();
        int people;
        while(true){
            System.out.println("\nFor how many people? Please note, our tables accommodate between 1 and 4 guests.");
            people = Integer.parseInt(scanner.nextLine());
            if (people < 1 || people > 4){
                System.out.println("Sorry. We cant serve " + people + " persons at one table right now. Instead please book more tables.");
            } else {
                break;
            }
        }
        if (manager.addReservation(table, time)) {
            Reservation reservation = new Reservation(customer, table, time, people);
            this.customer.addReservation(reservation);
            System.out.println("\nReservation is successfully made.\n");
        } else {
            System.out.println("\nReservation is already booked.\n");
        }
    }

    public void remove() {
        if (customer.getReservationCount() == 0){
            System.out.println("\nYou dont have any reservations.\n");
            return;
        }
        System.out.println("Your reservations: ");
        System.out.println(customer);
        System.out.println("Which one do you want to remove? (Enter number by shown order)");
        int number = Integer.parseInt(scanner.nextLine());
        if (number > 0 && manager.removeReservation(customer.getReservation(number).getTable(), customer.getReservation(number).getTime())){
            customer.removeReservation(number);
            System.out.println("\nReservation is successfully removed.\n");
        } else {
            System.out.println("Please enter a valid number. Returning to the main menu...\n");
        }
    }

    public void timeTableNumberManager() {
        while (true) {
            System.out.println("Please enter the table number:");
            table = Integer.parseInt(scanner.nextLine());
            if (table <= 0 || table > manager.getTableCount()) {
                System.out.println("You entered a non-available table number.\n");
                continue;
            }
            System.out.println("Please enter the time number: ");
            time = Integer.parseInt(scanner.nextLine());
            if (time <= 0 || time > 4) {
                System.out.println("You entered a non-available time number:\n");
                continue;
            }
            break;
        }
    }

    public void list() {
        System.out.println("Available reservations: ");
        manager.listAvailableReservations();
        System.out.println("\nBooked reservations: ");
        manager.listBookedReservations();
        System.out.println("\nTime numbers (1-4): (12:00 - 15:00 - 18:00 - 21:00)");
    }

    public void listCustomerReservations() {
        System.out.println(customer);
    }

}
