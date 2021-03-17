package com.HotelReservationSystem;

import java.util.ArrayList;

public class HotelReservationManager {
    public static ArrayList<Hotel> hotels = new ArrayList<>(); //create Arraylist to add hotels
    public ArrayList<Hotel> addHotel(Hotel hotel){ // create addhotel method to add hotelName in list
        hotels.add(hotel);
        return hotels;

    }//ArrayList

}//class

