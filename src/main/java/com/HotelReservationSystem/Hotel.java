package com.HotelReservationSystem;

public class Hotel {
    String hotelName;
    public int weekdayrate;
    public int weekendrate;


    public Hotel(String hotelName, int weekdayrate, int weekendrate) {
        this.hotelName = hotelName;
        this.weekdayrate = weekdayrate;
        this.weekendrate = weekendrate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayrate=" + weekdayrate +
                ", weekendrate=" + weekendrate +
                '}';

    }//toString
}//class

