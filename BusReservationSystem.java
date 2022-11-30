/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author Taimoor
 */
//Abstract class for a Bus 
abstract class Bus {
    // information hiding by making the fields private
    private String busNumber;
    private int numSeats;
    private String busType;
    
    // Constructor
    public Bus(String busNumber, int numSeats, String busType) {
        this.busNumber = busNumber;
        this.numSeats = numSeats;
        this.busType = busType;
    }

//getters and setters
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    // Abstract method for reserving a seat
    public abstract void reserveSeat();

}

//Class for LuxuryBus which extends Bus
public class LuxuryBus extends Bus {
  
    // Constructor
    public LuxuryBus(String busNumber, int numSeats, String busType){
        super(busNumber, numSeats, busType);
    }

    //Implementation of reserveSeat method
    @Override
    public void reserveSeat() {
        System.out.println("Reserving a Luxury Bus seat...");
    }
}

//Class for StandardBus which extends Bus
class StandardBus extends Bus {
  
    // Constructor
    public StandardBus(String busNumber, int numSeats, String busType){
        super(busNumber, numSeats, busType);
    }

    //Implementation of reserveSeat method
    @Override
    public void reserveSeat() {
        System.out.println("Reserving a Standard Bus seat...");
    }
}

// Interface for Bus Reservation System
public interface BusReservationSystem {
    // Method for reserving a seat
    public void reserveSeat();
    // Method for cancellation of a ticket
    public void cancelTicket();
}

//Class for Bus Reservation System which implements the BusReservationSystem interface
class BusReservationSystemImpl implements BusReservationSystem {
    
    // Field for bus
    private Bus bus;
    
    // Constructor
    public BusReservationSystemImpl(Bus bus) {
        this.bus = bus;
    }
  
    // Implementing the reserveSeat method
    @Override
    public void reserveSeat() {
        bus.reserveSeat();
    }

    // Implementing the cancelTicket method
    @Override
    public void cancelTicket() {
        System.out.println("Cancelling the ticket...");
    }
}

//Driver Class
class BusReservationSystemTest {
    public static void main(String[] args) {
        // Creation of a LuxuryBus object
        Bus luxuryBus = new LuxuryBus("AB1234", 56, "Luxury");

        // Creation of a StandardBus object
        Bus standardBus = new StandardBus("CD5678", 45, "Standard");

        // Creation of a BusReservationSystemImpl object with the LuxuryBus object
        BusReservationSystem brsLuxuryBus = new BusReservationSystemImpl(luxuryBus);

        // Creation of a BusReservationSystemImpl object with the StandardBus object
        BusReservationSystem brsStandardBus = new BusReservationSystemImpl(standardBus);

        // Calling the reserveSeat method for LuxuryBus and StandardBus
        brsLuxuryBus.reserveSeat();
        brsStandardBus.reserveSeat();

        // Calling the cancelTicket method for LuxuryBus and StandardBus
        brsLuxuryBus.cancelTicket();
        brsStandardBus.cancelTicket();

    }
}
