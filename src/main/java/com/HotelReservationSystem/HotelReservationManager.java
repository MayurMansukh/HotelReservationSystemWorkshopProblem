package com.HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;


public class HotelReservationManager {
    public static ArrayList<Hotel> hotels = new ArrayList<>();//create Arraylist to add hotels
    public static LocalDate date1 = LocalDate.parse("2020-09-11");
    public static LocalDate date2 = LocalDate.parse("2020-09-12");
    public ArrayList<Hotel> addHotel(Hotel hotel){ // create addhotel method to add hotelName in list
        hotels.add(hotel);
        return hotels;

    }//ArrayList

    public static TreeMap<Long, ArrayList<Hotel>> weekEndORWeekDaysRates(LocalDate date1, LocalDate date2 ){
        TreeMap<Long, ArrayList<Hotel>> hotelRates = new TreeMap<>();  //Find cheapest hotel based on weekday or weekendDay
        date2 = date2.plusDays(1);
        for (Hotel hotel: hotels){
            long rate = 0;
            for(LocalDate date = date1; date.isBefore(date2); date = date.plusDays(1)){
                String today = DayOfWeek.from(date).name();
                if(today.equals(DayOfWeek.SATURDAY.toString()) || today.equals(DayOfWeek.SUNDAY.toString()) ) {
                    rate += hotel.weekendrate;
                }else {
                    rate+= hotel.weekdayrate;
                }
            }
            ArrayList<Hotel> thisRateHotel = hotelRates.get(rate);
            if(thisRateHotel == null){
                thisRateHotel = new ArrayList<>();
            }
            thisRateHotel.add(hotel);
            hotelRates.put(rate, thisRateHotel);
        }
        return hotelRates;

    }//WEOWDR


    public static Object cheapHotelWeekday(){ //show cheapest hotel with total rate
        LocalDate date1 = LocalDate.parse("2020-09-11");
        LocalDate date2 = LocalDate.parse("2020-09-12");
        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndORWeekDaysRates(date1,date2);
        System.out.print("\ncheapest hotels are " );
        long min = hotelRates.keySet().stream().min(Long::compare).get();
        for (Hotel hotel: hotelRates.get(min)){
            System.out.print(hotel.hotelName + " ");
        }
        System.out.println("with rate: "+ min);

        return min;

    }//cHW
    public static Hotel cheapestHotelByRating() { //find cheapest hotel by rating
         LocalDate date1 = LocalDate.parse("2020-09-11");
            LocalDate date2 = LocalDate.parse("2020-09-12");
            TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndORWeekDaysRates(date1, date2);
            long minRate = hotelRates.keySet().stream().min(Long::compare).get();
            return hotelRates.get(minRate).stream().max(Comparator.comparing(r -> r.Rating)).get();

        }
    public static Hotel bestRatedHotel(){
        return hotels.stream().max((R1, R2 ) -> ((Integer)R1.Rating).compareTo(((Integer)R2.Rating))).get();

    }

    public static long totalRates( Hotel hotel){
        long rate = 0;
        LocalDate dx =date1;
        dx = dx.plusDays(1);
        for(LocalDate date = date1; date.isBefore(dx); date = date.plusDays(1)){
            String today = DayOfWeek.from(date).name();
            if(today.equals(DayOfWeek.SATURDAY.toString()) || today.equals(DayOfWeek.SUNDAY.toString()) ) {
                rate += hotel.weekendrate;
            }else {
                rate+= hotel.weekdayrate;
            }
        }
        return rate;
    }

}//class


