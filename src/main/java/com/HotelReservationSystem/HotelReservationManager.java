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

    public Hotel chepeatestHotelListWeekdayRate(LocalDate date1, LocalDate date2){ //find cheapest hotel
        long days= ChronoUnit.DAYS.between(date1,date2);
        Hotel min= Collections.min(hotels, Comparator.comparing(hotel->hotel.weekdayrate));
        int cheaprate;
        cheaprate=(int)(days* min.weekdayrate);
        System.out.println("Cheapest Hotel Name: "+ min.hotelName + "\nTotal Rate: "+cheaprate);
        return min;
    }//cHLW

    public Hotel chepeatestHotelListWeekEndRate(LocalDate date1, LocalDate date2){ //find cheapest hotel
        long days= ChronoUnit.DAYS.between(date1,date2);
        Hotel min2= Collections.min(hotels, Comparator.comparing(hotel->hotel.weekendrate));
        int cheaprate;
        cheaprate=(int)(days* min2.weekendrate);
        System.out.println("Cheapest Hotel Name: "+ min2.hotelName + "\nTotal Rate: "+cheaprate);
        return min2;
    }//cHLW


}//class

