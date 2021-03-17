package com.HotelReservationSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelReservationManager {
    public static ArrayList<Hotel> hotels = new ArrayList<>(); //create Arraylist to add hotels
    public ArrayList<Hotel> addHotel(Hotel hotel){ // create addhotel method to add hotelName in list
        hotels.add(hotel);
        return hotels;

    }//ArrayList

    public Hotel chepeatestHotelList(LocalDate date1, LocalDate date2){ //find cheapest hotel
        long days= ChronoUnit.DAYS.between(date1,date2);
        Hotel min= Collections.min(hotels, Comparator.comparing(hotelInfo->hotelInfo.rate));
        int cheaprate;
        cheaprate=(int)(days* min.rate);
        System.out.println("Cheapest Hotel Name: "+ min.hotelName + "\nTotal Rate: "+cheaprate);
        return min;
    }//cHL

}//class

