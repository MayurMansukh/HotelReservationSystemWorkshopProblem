package com.HotelReservationSystem;

public class Hotel {
    String hotelName;
    int Rating;
    public int weekdayrate;
    public int weekendrate;


    public Hotel(String hotelName, int weekdayrate, int weekendrate, int Rating) {
        this.hotelName = hotelName;
        this.weekdayrate = weekdayrate;
        this.weekendrate = weekendrate;
        this.Rating=Rating;
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

