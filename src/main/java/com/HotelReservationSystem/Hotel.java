package com.HotelReservationSystem;

public class Hotel {
    String hotelName;
    int rate;
    int rating;

    public Hotel(String hotelName, int rate, int rating) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", rate=" + rate +
                ", rating=" + rating +
                '}';
    }//toString
}//class

