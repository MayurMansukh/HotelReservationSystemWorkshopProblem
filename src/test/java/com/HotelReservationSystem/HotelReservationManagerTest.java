package com.HotelReservationSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static com.HotelReservationSystem.HotelReservationManager.*;


class HotelReservationManagerTest {

    HotelReservationManager hotelReservation;

    @BeforeEach
    public void setup(){
        hotelReservation=new HotelReservationManager();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

    }
    Hotel lakewood = new Hotel("Lakewood", 3,100, 120, 80, 80);
    Hotel bridgewood = new Hotel("Bridgewood", 4,200, 240, 110, 50);
    Hotel ridgewood = new Hotel("Ridgewood", 5,300 , 350, 100, 40);

    @Test
    public void testAddHotel(){

        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

        System.out.println("Welcome To Hotel Reservayion System");
        hotels.forEach(System.out::println);
   }

    @Test
    public void getCheapestHotelByRatesRegular()throws InvalidException {
        Assertions.assertEquals(lakewood, cheapHotelByRate(Hotel.REWARD_CUSTOMER));
        showCheapHotel(Hotel.REWARD_CUSTOMER);

    }

    @Test
    public void getCheapestHotelByRatingsRegularTest() throws InvalidException {
        Hotel  cheapestHotelByRatings = HotelReservationManager.cheapestHotelByRating(Hotel.REWARD_CUSTOMER);
        Assertions.assertEquals(bridgewood, cheapestHotelByRatings);
        System.out.println("Cheapest hotel by rating: " + cheapestHotelByRatings.hotelName);
    }

    @Test
    public void getBestRatedHotelRegularTest()throws InvalidException {
        Assertions.assertEquals(ridgewood, getBestRatedHotel());
        System.out.println(MessageFormat.format("Best rated Hotel: {0}  total Rate:  {1}", getBestRatedHotel().hotelName, totalRates(getBestRatedHotel(), Hotel.REWARD_CUSTOMER)));
    }

}//class