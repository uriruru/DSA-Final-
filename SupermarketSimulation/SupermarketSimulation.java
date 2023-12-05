package list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SupermarketSimulation {
    static class Customer {
        int id;
        int arrivalTime;
        int serviceTime;

        public Customer(int id, int arrivalTime, int serviceTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.serviceTime = serviceTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Queue<Customer> queue = new LinkedList<>(); // the queue line of the customer
        int currentTime = 0; // your ticking clock
        int customerCounter = 1; // counter for the number of customers
        Random rand = new Random();
        int checkout = 0; // to check whether there is a customer in the counter, 0 no customer, 1 with customer
        int maxTime = 720; // maxTime of the simulation
        int customerAtCounter = 0; // to check which customer currently at the counter/cashier
        int arrivalTime = 0; // arrival time of the next customer
        int serviceTime = 0; // service time of the current customer
        int totalCustomersServed = 0;

        System.out.println("Supermarket Simulation test run for 720 minutes");
        arrivalTime = rand.nextInt(4) + 1; // arrival of the first time of the first customer.
        System.out.println();
        System.out.println("Time:" + currentTime); // display of the current time
        System.out.println("serviceTime:  " + serviceTime + "  arrivalTime: " + arrivalTime); // display of the service
        // time and arrival time
        System.out.println();

        // Supermarket simulation starts here...
        while (currentTime <= maxTime) {

            // if statement for arrival of a new customer
            if (currentTime == arrivalTime) {
                // Added a new customer to the queue with a random service time
                Customer newCustomer = new Customer(customerCounter, currentTime, rand.nextInt(6) + 1);
                queue.add(newCustomer);
                System.out.println("Customer " + customerCounter + " arrived at time " + currentTime);
                customerCounter++;
                arrivalTime = currentTime + rand.nextInt(4) + 1; // Set the arrival time for the next customer
            }

            if (checkout == 0 && !queue.isEmpty()) {
                // If the counter is free and there are customers in the queue, start serving the
                // next customer
                Customer currentCustomer = queue.poll();
                serviceTime = currentTime + currentCustomer.serviceTime;
                checkout = 1;
                customerAtCounter = currentCustomer.id;
                System.out.println("Customer " + currentCustomer.id + " started service at time " + currentTime
                        + " with service time " + currentCustomer.serviceTime);
            }

            if (currentTime == serviceTime) {
                // If the service time is reached, finish serving the customer
                checkout = 0;
                totalCustomersServed++;
                System.out.println("Customer " + customerAtCounter + " finished service at time " + currentTime);
            }

            currentTime++;
            System.out.println();
            System.out.println("Time:" + currentTime);
            System.out.println("serviceTime:  " + serviceTime + "  arrivalTime: " + arrivalTime);
            System.out.println();
            Thread.sleep(1000);
            clearConsole();
        }

        System.out.println("Simulation ended. Total customers served: " + totalCustomersServed);
    }

    public static void clearConsole() {
        // Print 50 empty lines to "clear" the console
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
}
