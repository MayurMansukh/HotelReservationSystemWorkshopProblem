package com.HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;


public class HotelReservationManager {
    public static ArrayList<Hotel> hotels = new ArrayList<>();//create Arraylist to add hotels
    public static LocalDate date1 = LocalDate.parse("2020-09-11");
    public static LocalDate date2 = LocalDate.parse("2020-09-12");
    public void addHotel(Hotel hotel){ // create addhotel method to add hotelName in list
        hotels.add(hotel);

    }//ArrayList

    public static Hotel CheapHotelByRateCustomerType(int customerType) throws InvalidException { //find cheapest best hotel for reward customer
        if(customerType < 0 || customerType >= 2)
            throw new InvalidException();
        return Collections.min(hotels, (Comparator.comparing(hotel -> hotel.weekDayRate[customerType])));
    }
    public static long totalRates( Hotel hotel, int customerType)throws InvalidException{ // get total rates of hotelwise and customer Type
        long rate = 0;
        LocalDate date = date2;
        date = date.plusDays(1);
        for(LocalDate dates = date1; dates.isBefore(dates); date = dates.plusDays(1)){
            String today = DayOfWeek.from(date).name();
            if (today.equals(SATURDAY.toString())) {
                rate += hotel.weekEndRate[customerType];
            } else if (today.equals(SUNDAY.toString())) {
                rate += hotel.weekEndRate[customerType];
            } else {
                rate += hotel.weekDayRate[customerType];
            }
        }
        return rate;
    }//totalRates

    public static TreeMap<Long, ArrayList<Hotel>> weekEndWeekDaysRates(int customerType)throws  InvalidException{ //add weekEnd or WeekDay rates by Customer Type
        TreeMap<Long, ArrayList<Hotel>> hotelRates = new TreeMap<>();
        for (Hotel hotel: hotels){
            long rate = totalRates(hotel, customerType);

            ArrayList<Hotel> thisRateHotel = hotelRates.get(rate);
            if(thisRateHotel == null){
                thisRateHotel = new ArrayList<>();
            }
            thisRateHotel.add(hotel);
            hotelRates.put(rate, thisRateHotel);
        }
        return hotelRates;

    }//wEWDR
    public static void showCheapHotel(int customerType )throws InvalidException{ //show Cheapest hotel by customerType

        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        System.out.print("\ncheapest hotels are " );
        boolean seen = false;
        Long best = null;
        for (Long aLong : hotelRates.keySet()) {
            if (!seen || aLong < best) {
                seen = true;
                best = aLong;
            }
        }
        long minRate;
        if (seen) minRate = Optional.of(best).get();
        else minRate = Optional.<Long>empty().get();

        for (Hotel hotel: hotelRates.get(minRate)){
            System.out.print(hotel.hotelName + " ");
        }
        System.out.println("cheapest hotels are with rate: "+ minRate);
    }//sCH

    public static Hotel cheapestHotelByRating(int customerType)throws InvalidException{ //show cheapest hotel by customer type or rating

        TreeMap<Long, ArrayList<Hotel>> hotelRates = weekEndWeekDaysRates(customerType);
        boolean seen = false;
        Long best = null;
        for (Long aLong : hotelRates.keySet()) {
            if (!seen || aLong < best) {
                seen = true;
                best = aLong;
            }
        }
        long minRate;
        if (!seen) minRate = Optional.<Long>empty().get();
        else minRate = Optional.of(best).get();

        return hotelRates.get(minRate).stream().max(Comparator.comparing(r -> r.Rating)).get();

    }//cHBR
    public static Hotel getBestRatedHotel(){
        return hotels.stream().max(Comparator.comparing(r -> r.Rating)).get();
    }

}//class


